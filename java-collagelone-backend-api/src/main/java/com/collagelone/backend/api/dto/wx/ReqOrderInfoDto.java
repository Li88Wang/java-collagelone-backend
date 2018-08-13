package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;

import com.collagelone.backend.api.ReqPageInfoDto;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqOrderInfoDto</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 订单信息请求
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ReqOrderInfoDto implements Serializable{
  private static final long serialVersionUID = 1L;
  /**
   * 订单内容
   */
  private OrderInfoDto info;
  public OrderInfoDto getInfo() {
    return info;
  }
  public void setInfo(OrderInfoDto info) {
    this.info = info;
  }
  
}
