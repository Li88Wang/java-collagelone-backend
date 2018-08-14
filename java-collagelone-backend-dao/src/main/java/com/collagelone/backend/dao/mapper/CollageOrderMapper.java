package com.collagelone.backend.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.collagelone.backend.api.dto.wx.OrderInfoDto;
import com.collagelone.backend.api.dto.wx.ReqOrderInfoListDto;
import com.collagelone.backend.dao.entity.CollageOrder;

public interface CollageOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollageOrder record);

    int insertSelective(CollageOrder record);

    CollageOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollageOrder record);

    int updateByPrimaryKey(CollageOrder record);

    /**查询发布信息数
     * @param reqData
     * @return
     */
    int getListCount(ReqOrderInfoListDto reqData);

    /**查询发布信息
     * @param reqData
     * @param mySQLOffset
     * @param pageSize
     * @return
     */
    List<OrderInfoDto> getList(@Param("reqParam") ReqOrderInfoListDto reqData,
        @Param("pageOffset") int mySQLOffset,@Param("pageSize") int pageSize);

    int updateStatusById(@Param("status")Byte orderStatus,
        @Param("id")Long id);
}