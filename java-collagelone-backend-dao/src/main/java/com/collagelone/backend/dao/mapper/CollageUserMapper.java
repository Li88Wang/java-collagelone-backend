package com.collagelone.backend.dao.mapper;

import com.collagelone.backend.dao.entity.CollageUser;

public interface CollageUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollageUser record);

    int insertSelective(CollageUser record);

    CollageUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollageUser record);

    int updateByPrimaryKey(CollageUser record);

    CollageUser selectByOpenId(String openId);
}