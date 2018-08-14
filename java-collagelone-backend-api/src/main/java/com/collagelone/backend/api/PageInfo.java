package com.collagelone.backend.api;
public class PageInfo {
  public static final int DEFAULT_PAGE_SIZE = 20;
  public static final int DEFAULT_CURRENT_PAGE = 1;

  /**
   * 当前页,默认第一页
   */
  private int pageNum = DEFAULT_CURRENT_PAGE;

  /**
   * 当前页大小，默认20条
   */
  private int pageSize = DEFAULT_PAGE_SIZE;
  /**
   * 总条数
   */
  private Integer total;
  /**
   * 总页数
   */
  private Integer totalPage;
  
  public PageInfo(Integer currentPage, Integer pageSize){
    setPageParam(currentPage == null ? 0 : currentPage,pageSize == null ? 0 : pageSize);
  }
  public PageInfo(Integer currentPage, Integer pageSize,Integer total){
    setPageParam(currentPage == null ? 0 : currentPage
        ,pageSize == null ? 0 : pageSize,total == null ? 0 : total);
  }

  public void setPageParam(int currentPage, int pageSize) {
    setPageNum(currentPage);
    setPageSize(pageSize);
  }
  public void setPageParam(int currentPage, int pageSize,int total) {
    setPageNum(currentPage);
    setPageSize(pageSize);
    setTotal(total);
    
    if(this.total % this.pageSize == 0){
      setTotalPage(this.total / this.pageSize );
    }else{
      setTotalPage(this.total / this.pageSize + 1);
    }
    
  }
  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = resolveCurrentPage(pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = resolvePageSize(pageSize);
  }

  public int resolvePageSize(int pageSize) {
    if (pageSize <= 0) {
      pageSize = DEFAULT_PAGE_SIZE;
    }
    return pageSize;
  }

  public int resolveCurrentPage(int currentPage) {
    if (currentPage <= 0) {
      currentPage = 1;
    }
    return currentPage;
  }

  public int getMySQLOffset() {
    return (pageNum - 1) * pageSize;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Integer totalPage) {
    this.totalPage = totalPage;
  }



}