package com.papabear.product.entity;

import java.util.List;

import com.papabear.commons.entity.AbstractEntity;


public class MallProductProperties extends AbstractEntity{
   

    /**
	 * 
	 */
	private static final long serialVersionUID = 7993770590436390301L;

	private Long categoryModelId;

    private String propertyName;

    private Byte isTrace;

    private Byte isCustomMade;

    private Integer sort;
    /*1、文字 2、图文、3   图片*/
    private Short displayFormat;
    
    private List<MallProductPropertiesValue> propertiesValues;

    public Long getCategoryModelId() {
        return categoryModelId;
    }

    public void setCategoryModelId(Long categoryModelId) {
        this.categoryModelId = categoryModelId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public Byte getIsTrace() {
        return isTrace;
    }

    public void setIsTrace(Byte isTrace) {
        this.isTrace = isTrace;
    }

    public Byte getIsCustomMade() {
        return isCustomMade;
    }

    public void setIsCustomMade(Byte isCustomMade) {
        this.isCustomMade = isCustomMade;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public List<MallProductPropertiesValue> getPropertiesValues() {
		return propertiesValues;
	}

	public void setPropertiesValues(
			List<MallProductPropertiesValue> propertiesValues) {
		this.propertiesValues = propertiesValues;
	}

	public Short getDisplayFormat() {
		return displayFormat;
	}

	public void setDisplayFormat(Short displayFormat) {
		this.displayFormat = displayFormat;
	}
	
    
}