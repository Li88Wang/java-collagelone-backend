package com.collagelone.backend.web.controller.front.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collagelone.backend.api.dto.wx.OrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoListDto;
import com.collagelone.backend.api.dto.wx.ReqUpdateStatusDto;
import com.collagelone.backend.api.dto.wx.ResOrderInfoListDto;
import com.collagelone.backend.api.service.front.wx.WxOrderService;
import com.collagelone.backend.web.controller.BaseController;
import com.lonedog.platform.common.dto.AjaxResult;
import com.lonedog.platform.common.dto.Result;
import com.lonedog.platform.common.dto.SupportResult;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.web.controller.front.wx.OrderController</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 订单信息发布接口
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Controller
public class OrderController extends BaseController{
  @Autowired
  WxOrderService wxOrderService;
  @RequestMapping(path="/wx/order/list.html")
  @ResponseBody
  public AjaxResult list(ReqOrderInfoListDto reqData){
    Result<ResOrderInfoListDto> result = wxOrderService.list(reqData);
    return SupportResult.toAjaxResult(result);
  }
  @RequestMapping(path="/wx/order/edit.html")
  @ResponseBody
  public AjaxResult edit(ReqOrderInfoDto reqData){
    Result<OrderInfoDto> result = wxOrderService.edit(reqData);
    return SupportResult.toAjaxResult(result);
  }
  @RequestMapping(path="/wx/order/updateStatus.html")
  @ResponseBody
  public AjaxResult updateStatus(ReqUpdateStatusDto reqData){
    Result<Void> result = wxOrderService.updateStatus(reqData);
    return SupportResult.toAjaxResult(result);
  }
}
