package com.papabear.product.dao;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallProductDetail;

public interface MallProductDetailDao {
    int deleteByPrimaryKey(Long productId);

    int insert(MallProductDetail record);

    int insertSelective(MallProductDetail record);

    MallProductDetail selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(MallProductDetail record);

    int updateByPrimaryKeyWithBLOBs(MallProductDetail record);

    int updateByPrimaryKey(MallProductDetail record);
    
    MallProductDetail getMallProductDetail(@Param("productId")Long productId,@Param("status")byte status);
}