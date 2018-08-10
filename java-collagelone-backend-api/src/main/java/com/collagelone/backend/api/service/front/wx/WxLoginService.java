package com.collagelone.backend.api.service.front.wx;

import com.collagelone.backend.api.dto.wx.ReqUserInfoDto;
import com.lonedog.platform.common.dto.Result;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.front.wx.WxLoginService</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 微信登陆接口
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public interface WxLoginService {
  /**小程序获取的code获取openId，access_key
   * @param codeNo
   * @return
   */
  Result<Void> login(String codeNo);

  /**更新用户信息
   * @param codeNo
   * @param reqUserInfo
   * @return
   */
  Result<Void> updateInfo(String codeNo,ReqUserInfoDto reqUserInfo);
}
