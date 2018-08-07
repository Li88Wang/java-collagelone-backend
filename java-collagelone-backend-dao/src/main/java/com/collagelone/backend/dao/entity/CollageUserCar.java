package com.collagelone.backend.dao.entity;


public class CollageUserCar extends BaseEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 车类型
     */
    private Short carType;

    /**
     * 状态
     */
    private Byte opStatus;

    /**
     * 备注
     */
    private String remark;

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

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public Short getCarType() {
        return carType;
    }

    public void setCarType(Short carType) {
        this.carType = carType;
    }

    public Byte getOpStatus() {
        return opStatus;
    }

    public void setOpStatus(Byte opStatus) {
        this.opStatus = opStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", carNo=").append(carNo);
        sb.append(", carType=").append(carType);
        sb.append(", opStatus=").append(opStatus);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}