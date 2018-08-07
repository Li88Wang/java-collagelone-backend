package com.lonedog.platform.common.db;
/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.dao.DataSourceHolder</li>
 * <li>创建时间 : 2018年8月6日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 线程资源副本
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class DataSourceHolder {
    
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }

}