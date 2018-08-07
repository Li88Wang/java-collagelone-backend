package com.lonedog.platform.common.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.db.TargetDataSource</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 指定数据源注解
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TargetDataSource {

	String dataSourceName();
}