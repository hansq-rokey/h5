package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

public class ProductCommentTagLib extends AbstractEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7479380804197493588L;

    private Long adminId;

    private Long productId;

    private Long formatId;

    private String tagName;

    private String description;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}