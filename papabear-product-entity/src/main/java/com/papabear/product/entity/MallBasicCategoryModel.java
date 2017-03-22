package com.papabear.product.entity;

import java.util.List;

import com.papabear.commons.entity.AbstractEntity;


public class MallBasicCategoryModel extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6306841387093089399L;

	private String name;

    private String code;

    private Long categoryId;

    private Long creatorId;
    
    private MallBasicCategory category;
    
    //form表单提交
    private List<MallBasicCategoryModelFormat> formats;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

	public MallBasicCategory getCategory() {
		return category;
	}

	public void setCategory(MallBasicCategory category) {
		this.category = category;
	}

	public List<MallBasicCategoryModelFormat> getFormats() {
		return formats;
	}

	public void setFormats(List<MallBasicCategoryModelFormat> formats) {
		this.formats = formats;
	}
	
	
    
    
}