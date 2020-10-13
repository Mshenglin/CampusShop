package com.xu.enums;

/**
 * 商店状态枚举
 * @author ma
 */

public enum ShopStateEnum {
    /**
     * state是店铺状态值，stateInfo店铺状态值描述
     */
    CHECK(0, "审核中"),
    PASS(1, "通过认证"),
    OFFLINE(-2001, "非法商铺"),
    EDIT_ERROR(-2002, "店铺操作失败"),
    NULL_SHOP_ID(-2003, "ShopId为空"),
    NULL_SHOP_INFO(-2004, "店铺信息为空");

    /**
     *结果状态
     */
    private final int state;
    /**
     * 结果状态描述
     */
    private final String stateInfo;

    /**
     * 构造方法
     * @param state
     * @param stateInfo
     */
    private  ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    /**
     * 根据传入的state值返回相应的状态描述
     */
    public static ShopStateEnum stateOf(int index){
        for (ShopStateEnum state: values()
             ) {
            if(state.getState()==index) {
                return state;
            }
        }
        return  null;
    }
}
