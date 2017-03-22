package com.papabear.product.api;

import com.papabear.product.entity.MallBasicCategory;
import com.papabear.product.entity.MallBasicCategoryModel;
import com.papabear.product.entity.MallBasicCategoryModelExt;
import com.papabear.product.entity.MallBasicCategoryModelFormat;
import com.papabear.product.entity.MallFormatExt;

/**
 * 产品基础数据操作接口
 * @author zhaolei
 * @date 2016年3月8日
 *
 */
public interface CategoryCUDService {
	/**
	 * 保存更新产品对象
	 * @param category
	 * @return
	 */
	int saveCategory(MallBasicCategory category);
	/**
	 * 保存产品型号
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param model
	 * @param adminId
	 * @return
	 */
	int saveCategoryModel(MallBasicCategoryModel model,Long adminId);
	/**
	 * 保存规格扩展属性
	 * @author yaoweiguo
	 * @date 2016年6月1日
	 * @param formatId
	 * @param propertyName
	 * @param identify
	 * @param type
	 * @return
	 */
	int saveOrUpdateFormatId(MallFormatExt formatExt);
	/**
	 * 修改产品型号
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param model
	 * @param adminId
	 * @return
	 */
	int updateCategoryModel (MallBasicCategoryModel model,Long adminId);
	
	/**
	 * 更新型号信息
	 * @param model
	 * @return
	 */
	int updateCategoryModel(MallBasicCategoryModel model);
	/**
	 * 产品型号扩展类数据插入
	 * @param basicCategoryModelExt
	 * @return
	 */
	int insertCategoryModelExt(MallBasicCategoryModelExt basicCategoryModelExt);
	/**
	 * 更新产品型号扩展类信息
	 * @param basicCategoryModelExt
	 * @return
	 */
	int updateCategoryModelExt(MallBasicCategoryModelExt basicCategoryModelExt);
	/**
	 * 删除产品型号扩展类基础信息
	 * @param basicCategoryModelExt
	 * @return
	 */
	int removeCategoryModelExt(MallBasicCategoryModelExt basicCategoryModelExt);
	/**
	 * 修改库存数量
	 * @author zhaolei
	 * @date 2016年3月11日
	 * @param id
	 * @param stock
	 */
	void updateStockById(Long id,Integer stock);
	/**
	 * 修改相关产品属性对象
	 * @author zhaolei
	 * @date 2016年3月11日
	 * @param format
	 */
	void updateCategoryModelFormat(MallBasicCategoryModelFormat format);
	
	/**
	 * 
	 * @author yaoweiguo
	 * @date 2016年4月15日
	 * @param formatId		规格ID
	 * @param price			产品原价
	 * @param discountPrice	产品优惠价
	 * @return
	 */
	int updateFormatPriceAndDic(Long formatId,float price,float discountPrice);
	
}
