package com.collagelone.backend.dao.entity;

import java.util.Date;

public class CollageOrder extends BaseEntity {
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

    private static final long serialVersionUID = 1L;

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

    public void setOrderAddressFrom(String orderAddressFrom) {
        this.orderAddressFrom = orderAddressFrom == null ? null : orderAddressFrom.trim();
    }

    public String getOrderAddressTo() {
        return orderAddressTo;
    }

    public void setOrderAddressTo(String orderAddressTo) {
        this.orderAddressTo = orderAddressTo == null ? null : orderAddressTo.trim();
    }

    public String getOrderAddressFromCode() {
        return orderAddressFromCode;
    }

    public void setOrderAddressFromCode(String orderAddressFromCode) {
        this.orderAddressFromCode = orderAddressFromCode == null ? null : orderAddressFromCode.trim();
    }

    public String getOrderAddressToCode() {
        return orderAddressToCode;
    }

    public void setOrderAddressToCode(String orderAddressToCode) {
        this.orderAddressToCode = orderAddressToCode == null ? null : orderAddressToCode.trim();
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
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice == null ? null : orderPrice.trim();
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount == null ? null : orderAmount.trim();
    }

    public String getOrderAmountFare() {
        return orderAmountFare;
    }

    public void setOrderAmountFare(String orderAmountFare) {
        this.orderAmountFare = orderAmountFare == null ? null : orderAmountFare.trim();
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
        this.orderMsc = orderMsc == null ? null : orderMsc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderAddressFrom=").append(orderAddressFrom);
        sb.append(", orderAddressTo=").append(orderAddressTo);
        sb.append(", orderAddressFromCode=").append(orderAddressFromCode);
        sb.append(", orderAddressToCode=").append(orderAddressToCode);
        sb.append(", orderType=").append(orderType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", orderAmountFare=").append(orderAmountFare);
        sb.append(", orderBeginTime=").append(orderBeginTime);
        sb.append(", orderEndTime=").append(orderEndTime);
        sb.append(", orderMsc=").append(orderMsc);
        sb.append("]");
        return sb.toString();
    }
}