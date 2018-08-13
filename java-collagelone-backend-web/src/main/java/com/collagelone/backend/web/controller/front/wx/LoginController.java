package com.collagelone.backend.web.controller.front.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collagelone.backend.api.dto.wx.ReqUserInfoDto;
import com.collagelone.backend.api.service.front.wx.WxLoginService;
import com.collagelone.backend.web.controller.BaseController;
import com.lonedog.platform.common.dto.AjaxResult;
import com.lonedog.platform.common.dto.Result;
/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.web.controller.front.wx.LoginController</li>
 * <li>创建时间 : 2018年8月13日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 用户登陆及信息交互入口
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Controller
public class LoginController extends BaseController{
  @Autowired
  WxLoginService wxLoginService;
  @RequestMapping(path="/wx/{codeNo}/login.html")
  @ResponseBody
  public AjaxResult login(@PathVariable("codeNo") String codeNo){
    Result<Void> result = wxLoginService.login(codeNo);
    return putAjaxData(result.isSuccess() ? 1 : 0,result.getDescription(),null);
  }
  @RequestMapping(path="/wx/{codeNo}/updateInfo.html")
  @ResponseBody
  public AjaxResult updateInfo(@PathVariable("codeNo") String codeNo,ReqUserInfoDto reqUserInfo){
    Result<Void> result = wxLoginService.updateInfo(codeNo,reqUserInfo);
    return putAjaxData(result.isSuccess() ? 1 : 0,result.getDescription(),null);
  }
}
