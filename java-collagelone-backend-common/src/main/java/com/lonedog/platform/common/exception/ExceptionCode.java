package com.lonedog.platform.common.exception;
/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.exception.ExceptionCode</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 异常处理信息
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class ExceptionCode extends BasicCode {

  public static final CodeMeta GET_LOCKER_FAILD = new CodeMeta("900001", null, "服务器繁忙");
  public static final CodeMeta SERVER_EXCEPTION = new CodeMeta("900002", null, "服务器异常");
  public static final CodeMeta OPRATE_EXCEPTION = new CodeMeta("900003", null, "操作失败");
  public static final CodeMeta SEARCH_EXCEPTION = new CodeMeta("900004", null, "查询失败");
  public static final CodeMeta UNAUTHENTICATED = new CodeMeta("900005", null, "未授权");
}