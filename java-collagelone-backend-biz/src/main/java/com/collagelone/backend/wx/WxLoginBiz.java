package com.collagelone.backend.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

import com.collagelone.backend.api.dto.wx.CodeSessionDto;
import com.collagelone.backend.api.dto.wx.ReqUserInfoDto;
import com.collagelone.backend.dao.entity.CollageUser;
import com.collagelone.backend.dao.mapper.CollageUserMapper;
import com.collagelone.backend.integrate.WxService;
import com.collagelone.backend.session.MyHttpSession;
import com.lonedog.platform.common.SystemConstant;
import com.lonedog.platform.common.dto.Result;
import com.lonedog.platform.common.dto.SupportResult;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.auth.AuthBiz</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 授权业务
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Service
public class WxLoginBiz {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  MyHttpSession myHttpSession;
  @Autowired
  CollageUserMapper collageUserMapper;
  /**登陆
   * @param codeNo
   * @return
   */
  public Result<Void> login(String codeNo) {
    SupportResult<Void> rsOperation = SupportResult.<Void>create();
    Session session = myHttpSession.getSession(codeNo);
    if(session != null && session.getAttribute(SystemConstant.USER_LOGIN_CODE_KEY) == null){
      logger.info("com.collagelone.backend.auth.AuthBiz.login 已入档");
      return rsOperation.success();
    }
    // 当为null时设置一个
    if(session == null){
      session = myHttpSession.newSession(codeNo);
    }
    CodeSessionDto cSession = WxService.getSessionFromLoginCode(codeNo);
    myHttpSession.codeToSession(session, cSession);
    // 先存档
    CollageUser user = saveOrUpdate(cSession.getOpenId(),cSession.getUnionId());
    myHttpSession.loginToSession(session, user);
    myHttpSession.flushSession(session);
    return rsOperation.success();
  }

  /**持久化openId，unionId
   * @param openId
   * @param unionId
   * @return
   */
  public CollageUser saveOrUpdate(String openId,String unionId){
    CollageUser user = collageUserMapper.selectByOpenId(openId);
    if(user == null ){
      user = new CollageUser();
    }
    user.setOpenId(openId);
    user.setUnionId(unionId);
    saveOrUpdate(user);
    return user;
  }
  
  /**持久化用户信息
   * @param user
   */
  public void saveOrUpdate(CollageUser user){
    if(user.getId() == null){
      collageUserMapper.insertSelective(user);
    }else{
      collageUserMapper.updateByPrimaryKeySelective(user);
    }
  }

  public Result<Void> updateInfo(String codeNo,
      ReqUserInfoDto reqUserInfo) {
    SupportResult<Void> rsOperation = SupportResult.<Void>create();
    // NOTE wangzhipeng 请求信息做校验...
    // 获取session
    Session session = myHttpSession.getValidSession(codeNo);
    CodeSessionDto cSession = session.getAttribute(SystemConstant.USER_LOGIN_CODE_KEY);
    CollageUser user = collageUserMapper.selectByOpenId(cSession.getOpenId());
    // copy属性值
    BeanUtils.copyProperties(reqUserInfo.getUserInfo(), user,"openId","unionId");
    saveOrUpdate(user);
    myHttpSession.loginToSessionInFlush(session, user);
    return rsOperation.success();
  }
  
}