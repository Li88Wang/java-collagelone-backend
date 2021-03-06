package com.collagelone.backend.api;

import java.io.Serializable;

public class MiddlePager implements Serializable {
    private static final long serialVersionUID = 2859120789945167474L;
    /**
     * 页号，从1开始
     */
    private Integer pageNum;
    /**
     * 每页的大小
     */
    private Integer pageSize;
    /**
     * 总数量
     */
    private Integer total;
    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 是否获取总数
     */
    private boolean count = false;

    private boolean fetchAll = false;

    public MiddlePager() {
    }

    public MiddlePager(Integer pageNum, Integer pageSize) {
      if(pageNum != null){
        this.pageNum = pageNum;
      }
      if(pageSize != null){
        this.pageSize = pageSize;
      }
    }

    public void setPagerInfo(PageInfo page){
      this.setTotal(page.getTotal());
      this.setPageNum(page.getPageNum());
      this.setPageSize(page.getPageSize());
    }
    public MiddlePager(Integer pageNum, Integer pageSize, boolean count) {
      if(pageNum != null){
        this.pageNum = pageNum;
      }
      if(pageSize != null){
        this.pageSize = pageSize;
      }
      this.count = count;
    }

    public MiddlePager(Integer pageNum, Integer pageSize, boolean count, boolean fetchAll) {
      if(pageNum != null){
        this.pageNum = pageNum;
      }
      if(pageSize != null){
        this.pageSize = pageSize;
      }
      this.count = count;
      this.fetchAll = fetchAll;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null) {
            throw new RuntimeException("pageNum is null");
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            throw new RuntimeException("pageSize is null");
        }
        this.pageSize = pageSize;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public boolean isFetchAll() {
        return fetchAll;
    }

    public void setFetchAll(boolean fetchAll) {
        this.fetchAll = fetchAll;
    }

    @Override
    public String toString() {
        return "MiddlePager{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", count=" + count +
                ", fetchAll=" + fetchAll +
                '}';
    }
}