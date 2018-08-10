package com.collagelone.backend.session;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.MapSession;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import com.collagelone.backend.api.dto.wx.CodeSessionDto;
import com.collagelone.backend.dao.entity.CollageUser;
import com.collagelone.backend.integrate.WxService;
import com.lonedog.platform.common.SystemConstant;
import com.lonedog.platform.common.login.LoginContext;
import com.lonedog.platform.common.spring.utils.JedisUtils;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.session.MyHttpSession</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 本项目的session处理
 * 注 本文都是sessionid为key
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Service
public class MyHttpSession {
 
    private final Logger LOGGER = LoggerFactory.getLogger(MyHttpSession.class);
    @Value("${redis.session.idName}")
    private String sessionIdName;
    @Value("${redis.session.maxInactiveIntervalInSeconds}")
    private Long maxInactiveIntervalInSeconds;
    /**session的mapkey
     * 
     */
    private String sessionkey = "collagelone:wx:mysession";
    
    /**通过request获取封装的session
     * @param request
     * @return
     */
    public Session getSession(HttpServletRequest request) {
      String sessionId = request.getParameter(sessionIdName);
      return getSession(sessionId);
    }
    /**通过sessionId获取封装的session
     * @param request
     * @return
     */
    public Session getSession(String sessionId) {
      // 存在sessionId则获取session，否则新建一个session
      if(StringUtils.isNotBlank(sessionId)){
        Session session = JedisUtils.getInstance().<MapSession>getObject(getSessionKey(sessionId));
        // 新建session并设置失效时间
        if(session == null){
          session = newSession(sessionId);
          flushSession(session);
        }else{
          // 获取到了，那就重新设置失效时间
          flushSession(sessionId);
        }
        return session;
      }
      return null;
    }
    
    public Session newSession(String sessionId){
      return new MapSession(sessionId); 
    }
    /**通过sessionId获取有效的封装的session
     * @param request
     * @return
     */
    public Session getValidSession(String sessionId) {
      // 存在sessionId则获取session，否则新建一个session
      if(StringUtils.isNotBlank(sessionId)){
        Session session = JedisUtils.getInstance().<MapSession>getObject(getSessionKey(sessionId));
        // 新建session并设置失效时间
        if(session == null){
          session = newSession(sessionId);
          // code码信息到session
          codeToSession(session,sessionId);
          // 通过code获取openId，及session_key
          flushSession(session);
        }else{
          // 获取到了，那就重新设置失效时间
          flushSession(sessionId);
        }
        return session;
      }
      return null;
    }
    /**code 2 session
     * @param session
     * @param codeNo
     */
    public void codeToSession(Session session,CodeSessionDto result){
      session.setAttribute(SystemConstant.USER_LOGIN_CODE_KEY, result);
    }
    /**code 2 session
     * @param session
     * @param codeNo
     */
    public void codeToSession(Session session,String codeNo){
      CodeSessionDto result = WxService.getSessionFromLoginCode(codeNo);
      codeToSession(session,result);
    }
    /**code 2 session,to redis
     * @param session
     * @param codeNo
     */
    public void codeToSessionInFlush(Session session,String codeNo){
      codeToSession(session,codeNo);
      flushSession(session);
    }
    /**login 2 session,to redis
     * @param session
     */
    public void loginToSessionInFlush(Session session,CollageUser userInfo){
      loginToSession(session,userInfo);
      flushSession(session);
    }
    /**login 2 session
     * @param session
     */
    public void loginToSession(Session session,CollageUser userInfo){
      LoginContext context = convertToLoginContext(userInfo);
      loginToSession(session,context);
    }
    /**flush session 用key
     * @param session
     */
    public void flushSession(String sessionId){
      JedisUtils.getInstance().expire(getSessionKey(sessionId), maxInactiveIntervalInSeconds.intValue());
    }
    /**flush session 到redis
     * @param session
     */
    public void flushSession(Session session){
      JedisUtils.getInstance().setObjectEx(getSessionKey(session.getId()), session, maxInactiveIntervalInSeconds.intValue());
    }
    /**登陆上下文放到session里
     * @param session
     * @param context
     */
    public void loginToSession(Session session,LoginContext context){
      context.setToken(session.getId());
      session.setAttribute(SystemConstant.USER_INFO_KEY, context);
    }
    /**组装登陆上下文
     * @param userInfo
     * @return
     */
    public LoginContext convertToLoginContext(CollageUser userInfo){
      LoginContext context = new LoginContext();
      context.setNickName(userInfo.getNickName());
      context.setUserId(userInfo.getId());
      context.setAct(userInfo.getAvatarUrl());
      context.setAuthUuid(userInfo.getOpenId());
      context.setEmail(userInfo.getEmail());
      context.setShowName(userInfo.getShowName());
      context.setTime(System.currentTimeMillis());
      context.setLogin(true);
      return context;
    }
    String getSessionKey(String sessionId){
      return sessionkey + ":" + sessionId;
    }
    public String getSessionIdName() {
      return sessionIdName;
    }
    public void setSessionIdName(String sessionIdName) {
      this.sessionIdName = sessionIdName;
    }

    public Long getMaxInactiveIntervalInSeconds() {
      return maxInactiveIntervalInSeconds;
    }

    public void setMaxInactiveIntervalInSeconds(
        Long maxInactiveIntervalInSeconds) {
      this.maxInactiveIntervalInSeconds =
          maxInactiveIntervalInSeconds;
    }
    
}