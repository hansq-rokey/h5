package com.papabear.product.dao;

import java.util.List;
import java.util.Map;

import com.papabear.product.entity.ProductComment;

public interface ProductCommentDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductComment record);

    Long insertSelective(ProductComment record);

    ProductComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductComment record);

    int updateByPrimaryKey(ProductComment record);
    
    int delBatchComment(List<Long> item);
    
    Integer queryCommentCount(Map<String, Object> map);
    
    List<ProductComment> queryComment(Map<String, Object> map);
}