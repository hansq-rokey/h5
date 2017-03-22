package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProductProperties;

public interface MallProductPropertiesDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductProperties record);

    int insertSelective(MallProductProperties record);

    MallProductProperties selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductProperties record);

    int updateByPrimaryKey(MallProductProperties record);
    
    /**
     * 
     * @param modelId
     * @param invalid
     * @return
     */
    List<MallProductProperties> queryMallProductPropertiesByModelId(@Param("modelId")Long modelId,@Param("invalid")boolean invalid);
    
}