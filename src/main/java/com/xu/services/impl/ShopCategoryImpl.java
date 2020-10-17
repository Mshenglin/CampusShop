package com.xu.services.impl;

import com.xu.dao.ShopCategoryDao;
import com.xu.entity.ShopCategory;
import com.xu.services.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ma
 */
@Service
public class ShopCategoryImpl implements ShopCategoryService {
    @Autowired
    ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
