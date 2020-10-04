package com.xu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  mashenglin
 */
public class LocalAuth  implements Serializable {
    /**
     * 本地账号id
     */
    private long  localAuthId;
    /**
     * 用户姓名
     */
    private  String username;
    /**
     * 用户密码
     */
    private  String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date lastEditTime;
    /**
     * 用户
     */
    private PersonInfo personInfo;

    public long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
