package com.papabear.product.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.papabear.commons.entity.enumentity.Constant;
import com.papabear.product.api.ProductCUDService;
import com.papabear.product.dao.BasicCategoryDao;
import com.papabear.product.dao.BasicCategoryModelDao;
import com.papabear.product.dao.BasicCategoryModelFormatDao;
import com.papabear.product.dao.MallProductDetailDao;
import com.papabear.product.dao.MallProductTagDao;
import com.papabear.product.dao.MallProductTagDataDao;
import com.papabear.product.dao.ProductCommentDao;
import com.papabear.product.dao.ProductCommentPicDao;
import com.papabear.product.dao.ProductCommentTagLibDao;
import com.papabear.product.dao.ProductDao;
import com.papabear.product.dao.ProductPicDao;
import com.papabear.product.dao.ProductTypeDao;
import com.papabear.product.entity.MallProduct;
import com.papabear.product.entity.MallProductDetail;
import com.papabear.product.entity.MallProductPic;
import com.papabear.product.entity.MallProductTag;
import com.papabear.product.entity.MallProductTagData;
import com.papabear.product.entity.ProductComment;
import com.papabear.product.entity.ProductCommentPic;
import com.papabear.product.entity.ProductCommentTagLib;
import com.papabear.product.entity.ProductType;

public class ProductCUDServiceImpl implements ProductCUDService {
	@Resource
	private BasicCategoryModelDao modelDao;
	@Resource
	private BasicCategoryDao categoryDao;
	@Resource
	private BasicCategoryModelFormatDao formatDao;
	@Resource
	private ProductPicDao productPicDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private ProductTypeDao productTypeDao;
	@Resource
	private ProductCommentDao productCommentDao;
	@Resource
	private ProductCommentPicDao productCommentPicDao;
	@Resource
	private ProductCommentTagLibDao productCommentTagLibDao;
	@Resource
	private MallProductDetailDao mallProductDetailDao;
	@Resource
	private MallProductTagDao productTagDao;
	@Resource
	private MallProductTagDataDao productTagDataDao;

	@Override
	public int deleteProduct(Long id, Long adminId) {
		MallProduct product = new MallProduct();
		product.setId(id);
		product.setUpdateTime(new Date());
		product.setCreatorId(adminId);
		product.setStatus((byte) 2);// 删除 具体请查询数据库字典 PRODUCT_STATS
		return productDao.updateByPrimaryKeySelective(product);
	}

	@Override
	public int saveProductType(ProductType productType) {
		productType.setCreateDateTime(new Date());
		productType.setStatus(Constant.Status.NORMAL.getStatus());
		productTypeDao.insertSelective(productType);
		return 1;
	}

	@Override
	public int updateProductType(ProductType productType) {
		productType.setUpdateTime(new Date());
		productTypeDao.updateByPrimaryKeySelective(productType);
		return 1;
	}
	@Override
	public Long saveComment(ProductComment comment) {
		return productCommentDao.insertSelective(comment);
	}
	@Override
	public int delBatchComment(List<Long> commentIds) {
		return productCommentDao.delBatchComment(commentIds);
	}
	@Override
	public Long saveCommentPic(ProductCommentPic pic) {
		productCommentPicDao.insertSelective(pic);
		return pic.getId();
	}
	@Override
	public int updateCommentPic(ProductCommentPic pic) {
		return productCommentPicDao.updateByPrimaryKeySelective(pic);
	}
	@Override
	public int updateCommentPic(Long userId, Long commentId) {
		return productCommentPicDao.updateCommentPic(userId, commentId);
	}
	@Override
	public Long saveCommentTagLib(ProductCommentTagLib tagLib) {
		return productCommentTagLibDao.insertSelective(tagLib);
	}
	@Override
	public int updateCommentTagLib(ProductCommentTagLib tagLib) {
		return productCommentTagLibDao.updateByPrimaryKeySelective(tagLib);
	}
	@Override
	public int delCommentPic(ProductCommentPic pic) {
		return productCommentPicDao.deleteByPrimaryKey(pic.getId());
	}
	@Override
	public int updateCommentPicByUserId(ProductCommentPic pic) {
		return productCommentPicDao.updateCommentPicByUserId(pic);
	}

	@Override
	public long createMallProduct(MallProduct product) {
		product.setCreateDateTime(new Date());
		product.setUpdateTime(new Date());
			productDao.insert(product);
		return product.getId();
	}


	@Override
	public long createMallProductPic(Long productId, Long formatId, int sort, byte type, String url) {
		MallProductPic productPic = new MallProductPic();
		productPic.setCreateDateTime(new Date());
		productPic.setProductId(productId);
		productPic.setProductModelFormatId(formatId);
		productPic.setSort(sort);
		productPic.setType(type);
		productPic.setStatus((byte) 1);
		productPic.setUpdateTime(new Date());
		productPic.setUrl(url);
		productPicDao.insertSelective(productPic);
		return productPic.getId();
	}
	/* (non-Javadoc)
	 * @see com.papabear.product.api.ProductCUDService#updateProduct(com.papabear.product.entity.MallProduct)
	 */
	@Override
	public int updateProduct(MallProduct product) {
		
		product.setUpdateTime(new Date());
		return productDao.updateByPrimaryKeySelective(product);
	}
	/* (non-Javadoc)
	 * @see com.papabear.product.api.ProductCUDService#updateMallProductPic(com.papabear.product.entity.MallProductPic)
	 */
	@Override
	public long updateMallProductPic(MallProductPic pic) {
		
		return productPicDao.updateByPrimaryKeySelective(pic);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.ProductCUDService#createProductDetail(com.papabear.product.entity.MallProductDetail)
	 */
	@Override
	public int createProductDetail(MallProductDetail detail) {
		
		return mallProductDetailDao.insertSelective(detail);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.ProductCUDService#updateProductDetail(com.papabear.product.entity.MallProductDetail)
	 */
	@Override
	public int updateProductDetail(MallProductDetail detail) {
		// TODO Auto-generated method stub
		return mallProductDetailDao.updateByPrimaryKeySelective(detail);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.ProductCUDService#deleteProductPic(java.lang.Long)
	 */
	@Override
	public int deleteProductPic(Long id) {
		
		return productPicDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MallProductTag record) {
		// TODO Auto-generated method stub
		return productTagDao.insert(record);
	}

	@Override
	public int updateProductTag(MallProductTag record) {
		// TODO Auto-generated method stub
		return productTagDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<MallProductTagData> queryListTags() {
		// TODO Auto-generated method stub
		return productTagDataDao.queryListTags();
	}

	@Override
	public List<MallProductTag> queryProductTagsByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productTagDao.queryProductTagsByProductId(productId);
	}

	@Override
	public int deleteProductTagByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productTagDao.deleteProductTagByProductId(productId);
	}

	@Override
	public int deleteProductTag(Long id) {
		// TODO Auto-generated method stub
		return productTagDao.deleteByPrimaryKey(id);
	}

	@Override
	public MallProductTag selectProductTagByIds(Long productId, Long tagId) {
		// TODO Auto-generated method stub
		return productTagDao.selectByProductIdAndTagId(productId, tagId);
	}

}
