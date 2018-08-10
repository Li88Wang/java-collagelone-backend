package com.collagelone.backend.web.controller.error;

import java.io.IOException;
import java.sql.SQLDataException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collagelone.backend.web.controller.BaseController;
import com.lonedog.platform.common.dto.AjaxResult;
import com.lonedog.platform.common.exception.BasicRuntimeException;

/**
 * 统一错误页面
 *
 * @author longbao.slb
 * @since v1.0.0
 */
@ControllerAdvice
@ResponseBody
public class ErrorInfoController extends BaseController{

    @ExceptionHandler({ SQLDataException.class })
    public AjaxResult sqlError(SQLDataException e) {
      logger.error("发生 SQLDataException: ", e);
      return putFailData("数据错误");
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public AjaxResult illegalError(IllegalArgumentException e) {
      logger.error("发生 IllegalArgumentException: ", e);
      return putFailData("参数错误");
    }

    @ExceptionHandler({ RuntimeException.class })
    public AjaxResult runtimeError(RuntimeException e) {
      logger.error("发生 RuntimeException: ", e);
      if(e instanceof BasicRuntimeException){
        return putFailData(e.getMessage());
      }else{
        return putFailData("请求时发生错误");
      }
    }

    @ExceptionHandler({ IOException.class })
    public AjaxResult ioError(IOException e) {
      logger.error("发生 IOException: ", e);
      return putFailData("网络错误");
    }

    @ExceptionHandler({ Exception.class })
    public AjaxResult error(Exception e) {
      logger.error("发生 Exception: ", e);
      return putFailData("服务可能休息了，请稍后重试或联系管理员");
    }
}
