package com.collagelone.backend.service.front.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collagelone.backend.api.dto.wx.OrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoListDto;
import com.collagelone.backend.api.dto.wx.ReqUpdateStatusDto;
import com.collagelone.backend.api.dto.wx.ResOrderInfoListDto;
import com.collagelone.backend.api.service.front.wx.WxOrderService;
import com.collagelone.backend.wx.WxOrderBiz;
import com.lonedog.platform.common.SystemConstant;
import com.lonedog.platform.common.db.redis.JedisKeyManager;
import com.lonedog.platform.common.dto.Result;
import com.lonedog.platform.common.dto.SupportResult;
import com.lonedog.platform.common.lock.BusinessLocker;

@Service
public class WxOrderServiceImpl implements WxOrderService{
  private final static Logger LOG = LoggerFactory.getLogger(WxOrderServiceImpl.class);
  private final static String PREXKEY = JedisKeyManager.getServiceKey(SystemConstant.COLLAGELONG, "WxOrderService");
  @Autowired
  WxOrderBiz wxOrderBiz;
  @Autowired
  BusinessLocker businessLocker;
  @Override
  public Result<ResOrderInfoListDto> list(
      ReqOrderInfoListDto reqData) {
    return wxOrderBiz.list(reqData);
  }

  @Override
  public Result<OrderInfoDto> edit(ReqOrderInfoDto reqData) {
    boolean locker = false;
    try{
      // 只执行一个
      if (! (locker = businessLocker.getBusinessLockRetry(PREXKEY, "edit"))) {
        LOG.warn("WxOrderService.edit服务锁被占用");
        return SupportResult.<OrderInfoDto>create().description("WxOrderService.edit服务锁被占用");
      }
      return wxOrderBiz.edit(reqData);
    }finally{
      // 释放锁
      if(locker){
        businessLocker.unlock(PREXKEY, "edit");
      }
    }
  }

  @Override
  public Result<Void> updateStatus(ReqUpdateStatusDto reqData) {
    return wxOrderBiz.updateStatus(reqData);
  }
}
