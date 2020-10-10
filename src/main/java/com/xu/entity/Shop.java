package com.xu.entity;

import java.util.Date;
import java.util.List;

/**
 * 店铺
 */
public class Shop {
	/**
	 * 店铺id
	 */
	private Long shopId;
	/**
	 * 店主id
	 */
	private Long ownerId;
	/**
	 * 区域id
	 */
	private Long shopCategoryId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 区域
	 */
	private String shopDesc;
	/**
	 * 店铺地址
	 */
	private String shopAddr;
	/**
	 * 店铺联系方式
	 */
	private String phone;
	/**
	 * 店铺照片
	 */
	private String shopImg;
	/**
	 * 区域
	 */
	private Double longitude;
	/**
	 * 区域
	 */
	private Double latitude;
	/**
	 * 店铺权重
	 */
	private Integer priority;
	/**
	 * 店铺创建时间
	 */
	private Date createTime;
	/**
	 * 店铺修改时间
	 */
	private Date lastEditTime;
	/**
	 * 店铺状态 -1不可用 0审核 1可用
	 */
	private Integer enableStatus;
	/**
	 * 超级管理员给店家的提示
	 */
	private String advice;
	/**
	 * 区域
	 */
	private Area area;
	/**
	 * 店铺创建人
	 */
	private PersonInfo owner;
	/**
	 * 类别
	 */
	private ShopCategory shopCategory;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getShopCategoryId() {
		return shopCategoryId;
	}

	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
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


	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public PersonInfo getOwner() {
		return owner;
	}

	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}
}
