package com.collagelone.backend.dao.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable{

	private Date createTime;

	private Date updateTime;

	private String createGuid;
	
	private Byte del;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateGuid() {
		return createGuid;
	}

	public void setCreateGuid(String createGuid) {
		this.createGuid = createGuid;
	}

	
	public Byte getDel() {
      return del;
    }

    public void setDel(Byte del) {
      this.del = del;
    }

  @Override
	public String toString() {
		return org.apache.commons.lang.builder.ReflectionToStringBuilder.toString(this);
	}

}
