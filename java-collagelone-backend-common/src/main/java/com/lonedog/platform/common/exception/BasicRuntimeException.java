package com.lonedog.platform.common.exception;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.common.BasicRuntimeException</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 基础运行异常类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class BasicRuntimeException extends RuntimeException {
  
  private static final long serialVersionUID = -3688522326713291049L;

    public BasicRuntimeException() {
        super();
    }
    
    private static final String REPLACE_LABEL = "{}";
    /**
     * @param message 支持占位符{}，例如 "error, userID={}, opt={}."
     * @param args 对应message占位符{}的值
     */
    public BasicRuntimeException(String message, String... args) {
      super(replaceParams(message, args));
    }

    public BasicRuntimeException(Throwable e) {
        super(e);
    }

    /**
     * @param e 原始异常
     * @param message 支持占位符{}，例如 "error, userID={}, opt={}."
     * @param args 对应message占位符{}的值
     */
    public BasicRuntimeException(Throwable e, String message, String... args) {
        super(replaceParams(message, args), e);
    }

    /**替换拼接
     * @param message
     * @param args
     * @return
     */
    public static String replaceParams(String message,String... args){
      if(message == null || message.length() == 0){
        return message;
      }
      for(String param : args){
        message = message.replace(REPLACE_LABEL,param);
      }
      return message;
    }
}