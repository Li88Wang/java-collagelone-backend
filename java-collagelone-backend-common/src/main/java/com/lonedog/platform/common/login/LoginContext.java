package com.lonedog.platform.common.login;

import java.io.Serializable;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.login.LoginContext</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 登陆上下文
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class LoginContext implements Serializable {

    private static final long serialVersionUID = 8060624807484477374L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LoginContext{");
        sb.append("userId=").append(userId);
        sb.append(", act='").append(act).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", showName='").append(showName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", time=").append(time);
        sb.append(", userIp='").append(userIp).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append(", authUuid='").append(authUuid).append('\'');
        sb.append(", isLogin=").append(isLogin);
        sb.append('}');
        return sb.toString();
    }

    private Long userId;
    private String act;
    private String nickName;
    private String showName;
    private String email;
    private long time;
    private String userIp;
    /**登陆code码
     * 
     */
    private String token;
    /**
     * open_id
     */
    private String authUuid;
    private boolean isLogin = false;


    public Long getUserId() {
      return userId;
    }

    public void setUserId(Long userId) {
      this.userId = userId;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthUuid() {
        return authUuid;
    }

    public void setAuthUuid(String authUuid) {
        this.authUuid = authUuid;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}