package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

public class MallProductDetail extends AbstractEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1415584107533258020L;

	private Long productId;

    private String detail;
    
    private String appProductDetail;
    
    private String appParamterDetail;

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

	public String getAppProductDetail() {
		return appProductDetail;
	}

	public void setAppProductDetail(String appProductDetail) {
		this.appProductDetail = appProductDetail;
	}

	public String getAppParamterDetail() {
		return appParamterDetail;
	}

	public void setAppParamterDetail(String appParamterDetail) {
		this.appParamterDetail = appParamterDetail;
	}
    
    
}