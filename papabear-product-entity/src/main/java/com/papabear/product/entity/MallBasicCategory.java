package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;


public class MallBasicCategory extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3121771969717545737L;

	private String name;

    private String code;


    private Long creatorId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}