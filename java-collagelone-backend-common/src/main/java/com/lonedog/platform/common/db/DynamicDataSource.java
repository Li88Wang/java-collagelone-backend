package com.lonedog.platform.common.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.dao.DynamicDataSource</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 动态资源获取
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSouce();
    }

}