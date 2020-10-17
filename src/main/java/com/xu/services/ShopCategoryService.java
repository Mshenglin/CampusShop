package com.xu.services;

import com.xu.entity.ShopCategory;

import java.util.List;

/**
 * @author ma
 */
public interface ShopCategoryService {
    /**
     * 商品分类Service接口
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
