package com.collagelone.backend.dao;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.StringUtils;

import com.lonedog.platform.common.db.DataSourceHolder;
import com.lonedog.platform.common.db.TargetDataSource;

public class DataSourceAspect extends com.lonedog.platform.common.db.DataSourceAspect {

	@Override
	public void before(JoinPoint point) {
		if (DataSourceHolder.getDataSouce() == null) {
            // 根据包路径名 获取dataSource的key前缀，这样效率太低，改成根据Mapper前缀来获取
            Class<?>[] classz = point.getTarget().getClass().getInterfaces();
            TargetDataSource obj=classz[0].getAnnotation(TargetDataSource.class);
            if(null!=obj && !StringUtils.isEmpty(obj.dataSourceName())){
            	DataSourceHolder.setDataSource(obj.dataSourceName());
            }

        }
	}

}