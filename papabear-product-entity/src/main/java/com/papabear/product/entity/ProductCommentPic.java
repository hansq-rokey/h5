package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

public class ProductCommentPic extends AbstractEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7665241813739721282L;

	private Long userId;

    private Long commentId;

    private String url;

    private String physicsAddress;

    private String picName;

    private Integer sort;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPhysicsAddress() {
        return physicsAddress;
    }

    public void setPhysicsAddress(String physicsAddress) {
        this.physicsAddress = physicsAddress == null ? null : physicsAddress.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}