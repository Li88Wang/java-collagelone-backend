package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;

import com.lonedog.platform.common.dto.Result;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.CodeSessionDto</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 由code获取sessionkey
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class CodeSessionDto implements Serializable{
  private static final long serialVersionUID = 1L;
  /**
   * 微信相对本appId的唯一标识
   */
  private String openId;
  /**
   * 微信code的sessionKey
   */
  private String sessionKey;
  /**
   * 微信公众平台的联合Id
   */
  private String unionId;
  
  /**
   * 微信login获取的code
   */
  private String codeNo;
  /**兼容返回的openid
   * @param openid
   */
  public void setOpenid(String openid) {
    this.openId = openid;
  }
  public String getSessionKey() {
    return sessionKey;
  }
  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }
  /**fastjson反序列化的session_key
   * @param sessionKey
   */
  public void setSession_key(String sessionKey) {
    this.sessionKey = sessionKey;
  }
  /**兼容返回的unionid
   * @param unionid
   */
  public void setUnionid(String unionid) {
    this.unionId = unionid;
  }
  public String getCodeNo() {
    return codeNo;
  }
  public void setCodeNo(String codeNo) {
    this.codeNo = codeNo;
  }
  public String getOpenId() {
    return openId;
  }
  public void setOpenId(String openId) {
    this.openId = openId;
  }
  public String getUnionId() {
    return unionId;
  }
  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }
  
}
