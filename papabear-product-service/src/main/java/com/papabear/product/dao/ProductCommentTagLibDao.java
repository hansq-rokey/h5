package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.ProductCommentTagLib;

public interface ProductCommentTagLibDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCommentTagLib record);

    Long insertSelective(ProductCommentTagLib record);

    ProductCommentTagLib selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCommentTagLib record);

    int updateByPrimaryKey(ProductCommentTagLib record);
    
    List<ProductCommentTagLib> queryAllByProductId(@Param("productId")Long productId,@Param("invalid")Byte invalid);
}