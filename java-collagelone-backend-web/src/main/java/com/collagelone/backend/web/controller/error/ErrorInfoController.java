package com.collagelone.backend.web.controller.error;

import java.io.IOException;
import java.sql.SQLDataException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collagelone.backend.web.controller.BaseController;

/**
 * 统一错误页面
 *
 * @author longbao.slb
 * @since v1.0.0
 */
@ControllerAdvice
public class ErrorInfoController extends BaseController{

    @ExceptionHandler({ SQLDataException.class })
    public String sqlError(SQLDataException e) {
        logger.error("发生 SQLDataException: ", e);
        return "screen/error/500";
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public String illegalError(IllegalArgumentException e) {
        logger.error("发生 IllegalArgumentException: ", e);
        return "screen/error/500";
    }

    @ExceptionHandler({ RuntimeException.class })
    public String runtimeError(RuntimeException e) {
        logger.error("发生 RuntimeException: ", e);
        return "screen/error/500";
    }

    @ExceptionHandler({ IOException.class })
    public String ioError(IOException e) {
        logger.error("发生 IOException: ", e);
        return "screen/error/500";
    }

    @ExceptionHandler({ Exception.class })
    public String error(Exception e) {
        logger.error("发生 Exception: ", e);
        return "screen/error/500";
    }
}
