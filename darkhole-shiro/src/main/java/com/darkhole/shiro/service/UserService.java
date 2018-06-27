package com.darkhole.shiro.service;

import com.darkhole.shiro.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 辜勇胜
 * @Title: UserService
 * @Package com.darkhole.shiro.service
 * @Description: TODO(用户数据处理逻辑层)
 * @date 2018/6/25 13:45
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public interface UserService {
    /**
     * @Description: TODO(根据用户账号查询用户基本信息和角色权限信息)
     * @param account 用户账号
     * @throws
     */
    User getUserInfoWithPerms(String account);
    /**
     * @Description: TODO(根据用户账号获取用户基本信息)
     * @param account 用户账号
     * @throws
     */
    User getUserBasicInfo(String account);
    /**
     * @Description: TODO(用户登陆)
     * @param account  用户账号
     * @param password  用户密码
     * @throws
     */
    boolean login(String account, String password, HttpServletRequest request);
}
