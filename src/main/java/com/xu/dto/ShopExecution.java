package com.xu.dto;

import com.xu.entity.Shop;
import com.xu.enums.OperationStatusEnum;
import com.xu.enums.ShopStateEnum;

import java.util.List;

/**
 * 店铺返回
 * @author Dell
 */
public class ShopExecution {

    /**
     *结果状态
     */
    private int state;

    /**
     *状态标识
     */
    private String stateInfo;

    /**
     *店铺数量
     */
    private int count;

    /**
     *操作的shop（增删改店铺的时候用）
     */
    private Shop shop;

    /**
     * 获取的shop列表(查询店铺列表的时候用)
     */
    private List<Shop> shopList;

    public  ShopExecution(OperationStatusEnum success, Shop shop) {
    }

    /**
     * 店铺操作失败时用的构造方法
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum){
        this.state=shopStateEnum.getState();
        this.stateInfo=shopStateEnum.getStateInfo();
    }
    /**
     * 店铺操作成功的时候用的构造方法
     * @param shopStateEnum 店铺状态的枚举类型
     * @param shop
     */
    public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
        this.state=shopStateEnum.getState();
        this.stateInfo=shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    @Override
    public String toString() {
        return "ShopExecution{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", count=" + count +
                ", shop=" + shop +
                ", shopList=" + shopList +
                '}';
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
