package com.lonedog.platform.common.spring.utils;

import com.lonedog.platform.common.db.redis.impl.JedisPoolManager;

public class JedisUtils{
  private static final JedisPoolManager jedisClient = ApplicationContextUtils.getBean(JedisPoolManager.class);
  public static JedisPoolManager getInstance(){
    return jedisClient;
  }
}
