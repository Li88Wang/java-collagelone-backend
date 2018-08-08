package com.lonedog.platform.common.db.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import com.lonedog.platform.common.db.redis.JedisManager;
import com.lonedog.platform.common.utils.GsonUtil;
/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.db.redis.impl.JedisPoolManager</li>
 * <li>创建时间 : 2018年8月8日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * redis实现
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class JedisPoolManager implements JedisManager {
	private static final Logger log = LoggerFactory
		      .getLogger(JedisPoolManager.class);
	private JedisPool jedisPool;
	private JdkSerializationRedisSerializer valueSerializer;
	
	public JedisPool getJedisPool() {
      return jedisPool;
    }
	public void setJedisPool(JedisPool jedisPool) {
	  this.jedisPool = jedisPool;
	}
	public JdkSerializationRedisSerializer getValueSerializer() {
      return valueSerializer;
    }
	public void setValueSerializer(JdkSerializationRedisSerializer valueSerializer) {
      this.valueSerializer = valueSerializer;
    }
    @Override
	public Jedis getClient() {
	  return jedisPool.getResource();
	}
	
	/**关闭链接
	 * @param jedis
	 */
	public void returnResource(Jedis jedis) {
		if(null!=jedis){
			jedis.close();
		}

	}
	@Override
	public String get(String key) {
		Jedis jedis =null;
		String res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.get(key);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.get错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public String setex(String key, String value, int seconds) {
		Jedis jedis =null;
		String res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.setex(key, seconds, value);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setex错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}
	
	@Override
	public String set(String key, String value) {
	  Jedis jedis =null;
	  String res=null;
	  try{
	    jedis=jedisPool.getResource();
	    res=jedis.set(key, value);
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.set错误",ex);
	  }finally{
	    this.returnResource(jedis);
	  }
	  return res;
	}
	
	@Override
	public int setWPipeline(Map<String,String> map) {
	  Jedis jedis =null;
	  try{
	    if(map == null || map.size() == 0){
	      return 0;
	    }
	    jedis=jedisPool.getResource();
	    Pipeline pp = jedis.pipelined();
	    for(Entry<String,String> entry : map.entrySet()){
	      pp.set(entry.getKey(), entry.getValue());
	    }
	    List<Object> resultList = pp.syncAndReturnAll();
	    int count = 0;
	    for(Object oj : resultList){
	      if("OK".equalsIgnoreCase(String.valueOf(oj))){
	        count++;
	      }
	    }
	    return count;
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setWPipeline错误",ex);
	    return 0;
	  }finally{
	    this.returnResource(jedis);
	  }
	}
	@Override
	public int hsetWPipeline(Map<String,String> map,String val) {
	  Jedis jedis =null;
	  try{
	    if(map == null || map.size() == 0){
	      return 0;
	    }
	    jedis=jedisPool.getResource();
	    Pipeline pp = jedis.pipelined();
	    for(Entry<String,String> entry : map.entrySet()){
	      pp.hset(entry.getKey(), entry.getValue(),val);
	    }
	    pp.syncAndReturnAll();
	    return 1;
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hsetWPipeline错误",ex);
	    return 0;
	  }finally{
	    this.returnResource(jedis);
	  }
	}
	@Override
	public int hdelWPipeline(Map<String,String> map) {
	  Jedis jedis =null;
	  try{
	    if(map == null || map.size() == 0){
	      return 0;
	    }
	    jedis=jedisPool.getResource();
	    Pipeline pp = jedis.pipelined();
	    for(Entry<String,String> entry : map.entrySet()){
	      pp.hdel(entry.getKey(), entry.getValue());
	    }
	    List<Object> resultList = pp.syncAndReturnAll();
        int count = 0;
        for(Object oj : resultList){
          if((Long)oj > 0){
            count++;
          }
        }
        return count;
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hsetWPipeline错误",ex);
	    return 0;
	  }finally{
	    this.returnResource(jedis);
	  }
	}
	
	@Override
	public int hexistWPipeline(Map<String,String> map) {
	  Jedis jedis =null;
	  try{
	    if(map == null || map.size() == 0){
	      return 0;
	    }
	    jedis=jedisPool.getResource();
	    Pipeline pp = jedis.pipelined();
	    for(Entry<String,String> entry : map.entrySet()){
	      pp.hexists(entry.getKey(), entry.getValue());
	    }
	    List<Object> resultList = pp.syncAndReturnAll();
	    int count = 0;
	    for(Object oj : resultList){
	      if((Boolean)oj){
	        count++;
	      }
	    }
	    return count;
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hexistWPipeline错误",ex);
	    return 0;
	  }finally{
	    this.returnResource(jedis);
	  }
	}

	@Override
	public Long setnex(String key, String value, int seconds) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res = jedis.setnx(key,  value);
		      if(res == 1){
		        jedis.expire(key, seconds);
		      }
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setnex错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}
	
	@Override
	public Long setnx(String key, String value) {
	  Jedis jedis =null;
	  Long res=null;
	  try{
	    jedis=jedisPool.getResource();
	    res = jedis.setnx(key,  value);
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setnx错误",ex);
	  }finally{
	    this.returnResource(jedis);
	  }
	  return res;
	}
	
	@Override
	public boolean hexists(String key, String value) {
	  Jedis jedis =null;
	  Boolean res=null;
	  try{
	    jedis=jedisPool.getResource();
	    res = jedis.hexists(key,  value);
	  }catch(Exception ex){
	    log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hexists错误",ex);
	    res = Boolean.FALSE;
	  }finally{
	    this.returnResource(jedis);
	  }
	  return res;
	}
	 
	@Override
	public String setObjectWithGsonEx(String key, Object value, int seconds) {
		return setex(key, GsonUtil.serializeObject(value), seconds);
	}

	@Override
	public <T> T getObjectInGSON(String key, Class<T> t) {
		Jedis jedis =null;
		T res=null;
		    try {
		    	jedis=jedisPool.getResource();
		      String valObj = jedis.get(key);
		      if(valObj != null){
		        res =  GsonUtil.getObject(valObj, t);
		      }
		    } catch(Exception ex){
				log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setObjectWithGsonEx错误",ex);
			}finally{
				this.returnResource(jedis);
			}
			return res;
	}
	
	@Override
	public String setObjectEx(String key, Object value, int seconds) {
		Jedis jedis =null;
		String res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.setex(key.getBytes(), seconds, valueSerializer.serialize(value));
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.setObjectEx错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public <T> T getObject(String key) {
		Jedis jedis =null;
		 T res = null;
		    try {
		      jedis = jedisPool.getResource();
		      byte[] valObj = jedis.get(key.getBytes());
		      if(valObj != null){
		    	  res =  (T) valueSerializer.deserialize(valObj);
		      }
		    }catch(Exception ex){
				log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.getObject错误",ex);
			}finally{
				this.returnResource(jedis);
			}
			return res;
	}

	@Override
	public Long hdel(String key, String field) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.hdel(key, field);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hdel错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public Boolean existed(String key) {
		Jedis jedis =null;
		Boolean res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.exists(key);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.existed错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public Long incrBy(String key, long integer) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.incrBy(key, integer);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.incrBy错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public Long hset(String key, String field, String value) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.hset(key, field, value);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hset错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public String hget(String key, String field) {
		Jedis jedis =null;
		String res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.hget(key, field);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hget错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public Long hsetnx(String key, String field, String value) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.hsetnx(key, field, value);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hsetnx错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	@Override
	public String hmset(String key, Map<String, String> value) {
		Jedis jedis =null;
		String res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.hmset(key, value);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.hmset错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}

	

	@Override
	public Long del(String key) {
		Jedis jedis =null;
		Long res=null;
		try{
			jedis=jedisPool.getResource();
			res=jedis.del(key);
		}catch(Exception ex){
			log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.del错误",ex);
		}finally{
			this.returnResource(jedis);
		}
		return res;
	}
	
    @Override
    public Long rpush(String key, String... strings) {
        Jedis jedis =null;
        Long res=null;
        try{
            jedis=jedisPool.getResource();
            res=jedis.rpush(key, strings);
        }catch(Exception ex){
            log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.rpush错误",ex);
        }finally{
            this.returnResource(jedis);
        }
        return res;
    }
    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis =null;
        Long res=null;
        try{
            jedis=jedisPool.getResource();
            res=jedis.expire(key, seconds);
        }catch(Exception ex){
            log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.expire错误",ex);
        }finally{
            this.returnResource(jedis);
        }
        return res;
    }
    @Override
    public Long llen(String key) {
        Jedis jedis =null;
        Long res=null;
        try{
            jedis=jedisPool.getResource();
            res=jedis.llen(key);
        }catch(Exception ex){
            log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.llen错误",ex);
        }finally{
            this.returnResource(jedis);
        }
        return res;
    }
    @Override
    public String lindex(String key, long index) {
        Jedis jedis =null;
        String res=null;
        try{
            jedis=jedisPool.getResource();
            res=jedis.lindex(key, index);
        }catch(Exception ex){
            log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lindex错误",ex);
        }finally{
            this.returnResource(jedis);
        }
        return res;
    }
    @Override
    public long lpush(String key, String val) {
      Jedis jedis =null;
      Long res=null;
      try{
        jedis=jedisPool.getResource();
        res=jedis.lpush(key, val);
      }catch(Exception ex){
        log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lpush错误",ex);
        res = -1l;
      }finally{
        this.returnResource(jedis);
      }
      return res;
    }
    @Override
    public long sadd(String key, String val) {
      Jedis jedis =null;
      Long res=null;
      try{
        jedis=jedisPool.getResource();
        res=jedis.sadd(key, val);
      }catch(Exception ex){
        log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lpush错误",ex);
        res = -1l;
      }finally{
        this.returnResource(jedis);
      }
      return res;
    }
    @Override
    public long hincrby(String key, String field,long val) {
      Jedis jedis =null;
      Long res=null;
      try{
        jedis=jedisPool.getResource();
        res=jedis.hincrBy(key, field, val);
      }catch(Exception ex){
        log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lpush错误",ex);
        res = -1l;
      }finally{
        this.returnResource(jedis);
      }
      return res;
    }
    @Override
    public String spop(String key) {
      Jedis jedis =null;
      String res=null;
      try{
        jedis=jedisPool.getResource();
        res=jedis.spop(key);
      }catch(Exception ex){
        log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lpush错误",ex);
      }finally{
        this.returnResource(jedis);
      }
      return res;
    }
    @Override
    public long lrem(String key,long count,String value) {
      Jedis jedis =null;
      Long res=null;
      try{
        jedis=jedisPool.getResource();
        res=jedis.lrem(key, count, value);
      }catch(Exception ex){
        log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lpush错误",ex);
        res = -1l;
      }finally{
        this.returnResource(jedis);
      }
      return res;
    }
    @Override
    public Long ttl(String key) {
      Jedis jedis =null;
      Long res= 0l;
      try{
          jedis=jedisPool.getResource();
          res=jedis.ttl(key);
      }catch(Exception ex){
          log.error("com.lonedog.platform.common.db.redis.impl.JedisPoolManager.lindex错误",ex);
      }finally{
          this.returnResource(jedis);
      }
      return res;
    }
}
