package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProductPropertiesValue;

public interface MallProductPropertiesValueDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductPropertiesValue record);

    int insertSelective(MallProductPropertiesValue record);

    MallProductPropertiesValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductPropertiesValue record);

    int updateByPrimaryKey(MallProductPropertiesValue record);
    
    List<MallProductPropertiesValue> queryPropertiesValuesByPropertiesId(Long propertiesId);
    
    List<MallProductPropertiesValue> selectByPropertiesId(@Param("propertiesId") Long propertiesId, @Param("invalid") Byte invalid);
}