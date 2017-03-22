package com.papabear.product.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallBasicCategoryModel;

public interface BasicCategoryModelDao {
    int deleteByPrimaryKey(Long id);
  
    int insert(MallBasicCategoryModel record);

    int insertSelective(MallBasicCategoryModel record);

    MallBasicCategoryModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallBasicCategoryModel record);

    int updateByPrimaryKey(MallBasicCategoryModel record);
    
    List<MallBasicCategoryModel> queryAll(@Param("status")Byte status);
    
    /**
	 * 校验该分类下是否存在编码
	 * @param categoryId   分类ID
	 * @param code		        商品编码
	 * @return
	 */
    List<MallBasicCategoryModel> checkCode(@Param("categoryId")Long categoryId, @Param("code")String code);
    /**
     * 查询没有被发布的商品的型号
     * @return
     */
    List<MallBasicCategoryModel> queryModelByNotProduct();
    
    List<MallBasicCategoryModel> queryAllFormat(Map<String, Object> map);
    
    List<MallBasicCategoryModel> queryByCategoryId(Long categoryId);

    List<MallBasicCategoryModel> queryStockAll(Map<String, Object> map);
    
    List<MallBasicCategoryModel> selectByIds(List<Long> ids);
}