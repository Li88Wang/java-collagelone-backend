package com.lonedog.platform.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.utils.GsonUtil</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * json工具类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class GsonUtil {
  private static final Gson gson = new Gson();
  /**转换成对象
   * @param gsonStr
   * @param t
   * @return
   */
  public static <T> T getObject(String gsonStr,Class<T> t) {
    if(gsonStr == null ){
      return null;
    }
    return gson.fromJson(gsonStr, t);
  }
  /**转换成对象
   * @param gsonStr
   * @param t
   * @return
   */
  public static <T> T getObjectJSON(String gsonStr,Class<T> t) {
    if(gsonStr == null ){
      return null;
    }
    return JSON.parseObject(gsonStr, t);
  }
  /**转换成对象用fastJson
   * @param gsonStr
   * @param t
   * @return
   */
  public static <T> T getObjectFromJson(String jsonStr,Class<T> t) {
    if(jsonStr == null ){
      return null;
    }
    return JSON.parseObject(jsonStr, t);
  }
  /**转换成json串
   * @param gsonStr
   * @param t
   * @return
   */
  public static String serializeObject(Object t) {
    if(t == null){
      return null;
    }
    return gson.toJson(t);
  }
  /**转换成json串
   * @param gsonStr
   * @param t
   * @return
   */
  public static String serializeObjectWFJson(Object t) {
    if(t == null){
      return null;
    }
    return JSON.toJSONString(t);
  }
}