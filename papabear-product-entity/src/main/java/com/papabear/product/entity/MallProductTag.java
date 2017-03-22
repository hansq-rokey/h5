package com.papabear.product.entity;

import java.util.Date;

import com.papabear.commons.entity.AbstractEntity;

public class MallProductTag extends AbstractEntity{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1054857153216733669L;

    private Long productId;

    private Date updateDateTime;

    private Long tagId;

    public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}