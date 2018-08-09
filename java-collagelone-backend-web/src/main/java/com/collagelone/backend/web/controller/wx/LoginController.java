package com.collagelone.backend.web.controller.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collagelone.backend.api.service.front.wx.WxLoginService;
import com.collagelone.backend.web.controller.BaseController;
import com.lonedog.platform.common.dto.AjaxResult;
import com.lonedog.platform.common.dto.Result;
@Controller
public class LoginController extends BaseController{
  @Autowired
  WxLoginService wxLoginService;
  @RequestMapping(path="/wx/{codeNo}/login")
  @ResponseBody
  public AjaxResult login(@PathVariable("codeNo") String codeNo){
    Result<Void> result = wxLoginService.login(codeNo);
    return putAjaxData(result.isSuccess() ? 1 : 0,result.getDescription(),null);
  }
}
