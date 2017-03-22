package com.papabear.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.papabear.commons.entity.Pager;
import com.papabear.commons.entity.enumentity.InvalidEnum;
import com.papabear.product.api.ProductQueryService;
import com.papabear.product.dao.BasicCategoryDao;
import com.papabear.product.dao.BasicCategoryModelDao;
import com.papabear.product.dao.BasicCategoryModelFormatDao;
import com.papabear.product.dao.MallProductDetailDao;
import com.papabear.product.dao.MallProductPropertiesDao;
import com.papabear.product.dao.MallProductPropertiesValueDao;
import com.papabear.product.dao.ProductCommentDao;
import com.papabear.product.dao.ProductCommentPicDao;
import com.papabear.product.dao.ProductCommentTagLibDao;
import com.papabear.product.dao.ProductDao;
import com.papabear.product.dao.ProductPicDao;
import com.papabear.product.dao.ProductTypeDao;
import com.papabear.product.entity.MallProduct;
import com.papabear.product.entity.MallProductDetail;
import com.papabear.product.entity.MallProductPic;
import com.papabear.product.entity.MallProductProperties;
import com.papabear.product.entity.MallProductPropertiesValue;
import com.papabear.product.entity.ProductComment;
import com.papabear.product.entity.ProductCommentPic;
import com.papabear.product.entity.ProductCommentTagLib;
import com.papabear.product.entity.ProductType;

public class ProductQueryServiceImpl implements ProductQueryService {
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
	private MallProductPropertiesDao mallProductPropertiesDao;
	@Resource
	private ProductTypeDao productTypeDao;
	@Resource
	private MallProductPropertiesValueDao mallProductPropertiesValueDao;
	@Resource
	private ProductCommentDao productCommentDao;
	@Resource
	private ProductCommentPicDao productCommentPicDao;
	@Resource
	private ProductCommentTagLibDao productCommentTagLibDao;
	@Resource
	private MallProductDetailDao mallProductDetailDao;

	@Override
	public Pager<MallProduct> queryAllProduct(Byte status, Integer pageNo,Integer pageSize) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("status", status);
		int total = productDao.queryProductByStatusCount(status);
		Pager<MallProduct> pager = new Pager<MallProduct>(total, pageNo, pageSize);
		map.put("pageSize", pageSize);
		map.put("numbers", pager.getCurentNumber());
		// PageHelper page = new PageHelper();
		// page.startPage(pageNo, PageConstant.pageSize, true);
		List<MallProduct> list = productDao.queryProductByStatus(map);
		pager.setList(list);
		return pager;
	}

	@Override
	public MallProduct getProduct(Long id) {
		return productDao.selectByPrimaryKey(id);
	}

	@Override
	public List<MallProduct> queryProductByFormat(Long modelId, boolean invalid) {
		return productDao.queryProductByFormat(modelId);
	}

	@Override
	public MallProduct detail(long id) {
		MallProduct product = productDao.getMallProduct(id, (byte) 1);
		return product;
	}

	@Override
	public List<MallProduct> queryProductListByIds(List<Long> listProductIds) {
		return productDao.selectProductListByIds(listProductIds);
	}

	@Override
	public MallProduct getProductByModeleId(Long id) {
		return productDao.getProductByModeleId(id);
	}

	@Override
	public List<MallProductPic> queryPics(MallProduct product, Long formatId, Short type) {
		Long productId = null;
		if (product != null)
			productId = product.getId();
		return productPicDao.queryPics(productId, formatId, type);
	}

	@Override
	public MallProductPic getProductPic(Long id) {
		return productPicDao.selectByPrimaryKey(id);
	}

	@Override
	public List<MallProductPic> queryProductPicByFormatId(Map<String, Object> map) {
		map.put("status", 1);
		return productPicDao.queryProductPicByFormatId(map);
	}

	@Override
	public List<MallProductProperties> queryProductPropertiesByModelId(Long modelId) {
		return mallProductPropertiesDao.queryMallProductPropertiesByModelId(modelId, InvalidEnum.FALSE.getInvalidValue());
	}

	@Override
	public ProductType getProductType(Long id) {
		return productTypeDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductType> queryProductTypeList(Short status) {
		return productTypeDao.queryProductTypeByStatus(status);
	}

	@Override
	public List<MallProduct> queryProductIdAndTitleList() {
		return productDao.getProductIdAndTitleList();
	}

	@Override
	public MallProduct getProductListFormatByPrimaryKey(long id) {
		return productDao.getProductListFormatByPrimaryKey(id);
	}

	@Override
	public List<MallProductPropertiesValue> queryByPropertiesId(Long propertiesId, Byte invalid) {
		return mallProductPropertiesValueDao.selectByPropertiesId(propertiesId, invalid);
	}

	@Override
	public List<MallProduct> queryListMallProduct(Short status, int start, int end) {
		return productDao.selectListMallProduct(status, start, end);
	}

	@Override
	public List<ProductCommentTagLib> queryAllByProductId(Long productId, Byte invalid) {
		if (invalid == null)
			invalid = 0;
		return productCommentTagLibDao.queryAllByProductId(productId, invalid);
	}

	@Override
	public Pager<ProductComment> queryByProductIdAndFormatId(Long productId, byte status, boolean flag, int pageNo, int pageSize) {
		if (pageNo == 0)
			pageNo = 1;
		if (pageSize == 0)
			pageNo = 10;
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("productId", productId);
		paramters.put("status", status);
		// 查询总条数
		int total = productCommentDao.queryCommentCount(paramters);
		Pager<ProductComment> pager = new Pager<ProductComment>(total, pageNo, pageSize);
		paramters.put("numbers", pager.getCurentNumber());
		paramters.put("pageSize", pageSize);
		List<ProductComment> list = productCommentDao.queryComment(paramters);
		List<ProductComment> resList = new ArrayList<ProductComment>();
		if (flag) {
			if (list != null && list.size() > 0) {
				// 说明是需要带图片列表的
				for (ProductComment productComment : list) {
					String taglibs = productComment.getCommmentTagIds();
					if (taglibs != null && taglibs.length() > 0) {
						List<ProductCommentTagLib> tagList = new ArrayList<ProductCommentTagLib>();
						String[] tagIds = taglibs.split(",");
						for (String tagId : tagIds) {
							if (StringUtils.isNotBlank(tagId)) {
								ProductCommentTagLib commentTagLib = productCommentTagLibDao.selectByPrimaryKey(Long.valueOf(tagId));
								tagList.add(commentTagLib);
							}
						}
						productComment.setTagLibs(tagList);
					}
					// 按照commentI查找图片列表
					List<ProductCommentPic> picLists = productCommentPicDao.queryListByCommentIdAndUserId(productComment.getUserId(),
							productComment.getId());
					productComment.setPicLists(picLists);
					resList.add(productComment);
				}
			}
		}
		pager.setList(resList);
		return pager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.papabear.product.api.ProductQueryService#queryProductComments(java
	 * .lang.Long, boolean, int, byte)
	 */
	@Override
	public List<ProductComment> queryProductComments(Long productId, boolean flag, int pageSize, byte status) {
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("productId", productId);
		paramters.put("status", status);
		paramters.put("numbers", 0);
		paramters.put("pageSize", pageSize);
		List<ProductComment> list = productCommentDao.queryComment(paramters);
		if (flag) {
			if (list != null && list.size() > 0) {
				// 说明是需要带图片列表的
				for (ProductComment productComment : list) {
					// 按照commentI查找图片列表
					List<ProductCommentPic> picLists = productCommentPicDao.queryListByCommentIdAndUserId(productComment.getUserId(),
							productComment.getId());
					productComment.setPicLists(picLists);
				}
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.papabear.product.api.ProductQueryService#getProductDetail(java.lang
	 * .Long)
	 */
	@Override
	public MallProductDetail getProductDetail(Long productId, byte status) {
		// TODO Auto-generated method stub
		return mallProductDetailDao.getMallProductDetail(productId, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.papabear.product.api.ProductQueryService#getProductComment(java.lang
	 * .Long, boolean)
	 */
	@Override
	public ProductComment getProductComment(Long id, boolean flag) {
		ProductComment comment = productCommentDao.selectByPrimaryKey(id);
		if (comment != null) {
			String taglibs = comment.getCommmentTagIds();
			if (taglibs != null && taglibs.length() > 0) {
				List<ProductCommentTagLib> list = new ArrayList<ProductCommentTagLib>();
				String[] tagIds = taglibs.split(",");
				for (String tagId : tagIds) {
					if (StringUtils.isNotBlank(tagId)) {
						ProductCommentTagLib commentTagLib = productCommentTagLibDao.selectByPrimaryKey(Long.valueOf(tagId));
						list.add(commentTagLib);
					}
				}
				comment.setTagLibs(list);
			}

			if (flag) {
				// 说明是需要带图片列表的
				// 按照commentI查找图片列表
				List<ProductCommentPic> picLists = productCommentPicDao.queryListByCommentIdAndUserId(comment.getUserId(), comment.getId());
				comment.setPicLists(picLists);
			}
		}
		return comment;
	}

	@Override
	public PageInfo<MallProduct> queryProductBySystem(Byte status,Byte cType,Byte bType,Integer pageNo,Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize, true);
		List<MallProduct> list=productDao.queryProductBySystem(status, cType, bType);
		PageInfo<MallProduct> pageInfo=new PageInfo<MallProduct>(list);
		return pageInfo;
	}
	
	@Override
	public PageInfo<MallProduct> queryProducts(List<Long> productIds,Byte status,Byte cType,Byte bType,Integer pageNo,Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize, true);
		List<MallProduct> list=productDao.queryProducts(productIds,status, cType, bType);
		PageInfo<MallProduct> pageInfo=new PageInfo<MallProduct>(list);
		return pageInfo;
	}

	@Override
	public List<MallProduct> queryProductByTemplateId(Long id) {
		// TODO Auto-generated method stub
		return productDao.queryProductByTemplateId(id);
	}

}
