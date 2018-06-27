package com.darkhole.shiro.dao;

import com.darkhole.shiro.model.User;
/**
 * @Title: UserMapper
 * @Package com.darkhole.shiro.dao
 * @Description: TODO(用户数据接口)
 * @author 辜勇胜
 * @date 2018/6/25 11:21
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public interface UserMapper {

    int deleteByPrimaryKey(String uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * @Description: TODO(根据用户账号，查询出用户基本信息和权限信息)
     * @param account 用户账号
     * @throws
     */
    User selectUserInfoAndPermsByAccount(String account);
    /**
     * @Description: TODO(根据用户账号查询出用户基本信息)
     * @param account 用户账号
     * @throws
     */
    User selectByAccount(String account);
}