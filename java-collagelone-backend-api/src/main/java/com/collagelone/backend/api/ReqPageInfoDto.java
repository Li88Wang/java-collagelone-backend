package com.collagelone.backend.api;

import java.io.Serializable;
public class ReqPageInfoDto implements Serializable{
  private static final long serialVersionUID = 1L;
  /**
   * 每页记录数
   */
  private Integer pageSize;
  /**
   * 当前页码
   */
  private Integer pageNum;
  
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  public Integer getPageNum() {
    return pageNum;
  }
  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }
  
}
