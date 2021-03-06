package com.collagelone.backend.service.front.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collagelone.backend.api.dto.wx.ReqUserInfoDto;
import com.collagelone.backend.api.service.front.wx.WxLoginService;
import com.collagelone.backend.wx.WxLoginBiz;
import com.lonedog.platform.common.dto.Result;

@Service
public class WxLoginServiceImpl implements WxLoginService{
  @Autowired
  WxLoginBiz wxLoginBiz;
  @Override
  public Result<Void> login(String codeNo) {
    return wxLoginBiz.login(codeNo);
  }
  @Override
  public Result<Void> updateInfo(String codeNo,
      ReqUserInfoDto reqUserInfo) {
    return wxLoginBiz.updateInfo(codeNo,reqUserInfo);
  }
}
