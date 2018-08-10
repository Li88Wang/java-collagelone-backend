package com.collagelone.backend.web.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.lonedog.platform.common.dto.AjaxListResult;
import com.lonedog.platform.common.dto.AjaxResult;
import com.lonedog.platform.common.login.LoginContextHolder;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.web.controller.BaseController</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 基础controller
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class BaseController {
    protected static final String DATE_TIME_FORMATE = "yyyy-MM-dd HH:mm:ss";
    protected static final String DATE_FORMATE = "yyyy-MM-dd";
    protected static final String COMMON_ERROR_PAGE = "/screen/error/404";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 判断当前是否登录
     */
    protected boolean isLogin() {
        return LoginContextHolder.getLoginContext().isLogin();
    }

    /**
     * 获取当前登录者昵称
     */
    protected String getLoginUserName() {
        return LoginContextHolder.getLoginContext().getShowName();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMATE);
                if (text != null && text.length() < 12) {
                    sdf = new SimpleDateFormat(DATE_FORMATE);
                }
                try {
                    if (text != null && !"".equals(text.trim())) {
                        setValue(sdf.parse(text));
                    }
                } catch (ParseException e) {
                    logger.error("parse date error, date:{}", text);
                }
            }
        });
    }


    /**
     * 参数校验结果，没有异常返回空字符串，有异常返回string
     */
    protected String errorsToString(BindingResult result) {
        String errorMessage = "";
        if (result.hasErrors()) {
            StringBuilder errorSb = new StringBuilder();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorSb.append(fieldError.getDefaultMessage() + "\n");
            }
            errorMessage = errorSb.toString();
        }
        return errorMessage;
    }

    /**
     * 异步新增参数校验不通过时直接返回错误信息
     */
    protected AjaxResult processErrorResult(BindingResult result) {
        StringBuilder sb = new StringBuilder(100);
        for (FieldError fieldError : result.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage() + "\n");
        }
        return putFailData(sb.toString());
    }

    /**
     * 获取当前登录人id
     */
    protected Long getLoginUserId() {
        return LoginContextHolder.getLoginContext().getUserId();
    }

    protected AjaxResult putSuccessData(String message) {
        return putSuccessData(null, message);
    }

    protected AjaxResult putSuccessData(Object data, String message) {
        return new AjaxResult(AjaxResult.STATUS_SUCCESS, message, data);
    }

    protected AjaxResult putSuccessData() {
        return putSuccessData(null, null);
    }

    protected AjaxResult putFailData(String erorMsg) {
        return putFailData(null, erorMsg);
    }

    protected AjaxResult putFailData(Object data) {
        return putFailData(data, null);
    }

    protected AjaxResult putFailData(Object data, String erorMsg) {
        return new AjaxResult(AjaxResult.STATUS_FAIL, erorMsg, data);
    }

    protected AjaxResult putAjaxData(int status, String erorMsg, Object data) {
        return new AjaxResult(status, erorMsg, data);
    }

    /**
     * list如果用datatables插件用这个put数据，成功
     */
    protected AjaxResult putSuccessData4List(Object data, String message, long recordsFiltered) {
        return new AjaxListResult(AjaxResult.STATUS_SUCCESS, message, data, recordsFiltered);
    }

    /**
     * list如果用datatables插件用这个put数据，失败
     */
    protected AjaxResult putFailData4List(Object data, String erorMsg) {
        return new AjaxListResult(AjaxResult.STATUS_FAIL, erorMsg, data, 0);
    }
}
