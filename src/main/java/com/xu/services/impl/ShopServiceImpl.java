package com.xu.services.impl;

import com.xu.dao.ShopDao;
import com.xu.dto.ShopExecution;
import com.xu.enums.OperationStatusEnum;
import com.xu.exceptions.ShopOperationException;
import com.xu.entity.Shop;
import com.xu.enums.ShopStateEnum;
import com.xu.services.ShopService;
import com.xu.util.ImageUtil;
import com.xu.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.beans.Transient;
import java.io.File;
import java.util.Date;

/**
 * 店铺操作接口实现类
 *
 * @author mashenglin
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transient
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException {
        //店铺的空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        //店铺不为空
        else {
            try {
                //对店铺初始化赋值
                shop.setCreateTime(new Date());
                shop.setEnableStatus(ShopStateEnum.CHECK.getState());
                //添加店铺信息,返回操作的影响数
                int effectedNum = shopDao.insertShop(shop);
                System.out.println("insertShop"+effectedNum);
                //添加店铺失败
                if (effectedNum <= 0) {
                    throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo());
                } else {
                    //对传入的图片处理
                    //传入的图片是空
                    if (shopImg == null) {
                        throw new ShopOperationException(OperationStatusEnum.PIC_EMPTY.getStateInfo());
                    } else {
                        try {
                            //储存图片
                            addImage(shop, shopImg);
                            int updateShop = shopDao.updateShop(shop);
                            //是否更新成功
                            if (updateShop <= 0) {
                                throw new ShopOperationException(OperationStatusEnum.PIC_UPLOAD_ERROR.getStateInfo());
                            }
                        } catch (Exception e) {
                            throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo() + e.getMessage());
                        }
                    }
                }
            } catch (Exception e) {
                throw new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo() + e.getMessage());
            }
            return new ShopExecution(ShopStateEnum.CHECK, shop);
        }
    }

    private void addImage(Shop shop, CommonsMultipartFile shopImg) {
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        System.out.println(dest);
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        System.out.println(shopImgAddr);
        shop.setShopImg(shopImgAddr);
    }

}