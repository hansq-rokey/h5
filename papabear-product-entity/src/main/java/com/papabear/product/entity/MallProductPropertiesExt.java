package com.papabear.product.entity;

import java.util.List;

public class MallProductPropertiesExt extends MallProductProperties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4962625436051159314L;
	List<MallProductPropertiesValue> propertiesValuees;

	public List<MallProductPropertiesValue> getPropertiesValuees() {
		return propertiesValuees;
	}

	public void setPropertiesValuees(
			List<MallProductPropertiesValue> propertiesValuees) {
		this.propertiesValuees = propertiesValuees;
	}
	
	
}
