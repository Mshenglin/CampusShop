package com.xu.entity;

import java.util.Date;

/**
 * @author 马生林
 */
public class ShopCategory {
	/**
	 *店铺类别id
	 */
	private Long shopCategoryId;
	/**
	 *店铺类别名字
	 */
	private String shopCategoryName;
	/**
	 *店铺类别描述
	 */
	private String shopCategoryDesc;
	/**
	 *店铺类别图片
	 */
	private String shopCategoryImg;
	/**
	 *店铺类别权重
	 */
	private Integer priority;
	/**
	 *店铺类别创建时间
	 */
	private Date createTime;
	/**
	 *店铺类别修改时间
	 */
	private Date lastEditTime;
	/**
	 *店铺类别上一级id
	 */
	private Long parentId;

	public Long getShopCategoryId() {
		return shopCategoryId;
	}

	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}

	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}

	public String getShopCategoryImg() {
		return shopCategoryImg;
	}

	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
