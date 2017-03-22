package com.papabear.product.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.papabear.commons.entity.enumentity.InvalidEnum;
import com.papabear.product.api.CategoryQueryService;
import com.papabear.product.dao.BasicCategoryDao;
import com.papabear.product.dao.BasicCategoryModelDao;
import com.papabear.product.dao.BasicCategoryModelFormatDao;
import com.papabear.product.dao.MallFormatExtDao;
import com.papabear.product.dao.MallFormatPropertiesValueRelationDao;
import com.papabear.product.dao.MallProductPropertiesDao;
import com.papabear.product.dao.MallProductPropertiesValueDao;
import com.papabear.product.dao.ProductDao;
import com.papabear.product.entity.MallBasicCategory;
import com.papabear.product.entity.MallBasicCategoryModel;
import com.papabear.product.entity.MallBasicCategoryModelFormat;
import com.papabear.product.entity.MallFormatExt;

public class CategoryQueryServiceImpl implements CategoryQueryService {
	@Resource
	private BasicCategoryDao basicCategoryDao;
	@Resource
	private BasicCategoryModelDao basicCategoryModelDao;

	@Resource
	private BasicCategoryModelFormatDao basicCategoryModelFormatDao;
	@Resource
	private MallProductPropertiesDao mallProductPropertiesDao;
	@Resource
	private MallProductPropertiesValueDao mallProductPropertiesValueDao;
	@Resource
	private MallFormatPropertiesValueRelationDao propertiesValueRelationDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private BasicCategoryModelFormatDao formatDao;
	@Resource
	private MallFormatExtDao formatExtDao;
	
	@Override
	public List<MallBasicCategory> queryBasicCategory(Byte status) {
		return basicCategoryDao.queryBasicCategory(status);
	}

	@Override
	public List<MallBasicCategoryModel> queryAllCategoryModel(Byte status) {
		return basicCategoryModelDao.queryAll(status);
	}

	@Override
	public List<MallBasicCategoryModel> queryAllCategoryModel() {
		return this.queryAllCategoryModel((byte) 1);
	}

	@Override
	public MallBasicCategoryModel getModel(Long id) {
		return basicCategoryModelDao.selectByPrimaryKey(id);
	}

	@Override
	public int checkCode(Long categoryId, String code) {
		List<MallBasicCategoryModel> list = basicCategoryModelDao.checkCode(categoryId, code.toUpperCase());
		return list.size() > 0 ? 1 : 0;
	}

	@Override
	public List<MallBasicCategoryModel> queryModelByNotProduct() {
		return basicCategoryModelDao.queryModelByNotProduct();
	}

	@Override
	public List<MallBasicCategoryModel> queryAllCategoryModel(
			Map<String, Object> map) {
		//PageHelper page= new PageHelper();
		//page.startPage(Integer.parseInt(map.get("pageNo").toString()), PageConstant.pageSize, true);
		return basicCategoryModelDao.queryAllFormat(map);
	}

	@Override
	public List<MallBasicCategoryModelFormat> queryByCategoryModel(Long modelId) {
		return formatDao.queryByCategoryModel(modelId, null);
	}

	@Override
	public MallBasicCategoryModelFormat getCategoryModelFormat(Long id) {
		return formatDao.selectByPrimaryKey(id);
	}

	@Override
	public MallBasicCategoryModelFormat queryFormatByCombine(String combine) {
		return formatDao.queryFormatByCombine(combine);
	}

	@Override
	public List<MallBasicCategoryModelFormat> queryFormatsByModelIdAndDisplay(Long modelId,Byte cDisplay,Byte bDisplay) {
		return formatDao.queryFormatsByModelIdAndDisplay(modelId, InvalidEnum.FALSE.getInvalidValue(),cDisplay,bDisplay);
	}
	
	@Override
	public List<MallBasicCategoryModelFormat> queryFormatsByModelId(Long modelId) {
		return formatDao.queryFormatsByModelId(modelId, InvalidEnum.FALSE.getInvalidValue());
	}
	
	@Override
	public List<MallBasicCategoryModel> queryByCategoryId(Long categoryId) {
		return basicCategoryModelDao.queryByCategoryId(categoryId);
	}
	@Override
	public List<MallBasicCategoryModel> queryStockAll(Map<String, Object> map) {
		return basicCategoryModelDao.queryStockAll(map);
	}
	@Override
	public List<MallBasicCategoryModel> queryCategoryModelByIds(List<Long> ids) {
		return basicCategoryModelDao.selectByIds(ids);
	}
	
	@Override
	public List<MallBasicCategoryModelFormat> queryCategoryModelFormatByIds(
			List<Long> ids) {
		return formatDao.selectByIds(ids);
	}
	@Override
	public MallBasicCategory getCategoryById(Long id) {
		return basicCategoryDao.selectByPrimaryKey(id);
	}
	@Override
	public MallBasicCategoryModel getCategoryModelById(Long id) {
		return basicCategoryModelDao.selectByPrimaryKey(id);
	}
	@Override
	public MallBasicCategoryModelFormat getCategoryModelFormatById(Long id) {
		return formatDao.selectByPrimaryKey(id);
	}
	@Override
	public MallBasicCategoryModelFormat getCategoryModelFormat(Long modelId,
			String column, String orderBy) {
		return formatDao.getCategoryModelFormat(modelId, column, orderBy);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.CategoryQueryService#queryMallFormatExts(java.lang.Long)
	 */
	@Override
	public List<MallFormatExt> queryMallFormatExts(Long formatId,Byte type) {
		// TODO Auto-generated method stub
		return formatExtDao.queryMallFormatExts(formatId,type);
	}
}
