package com.xu.dao;

import com.xu.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mashenglin
 */
public interface ShopDao {
    /**
     * 分页查询数据，可输入的条件是：店铺名(模糊)，店铺状态，店铺类型，区域ID，owner
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,@Param("rowIndex")int rowIndex,@Param("pageSize")int pageSize);
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
