package com.xu.entity;

import java.io.Serializable;
import java.util.Date;

public class WechatAuth implements Serializable {
    /**
     * 微信账号id
     */
    private Long wechatAuthId;
    /**
     * poenid
     */
    private String openId;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 用户实例
     */
    private PersonInfo personInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
