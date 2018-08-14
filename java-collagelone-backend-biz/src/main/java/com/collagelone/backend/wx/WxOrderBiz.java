package com.collagelone.backend.wx;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collagelone.backend.api.OrderStatus;
import com.collagelone.backend.api.OrderType;
import com.collagelone.backend.api.PageInfo;
import com.collagelone.backend.api.dto.wx.OrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoListDto;
import com.collagelone.backend.api.dto.wx.ReqUpdateStatusDto;
import com.collagelone.backend.api.dto.wx.ResOrderInfoListDto;
import com.collagelone.backend.dao.entity.CollageOrder;
import com.collagelone.backend.dao.mapper.CollageOrderMapper;
import com.collagelone.backend.dao.mapper.CollageUserMapper;
import com.lonedog.platform.common.dto.Result;
import com.lonedog.platform.common.dto.SupportResult;
import com.lonedog.platform.common.exception.ProcessException;
import com.lonedog.platform.common.login.LoginContext;
import com.lonedog.platform.common.login.LoginContextHolder;
import com.lonedog.platform.common.utils.NumberUtils;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.wx.WxOrderBiz</li>
 * <li>创建时间 : 2018年8月14日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 订单业务
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Service
public class WxOrderBiz {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  CollageUserMapper collageUserMapper;
  @Autowired
  CollageOrderMapper collageOrderMapper;
  /**发布信息列表查询
   * @param reqData
   * @return
   */
  public Result<ResOrderInfoListDto> list(ReqOrderInfoListDto reqData) {
    validRequest(reqData);
    ResOrderInfoListDto resData = new ResOrderInfoListDto();
    // 分页
    PageInfo pager = new PageInfo(reqData.getPageNum(),reqData.getPageSize());
    int total = collageOrderMapper.getListCount(reqData);
    pager.setTotal(total);
    resData.setPagerInfo(pager);
    if(total > 0){
      List<OrderInfoDto> list = collageOrderMapper.getList(reqData,pager.getMySQLOffset(),pager.getPageSize());
      resData.setInfoList(list);
    }
    return SupportResult.<ResOrderInfoListDto>toResult(resData);
  }
  /**参数校验
   * @param reqData
   */
  private void validRequest(ReqOrderInfoListDto reqData) {
    if(reqData.getOrderType() == null){
      throw ProcessException.toException("参数无效-{}", "OrderType");
    }
    if(reqData.getOrderStatus() == null){
      throw ProcessException.toException("参数无效-{}", "OrderStatus");
    }
  }
  /**发布信息创建或编辑
   * @param reqData
   * @return
   */
  public Result<OrderInfoDto> edit(ReqOrderInfoDto reqData) {
    validEdit(reqData);
    saveOrUpdate(reqData.getInfo());
    return SupportResult.<OrderInfoDto>toResult(reqData.getInfo());
  }
  
  public void saveOrUpdate(OrderInfoDto info) {
    LoginContext loginInfo = LoginContextHolder.getLoginContext();
    if(loginInfo == null || info.getUserId() != null && info.getUserId().longValue() != loginInfo.getUserId().longValue()){
      throw ProcessException.toException("验证信息已失效");
    }
    CollageOrder entity = new CollageOrder();
    BeanUtils.copyProperties(info, entity,"orderType","orderStatus");
    if(info.getId() == null){
      entity.setOrderStatus(info.getOrderStatus());
      entity.setOrderType(info.getOrderType());
      entity.setUserId(info.getUserId());
      collageOrderMapper.insertSelective(entity);
    }else{
      collageOrderMapper.updateByPrimaryKeySelective(entity);
    }
  }
  /**参数校验
   * @param reqData
   */
  private void validEdit(ReqOrderInfoDto reqData) {
    if(reqData.getInfo() == null){
      throw ProcessException.toException("参数无效-{}", "getInfo");
    }
    if(!OrderType.contain(reqData.getInfo().getOrderType())){
      throw ProcessException.toException("参数无效-{}", "getOrderType");
    }
    if(!OrderStatus.contain(reqData.getInfo().getOrderStatus())){
      throw ProcessException.toException("参数无效-{}", "getOrderStatus");
    }
    if(StringUtils.isBlank(reqData.getInfo().getOrderAddressFrom())){
      throw ProcessException.toException("参数无效-{}", "getOrderAddressFrom");
    }
    if(StringUtils.isBlank(reqData.getInfo().getOrderAddressTo())){
      throw ProcessException.toException("参数无效-{}", "getOrderAddressTo");
    }
    if(StringUtils.isBlank(reqData.getInfo().getOrderAmount())){
      throw ProcessException.toException("参数无效-{}", "getOrderAmount");
    }
    if(StringUtils.isBlank(reqData.getInfo().getOrderPrice())){
      throw ProcessException.toException("参数无效-{}", "getOrderPrice");
    }
    if(StringUtils.isBlank(reqData.getInfo().getUserPhone())){
      throw ProcessException.toException("参数无效-{}", "getUserPhone");
    }
    if(StringUtils.isBlank(reqData.getInfo().getOrderAmountFare())){
      throw ProcessException.toException("参数无效-{}", "getOrderPrice");
    }
    if(reqData.getInfo().getOrderBeginTime() == null){
      throw ProcessException.toException("参数无效-{}", "getOrderBeginTime");
    }
    if(reqData.getInfo().getOrderEndTime() == null){
      throw ProcessException.toException("参数无效-{}", "getOrderEndTime");
    }
  }
  /**更新发布信息状态
   * @param reqData
   * @return
   */
  public Result<Void> updateStatus(ReqUpdateStatusDto reqData) {
    validUpdateStatus(reqData);
    LoginContext loginInfo = LoginContextHolder.getLoginContext();
    if(loginInfo == null || reqData.getUserId() != null && reqData.getUserId().longValue() != loginInfo.getUserId().longValue()){
      throw ProcessException.toException("验证信息已失效");
    }
    CollageOrder entity = collageOrderMapper.selectByPrimaryKey(reqData.getId());
    // 验证数据状态
    if(entity == null || entity.getUserId().longValue() != reqData.getUserId().longValue()
        || entity.getOrderType().byteValue() != reqData.getOrderType().byteValue()
        || entity.getOrderStatus().byteValue() != reqData.getOrderStatus().byteValue()
        ){
      throw ProcessException.toException("无该发布信息或数据已过期");
    }
    collageOrderMapper.updateStatusById(reqData.getOrderStatus(),entity.getId());
    return SupportResult.<Void>toResult(null);
  }
  /**参数校验
   * @param reqData
   */
  public void validUpdateStatus(ReqUpdateStatusDto reqData) {
    if(!OrderType.contain(reqData.getOrderType())){
      throw ProcessException.toException("参数无效-{}", "getOrderType");
    }
    if(!OrderStatus.contain(reqData.getOrderStatus())){
      throw ProcessException.toException("参数无效-{}", "getOrderStatus");
    }
    if(NumberUtils.isNullOrLqZero(reqData.getId())){
      throw ProcessException.toException("参数无效-{}", "getId");
    }
    if(NumberUtils.isNullOrLqZero(reqData.getUserId())){
      throw ProcessException.toException("参数无效-{}", "getUserId");
    }
  }
  
}