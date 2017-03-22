package com.papabear.product.api;

import java.util.List;
import java.util.Map;

import com.papabear.product.entity.MallBasicCategory;
import com.papabear.product.entity.MallBasicCategoryModel;
import com.papabear.product.entity.MallBasicCategoryModelFormat;
import com.papabear.product.entity.MallFormatExt;
/**
 * 
 * @author Administrator
 *
 */
public interface CategoryQueryService {
	/**
	 * 查询基础种类列表	
	 * @author zhaolei
	 * @date 2016年3月8日
	 * @param status
	 * @return
	 */
	List<MallBasicCategory> queryBasicCategory(Byte status);
	/**
	 * 查询所有列表集合根据状态
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param status
	 * @return
	 */
	List<MallBasicCategoryModel> queryAllCategoryModel(Byte status);
	/**
	 * 查询所有
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @return
	 */
	List<MallBasicCategoryModel> queryAllCategoryModel();
	/**
	 * 根据ID获取对象
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param id
	 * @return
	 */
	MallBasicCategoryModel getModel(Long id);
	/**
	 * 校验该分类下是否存在编码
	 * @param categoryId   分类ID
	 * @param code		        商品编码
	 * @return 1：已存在  0：不存在
	 */
	int checkCode(Long categoryId,String code);
	
	/**
	 * 查询没有关联产品的型号
	 * @return
	 */
	List<MallBasicCategoryModel> queryModelByNotProduct();
	/**
	 * 查询所有产品列表
	 * @author zhaolei
	 * @date 2016年1月11日
	 * @param map
	 * @return
	 */
	List<MallBasicCategoryModel> queryAllCategoryModel(Map<String, Object> map);
	/**
	 * 根据产品型号获取产品format的列表集合
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param modelId
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryByCategoryModel(Long modelId);
	/**
	 * 主键获取对象
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param id
	 * @return
	 */
	MallBasicCategoryModelFormat getCategoryModelFormat(Long id);
	
	/**
	 * 查询规格扩展属性
	 * @author yaoweiguo
	 * @date 2016年5月26日
	 * @param formatId
	 * @return
	 */
	List<MallFormatExt> queryMallFormatExts(Long formatId,Byte type);
	
	/**
	 * 方向查询价格
	 * @param combine  属性值连接串
	 * @return
	 */
	MallBasicCategoryModelFormat queryFormatByCombine(String combine);
	
	/**
	 * 查询某个型号下的所有有效规格
	 * @param modelId  型号ID
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryFormatsByModelId(Long modelId);
	
	List<MallBasicCategoryModel> queryByCategoryId(Long categoryId);
	
	List<MallBasicCategoryModel> queryStockAll(Map<String, Object> map);
	/**
	 * 通过产品型号ID列表查询
	 * @author zhaolei
	 * @date 2016年3月11日
	 * @param ids
	 * @return
	 */
	List<MallBasicCategoryModel> queryCategoryModelByIds(List<Long> ids);
	/**
	 * 查询规格列表按照ID
	 * @author zhaolei
	 * @date 2016年3月11日
	 * @param ids
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryCategoryModelFormatByIds(List<Long> ids);
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	MallBasicCategoryModel getCategoryModelById(Long id);
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	MallBasicCategoryModelFormat getCategoryModelFormatById(Long id);
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	MallBasicCategory getCategoryById(Long id);
	/**
	 * 根据modelID取规格对象
	 * @param modelId 产品ID
	 * @param column 字段名 (表的字段名如 name,pric)
	 * @param orderBy 排序 支持(asc ,desc)
	 * @return
	 * 举例：
	 * 1.getCategoryModelFormat(1,pric,asc) 返回的是产品ID为1，按照pric字段，进行asc排序后返回的第一条记录
	 * 2.getCategoryModelFormat(1,money,desc) 返回的是产品ID为1，按照money字段，进行desc排序后返回的第一条记录
	 * 
	 * 
	 */
	MallBasicCategoryModelFormat getCategoryModelFormat(Long modelId,String column,String orderBy);
	
	/**
	 * 查询某个型号下的所有有效规格
	 * @param modelId  型号ID
	 * @return
	 */
	List<MallBasicCategoryModelFormat> queryFormatsByModelIdAndDisplay(Long modelId,Byte cDisplay,Byte bDisplay);
}
