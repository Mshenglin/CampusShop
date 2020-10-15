package com.xu.dao;

import com.xu.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品区域列表
 *
 * @author ma
 */
public interface ShopCategoryDao {
    /**
     * 查询
     *
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
