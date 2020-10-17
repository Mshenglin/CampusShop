package com.xu.dao;

import com.xu.BeseTest;
import com.xu.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShopCategoryDaoTest extends BeseTest {
    @Autowired
    ShopCategoryDao shopCategoryDao;
    @Test
    public void queryShopCategoryTest(){
        ShopCategory shopCategory = new ShopCategory();
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(1L);
        shopCategory.setParent(parent);
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(shopCategory);
        for (ShopCategory object : shopCategories) {
            System.out.println(object);
        }
    }
}
