package com.lonedog.platform.common.login;
/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.login.LoginContextHolder</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 登陆上下文钩子
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public final class LoginContextHolder {

    /** 
     * 线程本地LoginContext
     */
    private static final ThreadLocal<LoginContext> HOLDER = new ThreadLocal<LoginContext>() {
        @Override
        protected LoginContext initialValue() {
            return new LoginContext();
        }
    };

    /**
     * 受保护构造函数
     */
    protected LoginContextHolder() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取当前用户上下文信息
     *
     * @return LoginContext
     */
    public static LoginContext getLoginContext() {
        return HOLDER.get();
    }

    /**
     * 清除当前用户上下文
     */
    public static void clearLoginContext() {
        HOLDER.remove();
    }

}