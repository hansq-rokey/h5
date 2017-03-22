package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

public class MallProductTagData extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4242185209644564238L;
	private String tagName;
	//扩展属性，用于显示条件判断
	private Byte type;
	

    public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
}