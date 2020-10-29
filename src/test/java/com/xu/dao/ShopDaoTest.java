package com.xu.dao;

import com.xu.BeseTest;
import com.xu.entity.Area;
import com.xu.entity.PersonInfo;
import com.xu.entity.Shop;
import com.xu.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BeseTest {
    @Autowired
    ShopDao shopDao;
    @Test
    public void insertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        Area area = new Area();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("test");
        shop.setShopName("test店铺");
        shop.setShopDesc("test");
        shop.setShopImg("test");
        shop.setPhone("test");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        int effectNum = shopDao.insertShop(shop);
        System.out.println("effectNum：" + effectNum);
    }

    @Test
    public void  updateTest(){
        Shop shop = new Shop();
        shop.setShopId(3L);
        shop.setShopAddr("test@111");
        shop.setShopName("@test@111");
        shop.setShopDesc("test111");
        shop.setShopImg("test111");
        shop.setPhone("test111");
        shop.setLastEditTime(new Date());
        int effectNum = shopDao.updateShop(shop);
        System.out.println("effectNum：" + effectNum);
    }
    @Test
    public void testInsertShop(){
        long shopId=1;
        Shop shop=shopDao.queryByShopId(shopId);
        System.out.println(shop);
        System.out.println(shop.getArea().getAreaId());
    }
}
