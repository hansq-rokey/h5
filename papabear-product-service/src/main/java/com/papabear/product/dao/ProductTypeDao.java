package com.papabear.product.dao;

import java.util.List;

import com.papabear.product.entity.ProductType;

public interface ProductTypeDao {
    int deleteByPrimaryKey(Long id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
    
    
    /**
	 * 查询产品类型
	 * @param status 业务状态
	 * @return
	 */
	List<ProductType> queryProductTypeByStatus(Short status);
}