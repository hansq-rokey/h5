package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;


public class ProductDetail extends AbstractEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2098015498259845678L;

	private Long productId;

    private String detail;

    private MallProduct product;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}