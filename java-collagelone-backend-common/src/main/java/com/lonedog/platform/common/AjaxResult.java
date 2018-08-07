package com.lonedog.platform.common;

import java.io.Serializable;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.AjaxResult</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * ajax结果返回
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class AjaxResult implements Serializable {

    private static final long serialVersionUID = 7064954279009752789L;

    public AjaxResult() {
        super();
    }

    public AjaxResult(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = (data == null ? "" : data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AjaxResult{");
        sb.append("status='").append(status).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 成功
     **/
    public static final int STATUS_SUCCESS = 1;
    /**
     * 失败
     **/
    public static final int STATUS_FAIL = 0;
    /**
     * 失败-未登录
     **/
    public static final int STATUS_NOT_LOGIN = 2;

    private int status = STATUS_SUCCESS;

    private String message = "结果成功！";

    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}