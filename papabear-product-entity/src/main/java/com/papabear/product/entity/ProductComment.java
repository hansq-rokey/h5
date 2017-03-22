package com.papabear.product.entity;

import java.util.List;

import com.papabear.commons.entity.AbstractEntity;

public class ProductComment extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -2214252368878367535L;

	private Long userId;

    private Long productId;

    private Long formatId;

    private String commmentTagIds;

    private String description;

    private Byte originType;

    private Byte isDisplay;

    private String nick;
    //用户头像
    private String avatarImg;
    
    private List<ProductCommentPic> picLists;
    //评论标签集合
    private List<ProductCommentTagLib> tagLibs;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getCommmentTagIds() {
        return commmentTagIds;
    }

    public void setCommmentTagIds(String commmentTagIds) {
        this.commmentTagIds = commmentTagIds == null ? null : commmentTagIds.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getOriginType() {
        return originType;
    }

    public void setOriginType(Byte originType) {
        this.originType = originType;
    }

    public Byte getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Byte isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

	public String getAvatarImg() {
		return avatarImg;
	}

	public void setAvatarImg(String avatarImg) {
		this.avatarImg = avatarImg;
	}

	public List<ProductCommentPic> getPicLists() {
		return picLists;
	}

	public void setPicLists(List<ProductCommentPic> picLists) {
		this.picLists = picLists;
	}

	public List<ProductCommentTagLib> getTagLibs() {
		return tagLibs;
	}

	public void setTagLibs(List<ProductCommentTagLib> tagLibs) {
		this.tagLibs = tagLibs;
	}
	
}