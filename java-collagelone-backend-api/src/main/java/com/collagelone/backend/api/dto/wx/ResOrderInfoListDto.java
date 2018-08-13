package com.collagelone.backend.api.dto.wx;

import java.util.List;

import com.collagelone.backend.api.MiddlePager;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.api.dto.wx.ReqOrderInfoDto</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 请求订单info条件
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ResOrderInfoListDto extends MiddlePager{
  private static final long serialVersionUID = 1L;
  
  /**
   * 订单列表内容
   */
  private List<OrderInfoDto> infoList;

  public List<OrderInfoDto> getInfoList() {
    return infoList;
  }

  public void setInfoList(
      List<OrderInfoDto> infoList) {
    this.infoList = infoList;
  }
}
