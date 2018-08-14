package com.lonedog.platform.common.db.redis;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.db.redis.JedisKeyManager</li>
 * <li>创建时间 : 2018年8月14日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * redis的key规范管理
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class JedisKeyManager {
  private final static String PREX = "lonedog:platform:";
  /**获得域的redis key
   * @param domain
   * @return
   */
  public static String getDomainKey(String domain){
    return PREX + domain;
  }
  /**获取service的redis key
   * @param domain
   * @param service
   * @return
   */
  public static String getServiceKey(String domain, String service){
    return getDomainKey(domain) + ":" + service;
  }
}
