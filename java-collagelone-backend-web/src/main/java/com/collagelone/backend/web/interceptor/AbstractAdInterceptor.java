package com.collagelone.backend.web.interceptor;
public abstract class AbstractAdInterceptor {

    /**
     * 通过URI后缀.JSON判断是ajax请求
     */
    protected boolean isAjaxRequest(String targetURI) {
        return targetURI != null && targetURI.toLowerCase().endsWith(".json");
    }

}