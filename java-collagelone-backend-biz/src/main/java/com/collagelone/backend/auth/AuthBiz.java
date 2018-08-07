package com.collagelone.backend.auth;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <ul>
 * <li>文件名称 : com.collagelone.backend.auth.AuthBiz</li>
 * <li>创建时间 : 2018年8月7日</li>
 * <li>修改记录 : 无</li>
 * <li>描    述 : 
 * 授权业务
 * </li>
 * </ul>
 * 
 * @author wangzhipeng
 * @version 1.0
 */
@Service
public class AuthBiz {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String BOSS_AUTH_ROOT_PATH = "root";
    private static final String AUTH_SPLIT = "/";

    // 超级管理员IDs
    @Value("${admin.web.authcheck.adminuserids}")
    private volatile String adminUserIds = "";

    private volatile Set<Integer> adminUserSet = new HashSet<>();

    public boolean trigger(String newValue) {
        initAdminUser(newValue);
        return true;
    }

    @PostConstruct
    public void init() {
        initAdminUser(this.adminUserIds);
    }

    public void initAdminUser(String newValue) {
        if (newValue != null) {
            String[] userIdStrs = newValue.split(",");
            if (userIdStrs != null && userIdStrs.length > 0) {
                adminUserSet = new HashSet<>();
                for (String userStr : userIdStrs) {
                    adminUserSet.add(Integer.parseInt(userStr));
                }
            }
        }
    }

    public void setAdminUserIds(String adminUserIds) {
        this.adminUserIds = adminUserIds;
    }

    public Set<Integer> getAdminUserSet() {
        return adminUserSet;
    }
}