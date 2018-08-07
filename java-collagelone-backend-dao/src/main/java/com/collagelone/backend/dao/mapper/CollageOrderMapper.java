package com.collagelone.backend.dao.mapper;

import com.collagelone.backend.dao.entity.CollageOrder;

public interface CollageOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollageOrder record);

    int insertSelective(CollageOrder record);

    CollageOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollageOrder record);

    int updateByPrimaryKey(CollageOrder record);
}