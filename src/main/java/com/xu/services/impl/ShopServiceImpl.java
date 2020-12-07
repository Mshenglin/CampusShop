package com.xu.services.impl;


import com.xu.dao.ShopDao;
import com.xu.dto.ShopExecution;
import com.xu.entity.Shop;
import com.xu.enums.OperationStatusEnum;
import com.xu.enums.ShopStateEnum;
import com.xu.exceptions.ShopOperationException;
import com.xu.services.ShopService;
import com.xu.util.ImageUtil;
import com.xu.util.PageCalculator;
import com.xu.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public Shop getByShopId(long shopId) throws ShopOperationException {

        return shopDao.queryByShopId(shopId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopExecution modifyShop(Shop shop, MultipartFile shopImg) throws ShopOperationException{
        //空值判断
        if(shop == null || shop.getShopId()==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
        //1.判断是否需要处理图片
        if(shopImg!=null){
            //查找数据库中该shop的信息
            Shop tempShop= shopDao.queryByShopId(shop.getShopId());
            if (tempShop.getShopImg()!=null){
            ImageUtil.deleteFileOrPath(tempShop.getShopImg());
            }
            //向数据库中添加新的路径
            addImage(shop,shopImg);
        }
        //更新店铺信息
        shop.setLastEditTime(new Date());
        int effectedNum=shopDao.updateShop(shop);
        if (effectedNum<=0){
            return new ShopExecution(ShopStateEnum.EDIT_ERROR);
        }
        else {
            return new ShopExecution(OperationStatusEnum.SUCCESS,shop);
        }
        }catch (Exception e){

            throw  new ShopOperationException(ShopStateEnum.EDIT_ERROR.getStateInfo()+e.getMessage());
        }
    }

    @Override
    @Transient
    public ShopExecution addShop(Shop shop, MultipartFile shopImg) throws ShopOperationException {
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

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) throws ShopOperationException {
        // 前台页面插入的pageIndex（第几页）， 而dao层是使用 rowIndex （第几行） ，所以需要转换一下
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Shop> shopList = new ArrayList<Shop>();
        ShopExecution se = new ShopExecution();
        // 查询带有分页的shopList
        shopList = shopDao.selectShopList(shopCondition, rowIndex, pageSize);
        // 查询符合条件的shop总数
        int count = shopDao.selectShopCount(shopCondition);
        // 将shopList和 count设置到se中，返回给控制层
        if (shopList != null) {
            se.setShopList(shopList);
            se.setCount(count);
        } else {
            se.setState(ShopStateEnum.EDIT_ERROR.getState());
        }
        return se;
    }

    private void addImage(Shop shop, MultipartFile shopImg) {
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }

}