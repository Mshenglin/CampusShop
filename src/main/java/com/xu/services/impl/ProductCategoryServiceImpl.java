package com.xu.services.impl;



import com.xu.dao.ProductCategoryDao;
import com.xu.dao.ProductDao;
import com.xu.exceptions.ProductCategoryExecution;
import com.xu.entity.ProductCategory;
import com.xu.enums.OperationStatusEnum;
import com.xu.enums.ProductCategoryStateEnum;
import com.xu.exceptions.ProductCategoryOperationException;
import com.xu.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 店铺的商品类别业务接口实现
 *
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private ProductDao productDao;

	public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao, ProductDao productDao) {
		this.productCategoryDao = productCategoryDao;
		this.productDao = productDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ProductCategoryService#getProductCategoryList(java.lang
	 * .Long)
	 */
	@Override
	public List<ProductCategory> getProductCategoryList(Long shopId) {
		return productCategoryDao.selectProductCategoryList(shopId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ProductCategoryService#batchAddProductCategory(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		// 列表不为空
		if (productCategoryList != null && !productCategoryList.isEmpty()) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("");
				} else {
					return new ProductCategoryExecution(OperationStatusEnum.SUCCESS, productCategoryList, effectedNum);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException(
						ProductCategoryStateEnum.EDIT_ERROR.getStateInfo() + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPETY_LIST);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tyron.o2o.service.ProductCategoryService#deleteProductCategory(long,
	 * long)
	 */
	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		// 删除商品类别时将商品记录中的类别项置空
		try {
			int effectNum = productDao.updateProductCategoryToNull(productCategoryId);
			if (effectNum < 0) {
				throw new ProductCategoryOperationException(ProductCategoryStateEnum.EDIT_ERROR.getStateInfo());
			}
		} catch (ProductCategoryOperationException e) {
			throw new ProductCategoryOperationException("deleteProductCategory error" + e.getMessage());
		}

		// 删除商品类别
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException(ProductCategoryStateEnum.DELETE_ERROR.getStateInfo());
			} else {
				return new ProductCategoryExecution(OperationStatusEnum.SUCCESS, null, effectedNum);
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error" + e.getMessage());
		}
	}

}
