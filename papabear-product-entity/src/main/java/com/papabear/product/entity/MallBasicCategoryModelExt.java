package com.papabear.product.entity;

import java.util.List;

/**
 * MallBasicCategoryModel 扩展类
 * @author yaoweiguo
 * @Email  yaoweiguo@ibaixiong.com
 * @Description TODO
 * @date 2015年10月22日
 *
 */
public class MallBasicCategoryModelExt extends MallBasicCategoryModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772282742128365465L;
	List<MallProductPropertiesExt> properties;

	public List<MallProductPropertiesExt> getProperties() {
		return properties;
	}

	public void setProperties(List<MallProductPropertiesExt> properties) {
		this.properties = properties;
	}
	
	
	
	
	

}
