package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProductTag;

public interface MallProductTagDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductTag record);

    int insertSelective(MallProductTag record);

    MallProductTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductTag record);

    int updateByPrimaryKey(MallProductTag record);
    
    List<MallProductTag> queryProductTagsByProductId(Long productId);
    
    int deleteProductTagByProductId(Long productId);
    
    MallProductTag selectByProductIdAndTagId(@Param("productId")Long productId,@Param("tagId")Long tagId);
}