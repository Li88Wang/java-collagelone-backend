package com.collagelone.backend.dao.entity;


public class CollageUser extends BaseEntity {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 显示名称
     */
    private String showName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 应用对应的用户id
     */
    private String openId;
    /**
     * 平台对应的用户id
     */
    private String unionId;
    
    /**
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 性别
     */
    private Byte gender;
    /**
     * 城市
     */
    private String city;
    /**
     * province
     */
    private String province;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOpenId() {
      return openId;
    }

    public void setOpenId(String openId) {
      this.openId = openId;
    }

    public String getUnionId() {
      return unionId;
    }

    public void setUnionId(String unionId) {
      this.unionId = unionId;
    }

    public String getAvatarUrl() {
      return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
    }

    public Byte getGender() {
      return gender;
    }

    public void setGender(Byte gender) {
      this.gender = gender;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getProvince() {
      return province;
    }

    public void setProvince(String province) {
      this.province = province;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickName=").append(nickName);
        sb.append(", showName=").append(showName);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", gender=").append(gender);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append("]");
        return sb.toString();
    }
}