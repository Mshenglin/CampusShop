package com.xu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 */
public class Product implements Serializable{
	
	/**
	 * 商品
	 */
	private static final long serialVersionUID = -349433539553804024L;
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品描述
	 */
	private String productDesc;
	/**
	 * 简略图
	 */
	private String imgAddr;
	/**
	 * 商品原价
	 */
	private String normalPrice;
	/**
	 * 商品折扣价
	 */
	private String promotionPrice;
	/**
	 * 商品权重
	 */
	private Integer priority;
	/**
	 * 商品创建时间
	 */
	private Date createTime;
	/**
	 * 商品修改时间
	 */
	private Date lastEditTime;
	/**
	 * 商品状态-1不可用0下架1在前台展示
	 */
	private Integer enableStatus;
	/**
	 * 商品
	 */
	private Integer point;
	/**
	 * 商品详情图片列表
	 */
	private List<ProductImg> productImgList;
	/**
	 * 商品分类
	 */
	private ProductCategory productCategory;
	/**
	 * 商品所在的店铺
	 */
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
