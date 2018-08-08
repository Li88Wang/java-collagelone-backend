package com.lonedog.platform.common.db.redis.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lonedog.platform.common.db.redis.JedisManager;
import com.lonedog.platform.common.lock.BusinessLocker;
import com.lonedog.platform.common.spring.utils.JedisUtils;

/**
 * 业务锁,注意业务锁需要依赖redis
 * Created by wzp on 17/03/26.
 */
public abstract class AbstractRedisLocker implements BusinessLocker{
  private static final Logger logger = LoggerFactory.getLogger(AbstractRedisLocker.class);
  /**
     * 重试次数
     */
  private int retryTimes = 2;

    /**
     * 重试间隔时间，单位：ms
     */
  private long retryDelay = 100;
  /**
   * 锁最长持续时间,超时失效,单位:s 默认1分钟
   */
  private int expireTime = 30;

  public boolean getBusinessLock(String bussinessCode, String key) {
    if(logger.isInfoEnabled()){
	  logger.info("into lock......."+bussinessCode+key);
    }
    Object oldValue =  JedisUtils.getInstance().get(bussinessCode+key);
    if(logger.isInfoEnabled()){
      logger.info("into lock......."+bussinessCode+key+"--{}",oldValue);
    }
    if(oldValue == null){
        return lock(bussinessCode+key);
    }
    return false;
  }

  public boolean getBusinessLockRetry(String bussinessCode, String key) {
      int count = 0;
      while(count<retryTimes){
          if(getBusinessLock(bussinessCode, key)){
              return true;
          }
          count++;
          if(logger.isDebugEnabled()){
            logger.debug("bussinessCode:"+bussinessCode+"key:"+key+"，num:"+count+"failed。");
          }
          try {
            if(logger.isDebugEnabled()){
              logger.debug("bussinessCode:"+bussinessCode+",can't get "+key+"，begin sleep:"+retryDelay);
            }
            Thread.sleep(retryDelay);
          } catch (InterruptedException e) {
            logger.error("bussinessCode:"+bussinessCode+",sleep Interrup go on check");
          }
      }
      if(logger.isDebugEnabled()){
        logger.debug("bussinessCode:"+bussinessCode+" retry "+retryTimes+" times can't get key:"+key);
      }
      return false;
  }

  public abstract boolean lock(final String key);

  public void unlock(String bussinessCode, String key) {
    if(logger.isDebugEnabled()){
      logger.debug("bussinessCode:"+bussinessCode+",解锁key:"+key);
    }
    JedisUtils.getInstance().del(bussinessCode+key);
  }

  public int getRetryTimes() {
      return retryTimes;
  }

  public void setRetryTimes(int retryTimes) {
      this.retryTimes = retryTimes;
  }

  public long getRetryDelay() {
      return retryDelay;
  }

  public void setRetryDelay(long retryDelay) {
      this.retryDelay = retryDelay;
  }

  public int getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(int expireTime) {
    this.expireTime = expireTime;
  }
  
}
