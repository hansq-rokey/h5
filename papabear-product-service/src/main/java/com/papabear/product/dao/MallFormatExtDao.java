package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallFormatExt;

public interface MallFormatExtDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallFormatExt record);

    int insertSelective(MallFormatExt record);

    MallFormatExt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallFormatExt record);

    int updateByPrimaryKey(MallFormatExt record);
    
    List< MallFormatExt> queryMallFormatExts(@Param("formatId")Long formatId,@Param("type")Byte type);
}