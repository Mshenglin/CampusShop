package com.xu.dao;

import com.xu.entity.Shop;

/**
 * @author mashenglin
 */
public interface ShopDao {
    /**
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * 新增商铺
     * @param shop
     * @return 状态值
     */
    int insertShop(Shop shop);

    /**
     * 更新商铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
