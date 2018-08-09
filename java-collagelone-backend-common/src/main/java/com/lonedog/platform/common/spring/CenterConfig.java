package com.lonedog.platform.common.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lonedog.platform.common.spring.utils.ApplicationContextUtils;
@Component
public class CenterConfig {
  @Value("${wx.appId}")
  private String appId;
  @Value("${wx.appSecret}")
  private String appSecret;
  
  private static CenterConfig sigletoninstance = null;
  
  public static CenterConfig getInstance(){
    if(sigletoninstance == null){
      synchronized (CenterConfig.class) {
        if(sigletoninstance == null){
          sigletoninstance = ApplicationContextUtils.getBean(CenterConfig.class);
        }
      }
    }
    return sigletoninstance;
  }
  public String getAppId() {
    return appId;
  }
  public void setAppId(String appId) {
    this.appId = appId;
  }
  public String getAppSecret() {
    return appSecret;
  }
  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }
  
  
}
