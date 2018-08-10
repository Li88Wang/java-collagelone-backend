package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;

import com.lonedog.platform.common.dto.Result;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqUserInfoDto</li>
 * <li>创建时间 : 2018年8月10日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 微信请求的信息
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ReqUserInfoDto implements Serializable{
  private static final long serialVersionUID = 1L;
  private UserInfoDto userInfo;
  /**
   * 用于计算签名
   */
  private String rawData;
  /**
   * 签名字段
   */
  private String signature;
  public UserInfoDto getUserInfo() {
    return userInfo;
  }
  public void setUserInfo(UserInfoDto userInfo) {
    this.userInfo = userInfo;
  }
  public String getRawData() {
    return rawData;
  }
  public void setRawData(String rawData) {
    this.rawData = rawData;
  }
  public String getSignature() {
    return signature;
  }
  public void setSignature(String signature) {
    this.signature = signature;
  }
  
}
