package com.darkhole.shiro.model;

import java.util.List;
/**
 * @Title: Role
 * @Package com.darkhole.shiro.model
 * @Description: TODO(用户角色实体类)
 * @author 辜勇胜
 * @date 2018/6/25 14:17
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class Role {
    //角色主键id
    private String rId;
    //角色名称
    private String rName;
    //角色状态 1 --> 正常 0 --> 删除
    private Integer rStatus;
    //权限列表
    private List<Perms> permsList;
    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }

    public List<Perms> getPermsList() {
        return permsList;
    }

    public void setPermsList(List<Perms> permsList) {
        this.permsList = permsList;
    }
}