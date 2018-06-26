package com.darkhole.shiro.model;

import java.util.List;

/**
 * @Title: User
 * @Package com.darkhole.shiro.model
 * @Description: TODO(用户实体类)
 * @author 辜勇胜
 * @date 2018/6/25 11:30
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class User {
    //用户主键id
    private String uId;
    //用户账号
    private String uAccount;
    //用户密码
    private String uPassword;
    //盐
    private String uSalt;
    //用户状态
    private Integer uStatus;
    //角色集合
    private List<Role> roles;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount == null ? null : uAccount.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuSalt() {
        return uSalt;
    }

    public void setuSalt(String uSalt) {
        this.uSalt = uSalt == null ? null : uSalt.trim();
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}