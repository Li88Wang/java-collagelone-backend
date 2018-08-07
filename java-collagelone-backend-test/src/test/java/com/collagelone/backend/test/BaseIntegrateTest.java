package com.collagelone.backend.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class BaseIntegrateTest {
  public    Logger LOGGER = LoggerFactory.getLogger(getClass());
  public static final String msg = "test Suitcase:[%s]--result:%s";
}