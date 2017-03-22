package com.papabear.product.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.papabear.commons.entity.AbstractEntity;

public class MallBasicCategoryModelFormat extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5801468294863171868L;

	private String name;

	private String code;

	private Integer walt;

	private Byte isSmart;

	private String categoryModelFormatNumber;

	private Long categoryId;

	private Long categoryModelId;

	private Float price;

	private Float discountPrice;

	private Integer stock;

	private Long creatorId;
	
    private Integer length;

    private Integer width;
    
    private Float level0Price;

    private Float level1Price;

    private Float level2Price;

    private Float level3Price;
    
    private String unit;

    private String explain;

    private Byte isExtProperties;
    //每个规格具利润，40%，填写40
    private Float formatTotalProfit;
    
  //是否私人定制
    private Byte isCustomMade;
	
	private String propertyValueCombine;

	private MallBasicCategoryModel basicCategoryModel;
	// 用于图片上传用
	private MultipartFile file;
	//关联查询
	private List<MallProductPic> pics;
	
	private List<MallProductPropertiesValue> propertiesValues;
	
	private Integer warnCount;
	
	private Integer realStock;
	
	private Float crmMoney;//代理商等相关设置价格的临时字段
	
	private Long priceId;//设置代理商价格ID
	
	private Float productPurchasePrice;
	
	private Float areaMoney;
	
	private Byte cDisplay;
	
	private Byte bDisplay;
	
	//运费模板ID
    private Long freightTemplateId;
    //模板名称，显示用
    private String templateName;
	
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

	public Float getProductPurchasePrice() {
		return productPurchasePrice;
	}

	public void setProductPurchasePrice(Float productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}

	public Float getAreaMoney() {
		return areaMoney;
	}

	public void setAreaMoney(Float areaMoney) {
		this.areaMoney = areaMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Float getCrmMoney() {
		return crmMoney;
	}

	public void setCrmMoney(Float crmMoney) {
		this.crmMoney = crmMoney;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Integer getWalt() {
		return walt;
	}

	public void setWalt(Integer walt) {
		this.walt = walt;
	}

	public Byte getIsSmart() {
		return isSmart;
	}

	public void setIsSmart(Byte isSmart) {
		this.isSmart = isSmart;
	}

	public String getCategoryModelFormatNumber() {
		return categoryModelFormatNumber;
	}

	public void setCategoryModelFormatNumber(String categoryModelFormatNumber) {
		this.categoryModelFormatNumber = categoryModelFormatNumber == null ? null
				: categoryModelFormatNumber.trim();
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

	public Float getPrice() {
		return price;
	}

	public Integer getWarnCount() {
		return warnCount;
	}

	public void setWarnCount(Integer warnCount) {
		this.warnCount = warnCount;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public MallBasicCategoryModel getBasicCategoryModel() {
		return basicCategoryModel;
	}

	public void setBasicCategoryModel(MallBasicCategoryModel basicCategoryModel) {
		this.basicCategoryModel = basicCategoryModel;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	public MallBasicCategoryModelFormat() {
		super();
	}

	public MallBasicCategoryModelFormat(String name, String code, Integer walt,
			Byte isSmart, String categoryModelFormatNumber, Long categoryId,
			Long categoryModelId, Float price, Float discountPrice,
			Integer stock, Long creatorId,
			MallBasicCategoryModel basicCategoryModel, MultipartFile file) {
		super();
		this.name = name;
		this.code = code;
		this.walt = walt;
		this.isSmart = isSmart;
		this.categoryModelFormatNumber = categoryModelFormatNumber;
		this.categoryId = categoryId;
		this.categoryModelId = categoryModelId;
		this.price = price;
		this.discountPrice = discountPrice;
		this.stock = stock;
		this.creatorId = creatorId;
		this.basicCategoryModel = basicCategoryModel;
		this.file = file;
	}

	public List<MallProductPic> getPics() {
		return pics;
	}

	public void setPics(List<MallProductPic> pics) {
		this.pics = pics;
	}

	public String getPropertyValueCombine() {
		return propertyValueCombine;
	}

	public void setPropertyValueCombine(String propertyValueCombine) {
		this.propertyValueCombine = propertyValueCombine;
	}

	public List<MallProductPropertiesValue> getPropertiesValues() {
		return propertiesValues;
	}

	public void setPropertiesValues(
			List<MallProductPropertiesValue> propertiesValues) {
		this.propertiesValues = propertiesValues;
	}

	public Integer getRealStock() {
		return realStock;
	}

	public void setRealStock(Integer realStock) {
		this.realStock = realStock;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Byte getIsCustomMade() {
		return isCustomMade;
	}

	public void setIsCustomMade(Byte isCustomMade) {
		this.isCustomMade = isCustomMade;
	}

	public Float getLevel0Price() {
		return level0Price;
	}

	public void setLevel0Price(Float level0Price) {
		this.level0Price = level0Price;
	}

	public Float getLevel1Price() {
		return level1Price;
	}

	public void setLevel1Price(Float level1Price) {
		this.level1Price = level1Price;
	}

	public Float getLevel2Price() {
		return level2Price;
	}

	public void setLevel2Price(Float level2Price) {
		this.level2Price = level2Price;
	}

	public Float getLevel3Price() {
		return level3Price;
	}

	public void setLevel3Price(Float level3Price) {
		this.level3Price = level3Price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public Byte getIsExtProperties() {
		return isExtProperties;
	}

	public void setIsExtProperties(Byte isExtProperties) {
		this.isExtProperties = isExtProperties;
	}

	public Float getFormatTotalProfit() {
		return formatTotalProfit;
	}

	public void setFormatTotalProfit(Float formatTotalProfit) {
		this.formatTotalProfit = formatTotalProfit;
	}
	
}