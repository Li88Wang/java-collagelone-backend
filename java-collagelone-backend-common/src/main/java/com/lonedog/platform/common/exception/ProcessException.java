package com.lonedog.platform.common.exception;

import javax.xml.transform.Result;



/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.common.ProcessException</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 异常工具类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ProcessException {

    /**抛出指定异常
     * @param res
     * @param code
     */
    public static BasicRuntimeException toException(CodeMeta code){
      return new BasicRuntimeException(code.getMsgZhCN());
    }
    /**抛出指定异常
     * @param res
     * @param code
     */
    public static BasicRuntimeException toException(CodeMeta code,Object... params){
      return toException(code.getMsgZhCN(), params);
    }
    /**抛出指定异常
     * @param res
     * @param code
     */
    public static BasicRuntimeException toException(String source,Object... params){
      for(Object param : params){
        source = source.replace("{}",String.valueOf(param));
      }
      return new BasicRuntimeException(source);
    }
    /**抛出指定异常
     * @param res
     * @param code
     */
    public static BasicRuntimeException toException(String msg){
      return new BasicRuntimeException(msg);
    }
}
