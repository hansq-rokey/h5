package com.papabear.product.entity;

import com.papabear.commons.entity.AbstractEntity;

/**
 * 产品类型
 * baixiong.com Inc.
 * Copyright (c) 1999-2001 All Rights Reserved.
 * 
 * @author yaoweiguo
 * @Email  yaoweiguo@ibaixiong.com
 * @Description TODO
 * @date 2015年8月13日
 *
 */
public class ProductType extends AbstractEntity{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 6291965031877562937L;

	//软编码前4位
    private String bxid4;

    //名称
    private String name;

    //产品型号
    private String publicVersion;

    //
    private String logoImg;

    private String resetImg;

    private String readyYesImg;

    private String readyNoImg;

    private String description;

    private Byte isSmart;

    private String wifiName;

    private String wifiPassword;

    private String wifiHost;

    private Integer wifiPort;


    

    public String getBxid4() {
        return bxid4;
    }

    public void setBxid4(String bxid4) {
        this.bxid4 = bxid4 == null ? null : bxid4.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPublicVersion() {
        return publicVersion;
    }

    public void setPublicVersion(String publicVersion) {
        this.publicVersion = publicVersion == null ? null : publicVersion.trim();
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg == null ? null : logoImg.trim();
    }

    public String getResetImg() {
        return resetImg;
    }

    public void setResetImg(String resetImg) {
        this.resetImg = resetImg == null ? null : resetImg.trim();
    }

    public String getReadyYesImg() {
        return readyYesImg;
    }

    public void setReadyYesImg(String readyYesImg) {
        this.readyYesImg = readyYesImg == null ? null : readyYesImg.trim();
    }

    public String getReadyNoImg() {
        return readyNoImg;
    }

    public void setReadyNoImg(String readyNoImg) {
        this.readyNoImg = readyNoImg == null ? null : readyNoImg.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Byte getIsSmart() {
        return isSmart;
    }

    public void setIsSmart(Byte isSmart) {
        this.isSmart = isSmart;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName == null ? null : wifiName.trim();
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword == null ? null : wifiPassword.trim();
    }

    public String getWifiHost() {
        return wifiHost;
    }

    public void setWifiHost(String wifiHost) {
        this.wifiHost = wifiHost == null ? null : wifiHost.trim();
    }

    public Integer getWifiPort() {
        return wifiPort;
    }

    public void setWifiPort(Integer wifiPort) {
        this.wifiPort = wifiPort;
    }
}