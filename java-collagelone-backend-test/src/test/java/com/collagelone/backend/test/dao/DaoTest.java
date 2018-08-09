package com.collagelone.backend.test.dao;

import org.junit.Test;

import com.collagelone.backend.test.BaseIntegrateTest;
import com.lonedog.platform.common.spring.utils.JedisUtils;

public class DaoTest extends BaseIntegrateTest{
  @Test
  public void initTest(){
    JedisUtils.getInstance().set("collagelone", "1");
    LOGGER.info(JedisUtils.getInstance().get("collagelone"));
    LOGGER.info("ceshi");
  }
}