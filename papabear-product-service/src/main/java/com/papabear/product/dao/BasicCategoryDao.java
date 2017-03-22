package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallBasicCategory;

public interface BasicCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallBasicCategory record);


    int insertSelective(MallBasicCategory record);
    
    MallBasicCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallBasicCategory record);

    int updateByPrimaryKey(MallBasicCategory record);
    
    /**
     * 根据业务状态查询产品型号
     * @param status
     * @return
     */
    List<MallBasicCategory> queryBasicCategory(@Param("status")Byte status);

}