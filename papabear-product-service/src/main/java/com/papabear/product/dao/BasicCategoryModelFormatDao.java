package com.papabear.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.papabear.product.entity.MallBasicCategoryModelFormat;

public interface BasicCategoryModelFormatDao {
    int deleteByPrimaryKey(Long id);

    int insert(MallBasicCategoryModelFormat record);

    int insertSelective(MallBasicCategoryModelFormat record);

    MallBasicCategoryModelFormat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallBasicCategoryModelFormat record);

    int updateByPrimaryKey(MallBasicCategoryModelFormat record);
    /**
     * 返回规格列表
     * @param modelId  型号ID
     * @param status   状态
     * @return
     */
    List<MallBasicCategoryModelFormat> queryByCategoryModel(@Param("modelId")Long modelId,@Param("status")Byte status);
    
    /**
     * 获取最大code的对象
     * @param id
     * @return
     */
    MallBasicCategoryModelFormat getBaxicCategoryModelFormatMaxCode(Long id);
    
    MallBasicCategoryModelFormat queryFormatByCombine(String combine); 
    
    /**
	 * 查询某个型号下的所有规格
	 * @param modelId  型号ID
	 * @param invalid  是否有效  false：有效   true:无效 
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryFormatsByModelId(@Param("modelId")Long modelId,@Param("invalid")Boolean invalid);
	
	void updateStockById(@Param("id")Long id, @Param("stock")Integer stock);
	
	List<MallBasicCategoryModelFormat> selectByIds(List<Long> ids);
	
	List<MallBasicCategoryModelFormat> selectByModelId(@Param("modelId")Long modelId);
	
	MallBasicCategoryModelFormat getCategoryModelFormat(@Param("modelId")Long modelId,
			@Param("column")String column, @Param("orderBy")String orderBy);
	/**
	 * 更新价格
	 * @author yaoweiguo
	 * @date 2016年4月15日
	 * @param formatId
	 * @param price
	 * @param discountPrice
	 * @return
	 */
	int updateFormatPriceAndDic(@Param("id")Long id, @Param("price")float price, @Param("discountPrice")float discountPrice);
	
	/**
	 * 根据ID,可见性，查询型号下的所有规格
	 * @param modelId
	 * @param invalid
	 * @param cDisplay
	 * @param bDisplay
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryFormatsByModelIdAndDisplay(
			@Param("modelId")Long modelId,@Param("invalid")Boolean invalid,@Param("cDisplay")Byte cDisplay,@Param("bDisplay")Byte bDisplay);
}