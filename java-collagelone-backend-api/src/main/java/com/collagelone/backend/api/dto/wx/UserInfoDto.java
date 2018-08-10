package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;

import com.lonedog.platform.common.dto.Result;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqUserInfoDto</li>
 * <li>创建时间 : 2018年8月10日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 微信用户信息
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class UserInfoDto implements Serializable{
  private static final long serialVersionUID = 1L;
  /**
   * 微信相对本appId的唯一标识
   */
  private String openId;
  /**
   * 微信公众平台的联合Id
   */
  private String unionId;
  /**
   * nickName
   */
  private String nickName;
  /**
   * 用户头像
   */
  private String avatarUrl;
  /**
   * 性别
   */
  private Byte gender;
  /**
   * 城市
   */
  private String city;
  /**
   * province
   */
  private String province;
  /**
   * country
   */
  private String country;
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public String getAvatarUrl() {
    return avatarUrl;
  }
  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getProvince() {
    return province;
  }
  public void setProvince(String province) {
    this.province = province;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public Byte getGender() {
    return gender;
  }
  public void setGender(Byte gender) {
    this.gender = gender;
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
