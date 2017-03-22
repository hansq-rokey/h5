package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

public class MallProductPic extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4537982488422670763L;

	private Long productId;

    private Long productModelFormatId;

    private String url;

    private Integer sort;

    private Byte type;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductModelFormatId() {
        return productModelFormatId;
    }

    public void setProductModelFormatId(Long productModelFormatId) {
        this.productModelFormatId = productModelFormatId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}