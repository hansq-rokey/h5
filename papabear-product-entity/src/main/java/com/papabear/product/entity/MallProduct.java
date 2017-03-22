package com.papabear.product.entity;

import java.util.List;

import com.papabear.commons.entity.AbstractEntity;


public class MallProduct extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 617790862662447366L;
	//产品标题
    private String title;
    //特点
    private String feature;
    //详细路径地址
    private String detailUrl;
    //详细APP地址
    private String detailUrlApp;
    //安装费
    private Float installationCost;
    //是否优惠活动
    private boolean IsSpecialOffers;
    //是否分销产品
    private Byte isDistribution;
    //是否公司产品
    private Byte isCompanyProduct;
    //总利润   ，利润  40% ，填写40
    private Float totalProfit;
    //是否使用定金支付
    private Byte isUseDeposit;
    //定金金额
    private Float depositMoney;
    //是否在下单过程中显示物料信息
    private Byte isDisplayMateriel;
    
    private Long categoryId;
    
    private Long categoryModelId;
    //产品大类
    private MallBasicCategory basicCategory;
    //产品大类code
    private String categoryCode;
    //产品型号ID    
    private MallBasicCategoryModel basicCategoryModel;
    //产品型号CODE
    private String categoryModelCode;
    //创建者
    private Long creatorId;
    //表单提交用，与数据库无关联
    private List<MallBasicCategoryModelFormat> formstList;
    //产品进货价格
    private Float productPurchasePrice;
    //是否设置区域利润
    private Byte isSetAreaProfit;
    //跨区域获取金额
    private Float areaMoney;
    //C端可见（1-可见  0-不可见）
    private Byte cDisplay;
    //B端可见（1-可见  0-不可见）
    private Byte bDisplay;
    //是否物料计算  0 否 1 是
    private Byte isMaterialCalculate;
    //运费模板ID
    private Long freightTemplateId;
    //运费模板名称，显示用
    private String templateName;
    //是否允许使用优惠券，0：不允许 1：允许
    private Byte specialType;
    
    public Byte getSpecialType() {
		return specialType;
	}

	public void setSpecialType(Byte specialType) {
		this.specialType = specialType;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Long getFreightTemplateId() {
		return freightTemplateId;
	}

	public void setFreightTemplateId(Long freightTemplateId) {
		this.freightTemplateId = freightTemplateId;
	}

	public Float getProductPurchasePrice() {
		return productPurchasePrice;
	}

	public void setProductPurchasePrice(Float productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}

	public Byte getIsSetAreaProfit() {
		return isSetAreaProfit;
	}

	public void setIsSetAreaProfit(Byte isSetAreaProfit) {
		this.isSetAreaProfit = isSetAreaProfit;
	}

	public Float getAreaMoney() {
		return areaMoney;
	}

	public void setAreaMoney(Float areaMoney) {
		this.areaMoney = areaMoney;
	}

	public Byte getcDisplay() {
		return cDisplay;
	}

	public void setcDisplay(Byte cDisplay) {
		this.cDisplay = cDisplay;
	}

	public Byte getbDisplay() {
		return bDisplay;
	}

	public void setbDisplay(Byte bDisplay) {
		this.bDisplay = bDisplay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }

    public String getDetailUrlApp() {
        return detailUrlApp;
    }

    public void setDetailUrlApp(String detailUrlApp) {
        this.detailUrlApp = detailUrlApp == null ? null : detailUrlApp.trim();
    }

    public Float getInstallationCost() {
		return installationCost;
	}

	public void setInstallationCost(Float installationCost) {
		this.installationCost = installationCost;
	}

	public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCategoryModelCode() {
        return categoryModelCode;
    }

    public void setCategoryModelCode(String categoryModelCode) {
        this.categoryModelCode = categoryModelCode == null ? null : categoryModelCode.trim();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

	public MallBasicCategory getBasicCategory() {
		return basicCategory;
	}

	public void setBasicCategory(MallBasicCategory basicCategory) {
		this.basicCategory = basicCategory;
	}

	public MallBasicCategoryModel getBasicCategoryModel() {
		return basicCategoryModel;
	}

	public void setBasicCategoryModel(MallBasicCategoryModel basicCategoryModel) {
		this.basicCategoryModel = basicCategoryModel;
	}

	public boolean isIsSpecialOffers() {
		return IsSpecialOffers;
	}

	public void setIsSpecialOffers(boolean isSpecialOffers) {
		IsSpecialOffers = isSpecialOffers;
	}

	public List<MallBasicCategoryModelFormat> getFormstList() {
		return formstList;
	}

	public void setFormstList(List<MallBasicCategoryModelFormat> formstList) {
		this.formstList = formstList;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryModelId() {
		return categoryModelId;
	}

	public void setCategoryModelId(Long categoryModelId) {
		this.categoryModelId = categoryModelId;
	}

	public Byte getIsDistribution() {
		return isDistribution;
	}

	public void setIsDistribution(Byte isDistribution) {
		this.isDistribution = isDistribution;
	}

	public Byte getIsCompanyProduct() {
		return isCompanyProduct;
	}

	public void setIsCompanyProduct(Byte isCompanyProduct) {
		this.isCompanyProduct = isCompanyProduct;
	}

	public Float getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Float totalProfit) {
		this.totalProfit = totalProfit;
	}

	public Byte getIsUseDeposit() {
		return isUseDeposit;
	}

	public void setIsUseDeposit(Byte isUseDeposit) {
		this.isUseDeposit = isUseDeposit;
	}

	public Float getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(Float depositMoney) {
		this.depositMoney = depositMoney;
	}

	public Byte getIsDisplayMateriel() {
		return isDisplayMateriel;
	}

	public void setIsDisplayMateriel(Byte isDisplayMateriel) {
		this.isDisplayMateriel = isDisplayMateriel;
	}

	public Byte getIsMaterialCalculate() {
		return isMaterialCalculate;
	}

	public void setIsMaterialCalculate(Byte isMaterialCalculate) {
		this.isMaterialCalculate = isMaterialCalculate;
	}
	
}