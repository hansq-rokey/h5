package com.papabear.product.api;

import java.util.List;

import com.papabear.product.entity.MallProduct;
import com.papabear.product.entity.MallProductDetail;
import com.papabear.product.entity.MallProductPic;
import com.papabear.product.entity.MallProductTag;
import com.papabear.product.entity.MallProductTagData;
import com.papabear.product.entity.ProductComment;
import com.papabear.product.entity.ProductCommentPic;
import com.papabear.product.entity.ProductCommentTagLib;
import com.papabear.product.entity.ProductType;

public interface ProductCUDService {

	
	long createMallProduct(MallProduct product);
	
	int createProductDetail(MallProductDetail detail);
	
	/**
	 * 添加商品图片
	 * @param productId	产品ID
	 * @param formatId	规格ID
	 * @param sort		排序
	 * @param type		类型，1 产品缩略图 2 规格缩略图 3APP产品详细顶部图
	 * @param url		图片url
	 * @return
	 */
	long createMallProductPic(Long productId,Long formatId,int sort,byte type,String url);
	
	long updateMallProductPic(MallProductPic pic);
	/**
	 * 修改产品
	 * @author zhaolei
	 * @date 2016年3月8日
	 * @param product
	 * @param file
	 * @return
	 */
	int updateProduct(MallProduct product);
	
	int updateProductDetail(MallProductDetail detail);

	/**
	 * 删除产品
	 * @author zhaolei
	 * @date 2016年3月8日
	 * @param id
	 * @param adminId
	 * @return
	 */
	int deleteProduct(Long id,Long adminId);
	
	int deleteProductPic(Long id);
	/**
	 * 新增数据产品类型
	 * @param productType
	 * @return
	 */
	int saveProductType(ProductType productType);
	
	/**
	 * 更新产品类型
	 * @param productType
	 * @return
	 */
	int updateProductType(ProductType productType);
	/**
	 * 添加评论
	 * @param comment
	 * @return 返回评论ID
	 */
	Long saveComment(ProductComment comment);
	/**
	 * 批量删除评论
	 * @param commentIds
	 * @return
	 */
	int delBatchComment(List<Long> commentIds);
	/**
	 * 	插入评论图片
	 * @param pic
	 * @return 返回图片ID
	 */
	Long saveCommentPic(ProductCommentPic pic);
	/**
	 * 修改图片信息按照ID修改
	 * @param pic
	 * @return
	 */
	int updateCommentPic(ProductCommentPic pic);
	/**
	 * 修改图片信息与评论关系 
	 * 按照用户ID查询出图片列表中评论ID为空的记录，直接批量更新评论ID
	 * @param userId 评论图片对象用户
	 * @param commentId 评论主键ID 
	 * @return
	 */
	int updateCommentPic(Long userId,Long commentId);
	/**
	 * 修改图片信息按照ID，userId修改
	 * @param pic
	 * @return
	 */
	int updateCommentPicByUserId(ProductCommentPic pic);
	/**
	 * 删除图片记录主键物理删除
	 * @param pic
	 * @return
	 */
	int delCommentPic(ProductCommentPic pic);
	/**
	 * 添加标签库
	 * @param tagLib
	 * @return
	 */
	Long saveCommentTagLib(ProductCommentTagLib tagLib);
	/**
	 * 修改标签库
	 * @param tagLib
	 * @return
	 */
	int updateCommentTagLib(ProductCommentTagLib tagLib);
	
	/**
	 * 增加商品标签
	 * @param record
	 * @return
	 */
	int insert(MallProductTag record);
	
	/**
	 * 修改商品标签
	 * @param record
	 * @return
	 */
	int updateProductTag(MallProductTag record);
	
	/**
	 * 根据产品Id，查询标签
	 * @param productId
	 * @return
	 */
	List<MallProductTag> queryProductTagsByProductId(Long productId);
	
	/**
	 * 删除商品标签
	 * @param productId
	 * @return
	 */
	int deleteProductTagByProductId(Long productId);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteProductTag(Long id);
	/**
	 * 查询所有的标签
	 * @return
	 */
	List<MallProductTagData> queryListTags();
	
	/**
	 * 根据产品ID和标签ID查询商品标签
	 * @param productId
	 * @param tagId
	 * @return
	 */
	MallProductTag selectProductTagByIds(Long productId,Long tagId);
}
