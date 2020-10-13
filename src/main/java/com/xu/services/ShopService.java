package com.xu.services;

import com.xu.dto.ShopExecution;
import com.xu.exceptions.ShopOperationException;
import com.xu.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 商店的service层接口
 * @author mashenglin
 */
public interface ShopService {
    /**
     * 添加店铺的方法
     * @param shop 店铺对象
     * @param shopImg 店铺图片文件
     * @return 店铺状态
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, File shopImg) throws ShopOperationException;
}
