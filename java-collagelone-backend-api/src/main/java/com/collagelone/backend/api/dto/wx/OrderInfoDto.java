package com.collagelone.backend.api.dto.wx;

import java.io.Serializable;
import java.util.Date;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.OrderInfoDto</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 订单信息发布
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class OrderInfoDto implements Serializable{
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
   * 始发地
   */
  private String orderAddressFrom;

  /**
   * 目的地
   */
  private String orderAddressTo;

  /**
   * 始发地编码
   */
  private String orderAddressFromCode;

  /**
   * 目的地编码
   */
  private String orderAddressToCode;

  /**
   * 发布类型
   */
  private Byte orderType;

  /**
   * 状态
   */
  private Byte orderStatus;

  /**
   * 发布者手机号
   */
  private String userPhone;

  /**
   * 价格
   */
  private String orderPrice;

  /**
   * 总量(座位数，吨数)
   */
  private String orderAmount;

  /**
   * 剩余(座位数，吨数)
   */
  private String orderAmountFare;

  /**
   * 开始日期
   */
  private Date orderBeginTime;

  /**
   * 结束日期
   */
  private Date orderEndTime;

  /**
   * 备注
   */
  private String orderMsc;

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

  public String getOrderAddressFrom() {
    return orderAddressFrom;
  }

  public void setOrderAddressFrom(
      String orderAddressFrom) {
    this.orderAddressFrom = orderAddressFrom;
  }

  public String getOrderAddressTo() {
    return orderAddressTo;
  }

  public void setOrderAddressTo(
      String orderAddressTo) {
    this.orderAddressTo = orderAddressTo;
  }

  public String getOrderAddressFromCode() {
    return orderAddressFromCode;
  }

  public void setOrderAddressFromCode(
      String orderAddressFromCode) {
    this.orderAddressFromCode =
        orderAddressFromCode;
  }

  public String getOrderAddressToCode() {
    return orderAddressToCode;
  }

  public void setOrderAddressToCode(
      String orderAddressToCode) {
    this.orderAddressToCode = orderAddressToCode;
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

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(String orderPrice) {
    this.orderPrice = orderPrice;
  }

  public String getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(String orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getOrderAmountFare() {
    return orderAmountFare;
  }

  public void setOrderAmountFare(
      String orderAmountFare) {
    this.orderAmountFare = orderAmountFare;
  }

  public Date getOrderBeginTime() {
    return orderBeginTime;
  }

  public void setOrderBeginTime(Date orderBeginTime) {
    this.orderBeginTime = orderBeginTime;
  }

  public Date getOrderEndTime() {
    return orderEndTime;
  }

  public void setOrderEndTime(Date orderEndTime) {
    this.orderEndTime = orderEndTime;
  }

  public String getOrderMsc() {
    return orderMsc;
  }

  public void setOrderMsc(String orderMsc) {
    this.orderMsc = orderMsc;
  }

}
