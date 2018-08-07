package com.lonedog.platform.common.db;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Specify DataSource (指定数据源，用于执行事物切面时，指定其他数据源)<br>
 * 注意：<br>
 * {@code @SpecifyDS}放在类级别上等同于该类的每个公有方法都放上了{@code @SpecifyDS}<br>
 * {@code @SpecifyDS}只对公有法有效（与Spring的{@code @Transactional}只对公有方法有效道理是一样的，因为都是Spring AOP代理）
 * 
 * @author zollty
 * @since 2015年12月3日
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SpecifyDS {
    String value();
}