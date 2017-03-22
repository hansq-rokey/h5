package com.papabear.product.api;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.papabear.commons.entity.Pager;
import com.papabear.product.entity.MallProduct;
import com.papabear.product.entity.MallProductDetail;
import com.papabear.product.entity.MallProductPic;
import com.papabear.product.entity.MallProductProperties;
import com.papabear.product.entity.MallProductPropertiesValue;
import com.papabear.product.entity.ProductComment;
import com.papabear.product.entity.ProductCommentTagLib;
import com.papabear.product.entity.ProductType;

public interface ProductQueryService {
	/**
	 * 查询商品
	 * @param status
	 * @return
	 */
	Pager<MallProduct> queryAllProduct(Byte status,Integer pageNo,Integer pageSize);
	
	/**
	 * 
	 * @param status
	 * @param type  1:C端商城列表 2:B端商城列表
	 * @return
	 */
	/**
	 * 根据类型查询不同客户端商城商品
	 * @param status
	 * @param cType		C端商城列表
	 * @param bType		B端商城列表
	 * @param pageNo	当前页码
	 * @param pageSize	数量
	 * @return
	 */
	PageInfo<MallProduct> queryProductBySystem(Byte status,Byte cType,Byte bType,Integer pageNo,Integer pageSize);
	
	
	PageInfo<MallProduct> queryProducts(List<Long> list,Byte status,Byte cType,Byte bType,Integer pageNo,Integer pageSize);
	/**
	 * 获取某个对象
	 * @param id
	 * @return
	 */
	MallProduct getProduct(Long id);
	/**
	 * 根据model的ID和状态获取产品列表
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param modelId
	 * @param invalid
	 * @return
	 */
	List<MallProduct> queryProductByFormat(Long modelId,boolean invalid);
	
	/**
	 * 查询商品信息，默认只查询上架的产品
	 * @param id
	 * @return
	 */
	MallProduct detail(long id);
	
	/**
	 * 查询产品的详情内容
	 * @author yaoweiguo
	 * @date 2016年4月21日
	 * @param productId		产品ID
	 * @param status 		状态，3 H5系统   2，APP系统 ； 1，PC系统
	 * @return
	 */
	MallProductDetail getProductDetail(Long productId,byte status);
	
	/**
	 * 根据产品ID列表查询产品集合
	 * @author zhaolei
	 * @date 2016年3月4日
	 * @param listProductIds
	 * @return
	 */
	List<MallProduct> queryProductListByIds(List<Long> listProductIds);
	/**
	 * 获取上架相关产品列表
	 * @author zhaolei
	 * @date 2016年3月16日
	 * @return
	 */
	List<MallProduct> queryProductIdAndTitleList();
	
	/**
     * 根据型号ID查询产品信息，默认查询已上线产品
     * @param id  型号ID
     * @return
     */
    MallProduct getProductByModeleId(Long id);
    /**
     * 获取产品列表带分页appServer使用
     * @param status
     * @param start
     * @param end
     * @return
     */
    List<MallProduct> queryListMallProduct(Short status,int start,int end);
    /**
     * 根据模板ID查询商品
     * @param id  模板ID
     * @return
     */
    List<MallProduct> queryProductByTemplateId(Long id);
    /**
	 * 获取产品图片列表
	 * @param product
	 * @param type
	 * @param status
	 * @return
	 */
	List<MallProductPic> queryPics(MallProduct product,Long formatId,Short type);
	
	/**
	 * 获取某个对象
	 * @param id
	 * @return
	 */
	MallProductPic getProductPic(Long id);
	/**
     * 查询产品图片
     * @param map
     * @return
     */
    List<MallProductPic> queryProductPicByFormatId(Map<String, Object> map);
    /**
	 * 根据型号ID查询属性列表
	 * @param modelId
	 * @return
	 */
	List<MallProductProperties> queryProductPropertiesByModelId(Long modelId);
	/**
	 * 获取单个产品对象
	 * @param id
	 * @return
	 */
	ProductType getProductType(Long id);
	
	/**
	 * 查询产品类型
	 * @param status 业务状态
	 * @return
	 */
	List<ProductType> queryProductTypeList(Short status);
	/**
	 * 查询获取带formatsList的列表
	 * @author zhaolei
	 * @date 2016年3月16日
	 * @param id
	 * @return
	 */
	MallProduct getProductListFormatByPrimaryKey(@Param("id")long id);
	/**
	 * 查询产品属性值列表
	 * @param propertiesId 属性ID
	 * @param invalid 状态
	 * @return
	 */
	List<MallProductPropertiesValue> queryByPropertiesId(Long propertiesId,Byte invalid);
	/**
	 * 返回评论列表
	 * @param productId 产品ID
	 * @param status		状态，1：推荐评论  2 ：普通用户评论
	 * @param flag 是否需要携带评论图片列表对象  true 返回评论图片列表，false 不需要评论列表
	 * @param pageNo 当前页数 不传默认1
	 * @param pageSize 页码条数 不传默认10
	 * @return
	 */
	Pager<ProductComment> queryByProductIdAndFormatId(Long productId,byte status,boolean flag,int pageNo, int pageSize);
	/**
	 * 返回评论列表
	 * @author yaoweiguo
	 * @date 2016年4月21日
	 * @param productId		产品ID
	 * @param flag			是否需要携带评论图片列表对象  true 返回评论图片列表，false 不需要评论列表
	 * @param pageSize		页面条数，默认从第一页开始
	 * @param status		状态，1：推荐评论  2 ：普通用户评论
	 * @return
	 */
	List<ProductComment> queryProductComments(Long productId,boolean flag ,int pageSize,byte status);
	/**
	 * 查询标签列表 按照产品查询
	 * @param productId 产品ID
	 * @param invalid 默认值0
	 * @return
	 */
	List<ProductCommentTagLib> queryAllByProductId(Long productId,Byte invalid);
	
	/**
	 * 获取推荐评论详细信息
	 * @author yaoweiguo
	 * @date 2016年4月27日
	 * @param id			评论ID
	 * @param flag			是否需要携带评论图片列表对象  true 返回评论图片列表，false 不需要评论列表
	 * @return
	 */
	ProductComment getProductComment(Long id,boolean flag);
}
