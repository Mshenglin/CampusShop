package com.xu.service;

import com.xu.BeseTest;
import com.xu.dto.ShopExecution;
import com.xu.entity.Area;
import com.xu.entity.PersonInfo;
import com.xu.entity.Shop;
import com.xu.entity.ShopCategory;
import com.xu.services.ShopService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ShopServiceTest extends BeseTest {
    @Autowired
    ShopService shopService;
    @Test

    public  void TestAddShop(){
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
        shop.setShopAddr("testService");
        shop.setShopName("test店铺Service");
        shop.setShopDesc("testService");
        shop.setShopImg("testService");
        shop.setPhone("testService");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        /**
        String filepath="D:\\OIP.jpg";
        File shopImg=new File(filepath);
        ShopExecution addShop = shopService.addShop(shop, shopImg);
        System.out.println(addShop.toString());
         */
    }
    @Test
    public  void testModifyShop() throws IOException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的照片");
        String filePath="C:\\Users\\Dell\\Desktop\\other\\1.jpg";
        shopService.modifyShop(shop, path2MultipartFile(filePath));
    }
    /**
     * filePath to MultipartFile
     *
     * @param filePath
     * @throws IOException
     */
    private MultipartFile path2MultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
                IOUtils.toByteArray(input));
        return multipartFile;
    }
}
