package com.papabear.product.dao;

import com.papabear.product.entity.ProductDetail;

public interface ProductDetailDao {
    int deleteByPrimaryKey(Long productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}