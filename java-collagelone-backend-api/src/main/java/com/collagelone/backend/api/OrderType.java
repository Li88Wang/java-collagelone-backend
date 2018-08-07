package com.collagelone.backend.api;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.OrderType</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 发布信息类型
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public enum OrderType {
  DEFAULT(""),
  RZC("人找车"),CZR("车找人"),HZC("货找车"),CZH("车找货");
  
  OrderType(String nameMsc){
    this.nameMsc = nameMsc;
  }
  private String nameMsc;
  public String getNameMsc() {
    return nameMsc;
  }
  public void setNameMsc(String nameMsc) {
    this.nameMsc = nameMsc;
  }
}
