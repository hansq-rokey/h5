package com.papabear.product.entity;

import java.util.Date;

import com.papabear.commons.entity.AbstractEntity;

public class MallFormatExt extends AbstractEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5632639913031949893L;


    private Long categoryModelFormatId;

    private String propertyName;

    private Date createDateTime;

    private String identify;

    private Byte type;
    //扩展用，属性值
    private float value;

    private String unit;
    
    private Byte status;
    
    public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getCategoryModelFormatId() {
        return categoryModelFormatId;
    }

    public void setCategoryModelFormatId(Long categoryModelFormatId) {
        this.categoryModelFormatId = categoryModelFormatId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName == null ? null : propertyName.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}