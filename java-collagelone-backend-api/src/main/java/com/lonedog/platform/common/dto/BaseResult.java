package com.lonedog.platform.common.dto;

import java.io.Serializable;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.dto.BaseResult</li>
 * <li>创建时间 : 2018年8月9日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 基础返回类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class BaseResult implements Serializable{
	
	private static final long serialVersionUID = -4496867430298036980L;
	/**
	 * 请求标识号
	 */
	private String sid;
	
	/** 成功标志*/
	private boolean success;
	
	/** 信息码 */
	private String code;
	
	/** 描述 */
	private String description;
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 是否已经失败
	 * @return
	 */
	public boolean isFailed() {
		return !success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}