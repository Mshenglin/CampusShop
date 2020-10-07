package com.xu.dao;

import com.xu.entity.Shop;

/**
 * @author mashenglin
 */
public interface ShopDao {
    /**
     * 新增商铺
     * @param shop
     * @return 状态值
     */
    int insertShop(Shop shop);
}
