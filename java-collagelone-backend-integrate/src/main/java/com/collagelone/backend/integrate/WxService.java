package com.collagelone.backend.integrate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.collagelone.backend.api.dto.wx.CodeSessionDto;
import com.lonedog.platform.common.exception.ProcessException;
import com.lonedog.platform.common.spring.CenterConfig;
import com.lonedog.platform.common.spring.utils.RestTemplateUtils;
import com.lonedog.platform.common.utils.GsonUtil;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.integrate.WxService</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 微信相关业务调用
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class WxService {
  private static Logger logger = LoggerFactory.getLogger(WxService.class);
  
  /**由登陆code获取session
   * @return
   */
  public static CodeSessionDto getSessionFromLoginCode(String loginCode){
    StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
    url.append("appid=").append(CenterConfig.getInstance().getAppId())
    .append("&secret=").append(CenterConfig.getInstance().getAppSecret())
    .append("&code=").append(loginCode)
    .append("&grant_type=").append("authorization_code");
    logger.info("com.collagelone.backend.integrate.WxService.getSessionFromLoginCode入参-{}",loginCode);
    String result = RestTemplateUtils.getRestTemplate().getForObject(url.toString(), String.class);
    logger.info("com.collagelone.backend.integrate.WxService.getSessionFromLoginCode出参-{}",result);
    CodeSessionDto resultObj = GsonUtil.getObjectJSON(result, CodeSessionDto.class);
    // 出错了
    if(resultObj == null || StringUtils.isEmpty(resultObj.getSessionKey())){
      throw ProcessException.toException("login获取的code码已失效");
    }
    resultObj.setCodeNo(loginCode);
    return resultObj;
  }
}
