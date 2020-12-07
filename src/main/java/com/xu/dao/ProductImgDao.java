package com.xu.dao;

import com.xu.entity.ProductImg;

import java.util.List;

/**
 * @Description: 商品图片数据接口
 *
 */

public interface ProductImgDao {

	/**
	 * 批量插入商品图片
	 * 
	 * @param productImgList 商品图片列表
	 * @return
	 */

	int batchInsertProductImg(List<ProductImg> productImgList);

	/**
	 * 根据商品Id删除商品详情图
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(Long productId);

	/**
	 * 根据商品Id获取商品详情图列表
	 * 
	 * @param productId
	 * @return
	 */
	List<ProductImg> selectProductImgListByProductId(long productId);
}
