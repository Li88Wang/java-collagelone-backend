package com.lonedog.platform.common.db.redis.lock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lonedog.platform.common.spring.utils.JedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 主从业务锁
 * Created by wzp on 17/03/26.
 */
public class BusinessStandaloneLocker extends AbstractRedisLocker{
  private static final Logger logger = LoggerFactory.getLogger(BusinessStandaloneLocker.class);

  public boolean lock(final String key){
      Jedis jedis = null;
      try {
        jedis = JedisUtils.getInstance().<Jedis>getClient();
        jedis.watch(key);
        Transaction tran = jedis.multi();
        tran.get(key);
        tran.setex(key, getExpireTime(), "1");
        List<Object> list = tran.exec();
        if(list == null){
          return false;
        }
        Object getResult = list.get(0);
        String execString = (String) list.get(1);
        return getResult == null && "OK".equalsIgnoreCase(execString) ? true : false;
      } catch (Exception ex) {
        logger.error("locker is aready locked:" + key,ex);
        return false;
      } finally {
        if (jedis != null) {
          jedis.unwatch();  
          jedis.close();
        }
      }
    }

}
