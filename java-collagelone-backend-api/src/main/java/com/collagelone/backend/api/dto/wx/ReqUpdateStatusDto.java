package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;

import com.collagelone.backend.api.ReqPageInfoDto;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqUpdateStatusDto</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 修改订单状态
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ReqUpdateStatusDto implements Serializable{
  private static final long serialVersionUID = 1L;
  /**
   * 主键ID
   */
  private Long id;

  /**
   * 用户ID
   */
  private Long userId;
  /**
   * 发布类型
   */
  private Byte orderType;

  /**
   * 状态
   */
  private Byte orderStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Byte getOrderType() {
    return orderType;
  }

  public void setOrderType(Byte orderType) {
    this.orderType = orderType;
  }

  public Byte getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Byte orderStatus) {
    this.orderStatus = orderStatus;
  }
  
}
