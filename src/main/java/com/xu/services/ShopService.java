package com.xu.services;

import com.xu.dto.ShopExecution;
import com.xu.entity.Shop;
import com.xu.exceptions.ShopOperationException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商店的service层接口
 * @author mashenglin
 */
public interface ShopService {
    /**
     * 通过店铺的id来获取店铺信息
     * @param shopId 店铺id
     * @return Shop
     * @throws ShopOperationException
     */
    Shop getByShopId(long shopId) throws ShopOperationException;

    /**
     * 更新店铺的信息，包括对图片的处理
     * @param shop
     * @param multipartFile
     * @return
     */
 ShopExecution   modifyShop(Shop shop,MultipartFile multipartFile);
    /**
     * 添加店铺的方法
     * @param shop 店铺对象
     * @param shopImg 店铺图片文件
     * @return 店铺状态
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, MultipartFile shopImg) throws ShopOperationException;
    /**
     * 获取店铺分页列表
     *
     * @param shopCondition 店铺查询条件
     * @param pageIndex     第几页
     * @param pageSize      每页条数
     * @return
     * @throws ShopOperationException
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) throws ShopOperationException;
}
