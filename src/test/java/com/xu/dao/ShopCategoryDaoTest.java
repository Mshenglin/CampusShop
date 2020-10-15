package com.xu.dao;

import com.xu.BeseTest;
import com.xu.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class ShopCategoryDaoTest extends BeseTest {
    @Autowired
    ShopCategoryDao shopCategoryDao;
    @Test
    public void queryShopCategoryTest(){
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        System.out.println(shopCategories.toString());
    }
}
