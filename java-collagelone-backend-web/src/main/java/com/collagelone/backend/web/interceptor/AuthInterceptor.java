package com.collagelone.backend.web.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.session.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.collagelone.backend.auth.AuthBiz;
import com.collagelone.backend.session.MyHttpSession;
import com.lonedog.platform.common.login.LoginContext;
import com.lonedog.platform.common.login.LoginContextHolder;
import com.lonedog.platform.common.utils.EnvUtil;

public class AuthInterceptor extends AbstractAdInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    @Qualifier("pageWhiteList")
    private List<String> pageWhiteList;

    @Autowired
    private AuthBiz authBiz;
    @Autowired
    private MyHttpSession myHttpSession;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
        throws IOException {
      Session Session = myHttpSession.getSession(httpServletRequest);
      return true;
    }

    /**
     * 写登录上下文
     */
    private void setLoginContext(LoginContext loginContext, String ip) {
        LoginContext context = LoginContextHolder.getLoginContext();
        context.setNickName(loginContext.getNickName());
        context.setUserId(loginContext.getUserId());
        context.setAct(loginContext.getAct());
        context.setAuthUuid(loginContext.getAuthUuid());
        context.setEmail(loginContext.getEmail());
        context.setShowName(loginContext.getShowName());
        context.setTime(loginContext.getTime());
        context.setToken(loginContext.getToken());
        context.setUserIp(ip);
        context.setLogin(true);
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
        ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.addObject("loginContext", LoginContextHolder.getLoginContext());
            modelAndView.addObject("ctxEnvInfo", EnvUtil.getEnvInfo());
            //添加当前时间戳
            modelAndView.addObject("currentTimeMillis",System.currentTimeMillis());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object o, Exception e) throws Exception {
        LoginContextHolder.clearLoginContext();
    }

    public void setPageWhiteList(List<String> pageWhiteList) {
        this.pageWhiteList = pageWhiteList;
    }
}