package com.lonedog.platform.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <ul>
 * <li>文件名称 : com.lonedog.platform.common.utils.EnvUtil</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 环境工具类
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
public class EnvUtil {

    private static final EnvInfo ENV_INFO = new EnvInfo();


    public static EnvInfo getEnvInfo() {
        return ENV_INFO;
    }

    public static final class EnvInfo {

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("EnvInfo{");
            sb.append("HOST_NAME='").append(HOST_NAME).append('\'');
            //sb.append(", HOST_ADDRESS='").append(HOST_ADDRESS).append('\'');
            sb.append(", JAVA_VERSION='").append(JAVA_VERSION).append('\'');
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }

        private final String HOST_NAME;
        private final String HOST_ADDRESS;
        private final String JAVA_VERSION = getSystemProperty("java.version");

        private EnvInfo() {
            String hostName;
            String hostAddress;
            try {
                InetAddress localhost = InetAddress.getLocalHost();
                hostName = localhost.getHostName();
                hostAddress = localhost.getHostAddress();
            } catch (UnknownHostException e) {
                hostName = "localhost";
                hostAddress = "127.0.0.1";
            }
            this.HOST_NAME = hostName;
            this.HOST_ADDRESS = hostAddress;
        }
    }

    private static String getSystemProperty(String name) {
        try {
            return System.getProperty(name);
        } catch (SecurityException e) {
        }
        return null;
    }

}