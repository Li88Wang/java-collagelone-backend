package com.collagelone.backend.api.service.front.wx;

import com.collagelone.backend.api.dto.wx.OrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoListDto;
import com.collagelone.backend.api.dto.wx.ReqUpdateStatusDto;
import com.collagelone.backend.api.dto.wx.ReqUserInfoDto;
import com.collagelone.backend.api.dto.wx.ResOrderInfoListDto;
import com.lonedog.platform.common.dto.Result;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.service.front.wx.WxOrderService</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 小程序-订单信息发布接口
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public interface WxOrderService {

  /**订单列表信息查询
   * @param reqData
   * @return
   */
  Result<ResOrderInfoListDto> list(ReqOrderInfoListDto reqData);

  /**创建或修改发布信息内容
   * @param reqData
   * @return
   */
  Result<OrderInfoDto> edit(ReqOrderInfoDto reqData);

  /**发布更改状态
   * @param reqData
   * @return
   */
  Result<Void> updateStatus(ReqUpdateStatusDto reqData);
}
