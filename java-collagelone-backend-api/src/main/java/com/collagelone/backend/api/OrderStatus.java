package com.collagelone.backend.api;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.OrderStatus</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 订单状态
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public enum OrderStatus{
  DEFAULT(""),
  DS("待审"),FBZ("发布中"),XJ("下架");
  
  OrderStatus(String nameMsc){
    this.nameMsc = nameMsc;
  }
  private String nameMsc;
  public String getNameMsc() {
    return nameMsc;
  }
  public void setNameMsc(String nameMsc) {
    this.nameMsc = nameMsc;
  }
  
  /**是否包含状态点
   * @param b
   * @return
   */
  public static boolean contain(Byte b){
    if(b == null){
      return false;
    }
    return b <= XJ.ordinal() && b >= 0;
  }
}
