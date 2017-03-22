package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;


public class MallFormatPropertiesValueRelation extends AbstractEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5901903674256682801L;

	private Long productPropertiesId;

    private Long productPropertiesValueId;

    private Long categoryModelFormatId;

    public Long getProductPropertiesId() {
        return productPropertiesId;
    }

    public void setProductPropertiesId(Long productPropertiesId) {
        this.productPropertiesId = productPropertiesId;
    }

    public Long getProductPropertiesValueId() {
        return productPropertiesValueId;
    }

    public void setProductPropertiesValueId(Long productPropertiesValueId) {
        this.productPropertiesValueId = productPropertiesValueId;
    }

    public Long getCategoryModelFormatId() {
        return categoryModelFormatId;
    }

    public void setCategoryModelFormatId(Long categoryModelFormatId) {
        this.categoryModelFormatId = categoryModelFormatId;
    }
}