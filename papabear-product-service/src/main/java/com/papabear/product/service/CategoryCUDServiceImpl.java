package com.papabear.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.papabear.commons.entity.enumentity.InvalidEnum;
import com.papabear.commons.utils.Assert;
import com.papabear.product.api.CategoryCUDService;
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
import com.papabear.product.entity.MallBasicCategoryModelExt;
import com.papabear.product.entity.MallBasicCategoryModelFormat;
import com.papabear.product.entity.MallFormatExt;
import com.papabear.product.entity.MallFormatPropertiesValueRelation;
import com.papabear.product.entity.MallProductProperties;
import com.papabear.product.entity.MallProductPropertiesExt;
import com.papabear.product.entity.MallProductPropertiesValue;

public class CategoryCUDServiceImpl implements CategoryCUDService {
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
	private MallFormatExtDao formatExtDao;
	@Resource
	private ProductDao productDao;
	
	@Override
	public int saveCategory(MallBasicCategory category) {
		if(category.getId()==null){
			category.setCreateDateTime(new Date());
			category.setStatus((byte)1);
			category.setUpdateTime(new Date());
			return basicCategoryDao.insert(category);
		}else{
			category.setUpdateTime(new Date());
			return basicCategoryDao.updateByPrimaryKeySelective(category);
		}
	}

	@Override
	public int saveCategoryModel(MallBasicCategoryModel model, Long adminId) {
		model.setCreateDateTime(new Date());
		model.setUpdateTime(new Date());
		model.setStatus((byte) 1);
		model.setCreatorId(adminId);
		int i = 1;
		basicCategoryModelDao.insertSelective(model);
		MallBasicCategory category = basicCategoryDao.selectByPrimaryKey(model.getCategoryId());
		for (MallBasicCategoryModelFormat format : model.getFormats()) {
			format.setBasicCategoryModel(model);
			format.setCreateDateTime(new Date());
			format.setCategoryModelId(model.getId());
			format.setUpdateTime(new Date());
			format.setStatus((byte) 1);
			format.setCategoryId(model.getCreatorId());
			format.setCreatorId(adminId);
			String tmp = i < 10 ? "0" : "";
			format.setCode(tmp + i);
			format.setCategoryModelFormatNumber(category.getCode() + model.getCode() + tmp + i);
			basicCategoryModelFormatDao.insert(format);
		}

		return 1;
	}

	@Override
	public int updateCategoryModel(MallBasicCategoryModel model, Long adminId) {
		model.setUpdateTime(new Date());
		model.setCreatorId(adminId);
		basicCategoryModelDao.updateByPrimaryKeySelective(model);
		for (MallBasicCategoryModelFormat format : model.getFormats()) {
			if (format.getId() == null) {
				format.setBasicCategoryModel(model);
				format.setCreateDateTime(new Date());
				format.setCategoryModelId(model.getId());
				format.setUpdateTime(new Date());
				format.setStatus((byte) 1);
				format.setCategoryId(model.getCreatorId());
				format.setCreatorId(adminId);
				// format.setCode(code);
				// format.setCategoryModelFormatNumber(categoryModelFormatNumber);
				basicCategoryModelFormatDao.insert(format);
			} else {
				format.setBasicCategoryModel(model);
				format.setUpdateTime(new Date());
				format.setCreatorId(adminId);
				basicCategoryModelFormatDao.updateByPrimaryKeySelective(format);
			}
		}
		return 1;
	}

	@Override
	public int updateCategoryModel(MallBasicCategoryModel model) {
		model.setUpdateTime(new Date());
		return basicCategoryModelDao.updateByPrimaryKeySelective(model);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insertCategoryModelExt(
			MallBasicCategoryModelExt basicCategoryModelExt) {
		MallBasicCategoryModel model = new MallBasicCategoryModel();
		model.setCategoryId(basicCategoryModelExt.getCategoryId());
		model.setCode(basicCategoryModelExt.getCode().toUpperCase());
		model.setCreateDateTime(new Date());
		model.setCreatorId(basicCategoryModelExt.getCreatorId());
		model.setInvalid(InvalidEnum.FALSE.getInvalidValue());
		model.setName(basicCategoryModelExt.getName());
		model.setStatus((byte) 1);
		model.setUpdateTime(new Date());
		basicCategoryModelDao.insert(model);
		int sort = 1;
		List<MallProductPropertiesExt> propertiesList = basicCategoryModelExt.getProperties();
		String ids = "";
		long smartPropertiesValueId = 0;// 智能属性值ID
		long isCustomMadePropertiesValueId = 0;// 是否私人订制
		for (MallProductPropertiesExt property : propertiesList) {
			// 属性名称为空
			if (StringUtils.isBlank(property.getPropertyName()) || property.getPropertiesValuees() == null
					|| property.getPropertiesValuees().size() == 0) {
				continue;
			}
			MallProductProperties properties = this.createMallProductProperties(property, model, sort);
			mallProductPropertiesDao.insert(properties);
			int valueSort = 1;
			boolean flag = true;
			for (MallProductPropertiesValue mppv : property.getPropertiesValuees()) {
				if (StringUtils.isBlank(mppv.getValue()))
					continue;
				MallProductPropertiesValue value = this.createMallProductPropertiesValue(mppv, properties, valueSort);
				mallProductPropertiesValueDao.insert(value);
				// 更新该属性类型 文字还是图文 、图片
				if (StringUtils.isNotBlank(mppv.getImageUrl()) && mppv.getImageUrl().length() > 0) {
					if (flag) {
						MallProductProperties p = new MallProductProperties();
						p.setDisplayFormat((short) 2);// 图文显示
						p.setId(properties.getId());
						flag = false;
						mallProductPropertiesDao.updateByPrimaryKeySelective(p);
					}
				}
				if (value.getIsCustomMade().intValue() == 1) {
					MallProductProperties p = new MallProductProperties();
					p.setId(properties.getId());
					p.setIsCustomMade((byte) 1);
					isCustomMadePropertiesValueId = value.getId();
					mallProductPropertiesDao.updateByPrimaryKeySelective(p);
				}

				if (properties.getPropertyName().contains("智能")) {
					if (StringUtils.isNotBlank(mppv.getValue()) && mppv.getValue().trim().equals("智能")) {
						smartPropertiesValueId = value.getId();
					}
				}
				ids += value.getId().toString() + ",";
				valueSort++;
			}
			ids += "==";
			sort++;
		}
		// System.out.println("ids==="+ids);
		// System.out.println("smartPropertiesValueId==="+smartPropertiesValueId);
		List<String> result = this.descartes(ids);
		this.saveFormat(result, model, basicCategoryDao.selectByPrimaryKey(model.getCategoryId()), smartPropertiesValueId,
				isCustomMadePropertiesValueId);
		return 0;
	}
	private MallProductProperties createMallProductProperties(MallProductPropertiesExt property, MallBasicCategoryModel model, int sort) {
		MallProductProperties properties = new MallProductProperties();
		properties.setCreateDateTime(new Date());
		properties.setInvalid(InvalidEnum.FALSE.getInvalidValue());
		properties.setPropertyName(property.getPropertyName());
		properties.setSort(sort);
		properties.setStatus((byte) 1);
		properties.setIsCustomMade((byte) 0);
		properties.setIsTrace((byte) 0);
		properties.setDisplayFormat((short) 1);// 默认文字
		properties.setCategoryModelId(model.getId());
		properties.setUpdateTime(new Date());
		return properties;
	}

	private MallProductPropertiesValue createMallProductPropertiesValue(MallProductPropertiesValue mppv, MallProductProperties properties,
			int valueSort) {
		MallProductPropertiesValue value = new MallProductPropertiesValue();
		value.setCreateDateTime(new Date());
		value.setImageUrl(mppv.getImageUrl());
		value.setInvalid(InvalidEnum.FALSE.getInvalidValue());
		value.setPropertiesId(properties.getId());
		value.setSort(valueSort);
		value.setIsDefault((byte) 1);
		value.setDisplay((byte) 1);
		value.setUpdateTime(new Date());
		value.setStatus((byte) 1);
		String propertyVale = mppv.getValue();
		if (propertyVale.contains("订制") || propertyVale.contains("定制")) {
			value.setIsCustomMade((byte) 1);
		} else {
			value.setIsCustomMade((byte) 0);
		}
		value.setValue(propertyVale);

		return value;
	}
	@SuppressWarnings("rawtypes")
	public List<String> descartes(String str) {
		String[] list = str.split("==");
		List<List> strs = new ArrayList<List>();
		for (int i = 0; i < list.length; i++) {
			strs.add(Arrays.asList(list[i].split(",")));
		}
		System.out.println(strs);
		int total = 1;
		for (int i = 0; i < strs.size(); i++) {
			total *= strs.get(i).size();
		}
		String[] mysesult = new String[total];
		int now = 1;
		// 每个元素每次循环打印个数
		int itemLoopNum = 1;
		// 每个元素循环的总次数
		int loopPerItem = 1;
		for (int i = 0; i < strs.size(); i++) {
			List temp = strs.get(i);
			now = now * temp.size();
			// 目标数组的索引值
			int index = 0;
			int currentSize = temp.size();
			itemLoopNum = total / now;
			loopPerItem = total / (itemLoopNum * currentSize);
			int myindex = 0;
			for (int j = 0; j < temp.size(); j++) {
				// 每个元素循环的总次数
				for (int k = 0; k < loopPerItem; k++) {
					if (myindex == temp.size())
						myindex = 0;
					// 每个元素每次循环打印个数
					for (int m = 0; m < itemLoopNum; m++) {
						mysesult[index] = (mysesult[index] == null ? "" : mysesult[index] + ",") + ((String) temp.get(myindex));
						index++;
					}
					myindex++;

				}
			}
		}
		return Arrays.asList(mysesult);
	}
	/**
	 * 保存商品型号及规格数据
	 * 
	 * @param result
	 * @param model
	 * @param category
	 * @param smartPropertiesValueId
	 */
	private void saveFormat(List<String> result, MallBasicCategoryModel model, MallBasicCategory category, long smartPropertiesValueId,
			long isCustomMadePropertiesValueId) {
		int i = 1;
		for (String ids : result) {
			String[] idArray = ids.split(",");
			MallBasicCategoryModelFormat format = new MallBasicCategoryModelFormat();
			format.setBasicCategoryModel(model);
			format.setCreateDateTime(new Date());
			format.setCategoryModelId(model.getId());
			format.setUpdateTime(new Date());
			format.setStatus((byte) 1);
			format.setCategoryId(model.getCategoryId());
			format.setCreatorId(model.getCreatorId());
			String code = this.getCode(i);
			format.setCode(code);
			format.setStock(0);
			format.setRealStock(0);
			format.setWarnCount(0);
			format.setName(category.getName() + model.getName());
			// 判断是否智能
			String smart = "0";
			boolean isCustomMade = false;
			for (String id : idArray) {
				if (StringUtils.isBlank(id))
					continue;
				if (Long.valueOf(id).longValue() == smartPropertiesValueId) {
					smart = "1";
				}
				if (Long.valueOf(id).longValue() == isCustomMadePropertiesValueId) {
					isCustomMade = true;
				}
			}
			if (isCustomMade) {
				format.setIsCustomMade((byte) 1);
			} else {
				format.setIsCustomMade((byte) 0);
			}
			format.setIsSmart(Byte.valueOf(smart));
			format.setCategoryModelFormatNumber(category.getCode() + model.getCode() + code + smart);
			format.setPropertyValueCombine(ids.replace(",", "-"));
			format.setcDisplay((byte)0);
			format.setbDisplay((byte)0);
			basicCategoryModelFormatDao.insert(format);
			// 保存产品规格属性关联表
			StringBuffer name = new StringBuffer();
			for (int y = 0; y < idArray.length; y++) {
				String id = idArray[y];
				if (StringUtils.isBlank(id))
					continue;
				MallFormatPropertiesValueRelation relation = new MallFormatPropertiesValueRelation();
				relation.setCreateDateTime(new Date());
				relation.setCategoryModelFormatId(format.getId());
				relation.setInvalid(InvalidEnum.FALSE.getInvalidValue());
				MallProductPropertiesValue propertiesValue = mallProductPropertiesValueDao.selectByPrimaryKey(Long.valueOf(id));
				name.append(propertiesValue.getValue() + " ");
				relation.setProductPropertiesId(propertiesValue.getPropertiesId());
				relation.setProductPropertiesValueId(Long.valueOf(id));
				relation.setStatus((byte) 1);
				relation.setUpdateTime(new Date());
				propertiesValueRelationDao.insert(relation);
			}
			format.setName(name.toString().trim());
			basicCategoryModelFormatDao.updateByPrimaryKeySelective(format);
			i++;
		}
	}
	private String getCode(int i) {

		String code = "";
		if (i < 10) {
			code = "000" + i;
		} else if (i < 99) {
			code = "00" + i;
		} else if (i < 999) {
			code = "0" + i;
		} else if (i < 9999) {
			code = String.valueOf(i);
		}

		return code;
	}
	@Override
	public int updateCategoryModelExt(
			MallBasicCategoryModelExt basicCategoryModelExt) {
		if (basicCategoryModelExt == null || basicCategoryModelExt.getId() == null) {
			return -1;
		}
		MallBasicCategoryModel model = basicCategoryModelDao.selectByPrimaryKey(basicCategoryModelExt.getId());
		model.setCreatorId(basicCategoryModelExt.getCreatorId());
		model.setInvalid(InvalidEnum.FALSE.getInvalidValue());
		model.setName(basicCategoryModelExt.getName());
		model.setStatus((byte) 1);
		model.setUpdateTime(new Date());
		model.setId(basicCategoryModelExt.getId());
		basicCategoryModelDao.updateByPrimaryKeySelective(model);
		int sort = 1;
		List<MallProductPropertiesExt> propertiesList = basicCategoryModelExt.getProperties();
		String ids = "";
		long smartPropertiesValueId = 0;// 智能属性值ID
		long isCustomMadePropertiesValueId = 0;// 是否私人订制
		for (MallProductPropertiesExt property : propertiesList) {
			MallProductProperties properties = new MallProductProperties();
			// 属性名称为空
			if (StringUtils.isBlank(property.getPropertyName())) {
				continue;
			}
			// 新增属性
			if (property.getId() == null) {
				properties = this.createMallProductProperties(property, model, sort);
				mallProductPropertiesDao.insert(properties);
			} else {// 更新属性名称
				properties.setInvalid(InvalidEnum.FALSE.getInvalidValue());
				properties.setPropertyName(property.getPropertyName());
				properties.setStatus((byte) 1);
				properties.setIsCustomMade((byte) 0);
				properties.setUpdateTime(new Date());
				properties.setId(property.getId());
				mallProductPropertiesDao.updateByPrimaryKeySelective(property);
			}
			int valueSort = 1;
			boolean flag = true;
			for (MallProductPropertiesValue mppv : property.getPropertiesValuees()) {
				MallProductPropertiesValue value = new MallProductPropertiesValue();
				if (StringUtils.isBlank(mppv.getValue()))
					continue;

				if (mppv.getId() == null) {
					value = this.createMallProductPropertiesValue(mppv, properties, valueSort);
					mallProductPropertiesValueDao.insert(value);
				} else {
					value.setImageUrl(mppv.getImageUrl());
					value.setInvalid(InvalidEnum.FALSE.getInvalidValue());
					value.setUpdateTime(new Date());
					value.setStatus((byte) 1);
					value.setValue(mppv.getValue());
					value.setId(mppv.getId());
					if (mppv.getValue().contains("订制") || mppv.getValue().contains("定制")) {
						value.setIsCustomMade((byte) 1);
					} else {
						value.setIsCustomMade((byte) 0);
					}
					mallProductPropertiesValueDao.updateByPrimaryKeySelective(value);
				}

				// 更新该属性类型 文字还是图文 、图片
				if (StringUtils.isNotBlank(mppv.getImageUrl()) && mppv.getImageUrl().trim().length() > 0) {
					if (flag) {
						MallProductProperties p = new MallProductProperties();
						p.setDisplayFormat((short) 2);// 图文显示
						p.setId(properties.getId());
						flag = false;
						mallProductPropertiesDao.updateByPrimaryKeySelective(p);
						p = null;
					}
				}
				if (value.getIsCustomMade().intValue() == 1) {
					MallProductProperties p = new MallProductProperties();
					p.setId(properties.getId());
					p.setIsCustomMade((byte) 1);
					isCustomMadePropertiesValueId = value.getId();
					mallProductPropertiesDao.updateByPrimaryKeySelective(p);
				}
				if (properties.getPropertyName().contains("智能")) {
					if (StringUtils.isNotBlank(mppv.getValue()) && mppv.getValue().trim().equals("智能")) {
						smartPropertiesValueId = value.getId();
					}

				}
				ids += value.getId().toString() + ",";
				valueSort++;
			}
			ids += "==";
			sort++;

		}
		// System.out.println("ids==="+ids);
		// System.out.println("smartPropertiesValueId==="+smartPropertiesValueId);
		List<String> result = this.descartes(ids);
		this.updateFormat(result, model, basicCategoryDao.selectByPrimaryKey(model.getCategoryId()), smartPropertiesValueId,
				isCustomMadePropertiesValueId);
		productDao.updateProductByModelId(model.getId(), basicCategoryModelExt.getName());
		return 0;
	}
	/**
	 * 保存商品型号及规格数据
	 * 
	 * @param result
	 * @param model
	 * @param category
	 * @param smartPropertiesValueId
	 */
	private void updateFormat(List<String> result, MallBasicCategoryModel model, MallBasicCategory category, long smartPropertiesValueId,
			long isCustomMadePropertiesValueId) {
		MallBasicCategoryModelFormat formatMaxCode = basicCategoryModelFormatDao.getBaxicCategoryModelFormatMaxCode(model.getId());
		int i = 1;
		if (formatMaxCode == null) {
			i = 1;
		} else {
			String code = formatMaxCode.getCode();
			if (StringUtils.isBlank(code))
				i = 1;
			i = Integer.valueOf(code).intValue() + 1;
		}
		for (String ids : result) {
			boolean isCustomMade = false;
			String[] idArray = ids.split(",");
			MallBasicCategoryModelFormat oldFormat = basicCategoryModelFormatDao.queryFormatByCombine(ids.replace(",", "-"));
			if (oldFormat != null && oldFormat.getId() != null) {
				for (String id : idArray) {
					if (StringUtils.isBlank(id))
						continue;
					if (Long.valueOf(id).longValue() == isCustomMadePropertiesValueId) {
						isCustomMade = true;
					}
				}
				if (isCustomMade) {
					oldFormat.setIsCustomMade((byte) 1);
				} else {
					oldFormat.setIsCustomMade((byte) 0);
				}
				oldFormat.setName(getFormatName(idArray).toString().trim());
				basicCategoryModelFormatDao.updateByPrimaryKeySelective(oldFormat);
				continue;
			}
			MallBasicCategoryModelFormat format = new MallBasicCategoryModelFormat();
			format.setBasicCategoryModel(model);
			format.setCreateDateTime(new Date());
			format.setCategoryModelId(model.getId());
			format.setUpdateTime(new Date());
			format.setStatus((byte) 1);
			format.setCategoryId(model.getCategoryId());
			format.setCreatorId(model.getCreatorId());
			String code = this.getCode(i);
			format.setCode(code);
			format.setStock(0);
			format.setRealStock(0);
			format.setWarnCount(0);
			format.setName(category.getName() + model.getName());
			// 判断是否智能
			String smart = "0";
			for (String id : idArray) {
				if (StringUtils.isBlank(id))
					continue;
				if (Long.valueOf(id).longValue() == smartPropertiesValueId) {
					smart = "1";
				}
				if (Long.valueOf(id).longValue() == isCustomMadePropertiesValueId) {
					isCustomMade = true;
				}
			}
			format.setIsSmart(Byte.parseByte(smart));
			if (isCustomMade) {
				format.setIsCustomMade((byte) 1);
			} else {
				format.setIsCustomMade((byte) 0);
			}
			format.setCategoryModelFormatNumber(category.getCode() + model.getCode() + code + smart);
			format.setPropertyValueCombine(ids.replace(",", "-"));
			format.setcDisplay((byte)0);
			format.setbDisplay((byte)0);
			basicCategoryModelFormatDao.insertSelective(format);
			// 保存产品规格属性关联表
			StringBuffer name = new StringBuffer();
			for (int y = 0; y < idArray.length; y++) {
				String id = idArray[y];
				if (StringUtils.isBlank(id))
					continue;
				MallFormatPropertiesValueRelation relation = new MallFormatPropertiesValueRelation();
				relation.setCreateDateTime(new Date());
				relation.setCategoryModelFormatId(format.getId());
				relation.setInvalid(InvalidEnum.FALSE.getInvalidValue());
				MallProductPropertiesValue propertiesValue = mallProductPropertiesValueDao.selectByPrimaryKey(Long.valueOf(id));
				name.append(propertiesValue.getValue() + " ");
				relation.setProductPropertiesId(propertiesValue.getPropertiesId());
				relation.setProductPropertiesValueId(Long.valueOf(id));
				relation.setStatus((byte) 1);
				relation.setUpdateTime(new Date());
				propertiesValueRelationDao.insert(relation);
			}
			format.setName(name.toString().trim());
			basicCategoryModelFormatDao.updateByPrimaryKeySelective(format);
			i++;
		}
	}
	private String getFormatName(String[] ids){
		StringBuffer name = new StringBuffer();
		for (int y = 0; y < ids.length; y++) {
			String id = ids[y];
			if (StringUtils.isBlank(id))
				continue;
			MallProductPropertiesValue propertiesValue = mallProductPropertiesValueDao.selectByPrimaryKey(Long.valueOf(id));
			name.append(propertiesValue.getValue() + " ");
		}
		return name.toString();
	}
	@Override
	public int removeCategoryModelExt(
			MallBasicCategoryModelExt basicCategoryModelExt) {
		return 0;
	}
	@Override
	public void updateStockById(Long id, Integer stock) {
		basicCategoryModelFormatDao.updateStockById(id, stock);
	}
	@Override
	public void updateCategoryModelFormat(MallBasicCategoryModelFormat format) {
		basicCategoryModelFormatDao.updateByPrimaryKeySelective(format);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.CategoryCUDService#updateFormatPriceAndDic(java.lang.Long, float, float)
	 */
	@Override
	public int updateFormatPriceAndDic(Long formatId, float price, float discountPrice) {
		if(price<=0&&discountPrice<=0){
			return 0;
		}
		return basicCategoryModelFormatDao.updateFormatPriceAndDic(formatId, price, discountPrice);
	}

	/* (non-Javadoc)
	 * @see com.papabear.product.api.CategoryCUDService#saveFormatId(java.lang.Long, java.lang.String, java.lang.String, byte)
	 */
	@Override
	public int saveOrUpdateFormatId(MallFormatExt formatExt) {
		Assert.notNull(formatExt);
		if(formatExt.getId()==null){
			formatExt.setCreateDateTime(new Date());
			return formatExtDao.insert(formatExt);
		}else{
			return formatExtDao.updateByPrimaryKeySelective(formatExt);
		}
	}
}
