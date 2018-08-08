package com.lonedog.platform.common.db.redis;

import java.util.Map;

import redis.clients.jedis.ScanResult;
/**
 * redis管理
 * @author hjf
 *
 */
public interface JedisManager {

      Long ttl(final String key);
	  String get(final String key);
	  String setex(String key, String value, int seconds);
	  Long setnex(String key, String value, int seconds);
	  String setObjectWithGsonEx(String key, Object value, int seconds);	 
	  <T> T getObjectInGSON(String key, Class<T> t); 
	  String setObjectEx(String key, Object value, int seconds);
	  <T> T getObject(String key);	 
	  Long hdel(String key,String field);
	  Boolean existed(String key);
	  Long incrBy(final String key, long integer);
	  Long hset(final String key, final String field, final String value);
	  String hget(final String key, final String field);
	  Long hsetnx(final String key, final String field, final String value);
	  String hmset(final String key, final Map<String, String> value);
	  Long del(final String key);
	  
	   Long rpush(final String key, final String... strings);
	      Long expire(final String key, final int seconds);
	      Long llen(final String key);
	      String lindex(final String key, final long index);
	  
	  /**获取具体的redis客户端
	   * @return
	   */
	  <T> T getClient();
    String set(String key, String value);
    Long setnx(String key, String value);
    boolean hexists(String key, String zone);
    int setWPipeline(Map<String, String> map);
    int hexistWPipeline(Map<String, String> map);
    /**pipehset
     * @param map key-field
     * @param val val
     * @return 1-成功,0-失败
     */
    int hsetWPipeline(Map<String, String> map,String val);
    /**
     * @param map key-field
     */
    int hdelWPipeline(Map<String, String> map);
    
    long lpush(String key, String value);
    
    long sadd(String key, String value);
    
    long hincrby(String hkey, String origTime, long val);
    
    String spop(String key);
    
    long lrem(String key,long count,String value);
    
}
