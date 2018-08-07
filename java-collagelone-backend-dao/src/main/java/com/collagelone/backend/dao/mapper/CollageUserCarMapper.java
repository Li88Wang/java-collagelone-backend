package com.collagelone.backend.dao.mapper;

import com.collagelone.backend.dao.entity.CollageUserCar;

public interface CollageUserCarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollageUserCar record);

    int insertSelective(CollageUserCar record);

    CollageUserCar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollageUserCar record);

    int updateByPrimaryKey(CollageUserCar record);
}