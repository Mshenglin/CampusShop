package com.xu.entity;

import java.util.Date;

/**
 * @author
 * 详情图片
 *
 */
public class ProductImg {
	/**
	 *详情图片id
	 */
	private Long productImgId;
	/**
	 *详情图片地址
	 */
	private String imgAddr;
	/**
	 *详情图片描述
	 */
	private String imgDesc;
	/**
	 *详情图片显示权重
	 */
	private Integer priority;
	/**
	 *详情图片创建时间
	 */
	private Date createTime;
	/**
	 *详情图片用于那个商品展示
	 */
	private Long productId;

	public Long getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(Long productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
