package com.collagelone.backend.api.dto.wx;

import com.collagelone.backend.api.ReqPageInfoDto;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqOrderInfoDto</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 请求订单info条件
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ReqOrderInfoListDto extends ReqPageInfoDto{
  private static final long serialVersionUID = 1L;
  /**
   * 订单类型
   */
  private Byte orderType;
  public Byte getOrderType() {
    return orderType;
  }
  public void setOrderType(Byte orderType) {
    this.orderType = orderType;
  }
}
