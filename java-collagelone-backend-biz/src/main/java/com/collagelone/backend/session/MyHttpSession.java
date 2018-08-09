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
import com.collagelone.backend.integrate.WxService;
import com.lonedog.platform.common.SystemConstant;
import com.lonedog.platform.common.spring.utils.JedisUtils;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.session.MyHttpSession</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 本项目的session处理
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
        MapSession session = JedisUtils.getInstance().<MapSession>getObject(getSessionKey(sessionId));
        // 新建session并设置失效时间
        if(session == null){
          session = new MapSession(sessionId);
          JedisUtils.getInstance().setObjectEx(getSessionKey(sessionId), session, maxInactiveIntervalInSeconds.intValue());
        }else{
          // 获取到了，那就重新设置失效时间
          JedisUtils.getInstance().expire(getSessionKey(sessionId), maxInactiveIntervalInSeconds.intValue());
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
        MapSession session = JedisUtils.getInstance().<MapSession>getObject(getSessionKey(sessionId));
        // 新建session并设置失效时间
        if(session == null){
          session = new MapSession(sessionId);
          CodeSessionDto result = WxService.getSessionFromLoginCode(sessionId);
          session.setAttribute(SystemConstant.USER_LOGIN_CODE_KEY, result);
          // 通过code获取openId，及session_key
          JedisUtils.getInstance().setObjectEx(getSessionKey(sessionId), session, maxInactiveIntervalInSeconds.intValue());
        }else{
          // 获取到了，那就重新设置失效时间
          JedisUtils.getInstance().expire(getSessionKey(sessionId), maxInactiveIntervalInSeconds.intValue());
        }
        return session;
      }
      return null;
    }
    /**入redis并更新有效时间
     * @param sessionId
     * @param session
     */
    public void serialSessionWithTtl(String sessionId,Session session) {
      JedisUtils.getInstance().setObjectEx(getSessionKey(sessionId), session, maxInactiveIntervalInSeconds.intValue());
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