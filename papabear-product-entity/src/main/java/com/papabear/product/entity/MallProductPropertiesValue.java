package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;


public class MallProductPropertiesValue extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2414679513290126594L;


	private Long propertiesId;


    private String value;

    private Long materialId;

    private Float price;

    private String imageUrl;

    private Byte isDefault;

    private Byte isCustomMade;

    private Byte display;

    private Integer sort;
    
    private String explain;

    public Long getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(Long propertiesId) {
        this.propertiesId = propertiesId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Byte getIsCustomMade() {
        return isCustomMade;
    }

    public void setIsCustomMade(Byte isCustomMade) {
        this.isCustomMade = isCustomMade;
    }

    public Byte getDisplay() {
        return display;
    }

    public void setDisplay(Byte display) {
        this.display = display;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
    
    
}