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
	private String piImgAddr;
	/**
	 *详情图片描述
	 */
	private String piImgDesc;
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

	public String getPiImgAddr() {
		return piImgAddr;
	}

	public void setPiImgAddr(String piImgAddr) {
		this.piImgAddr = piImgAddr;
	}

	public String getPiImgDesc() {
		return piImgDesc;
	}

	public void setPiImgDesc(String piImgDesc) {
		this.piImgDesc = piImgDesc;
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
