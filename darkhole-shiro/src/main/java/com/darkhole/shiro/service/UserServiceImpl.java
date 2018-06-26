package com.darkhole.shiro.service;

import com.darkhole.shiro.dao.UserMapper;
import com.darkhole.shiro.model.User;
import com.darkhole.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 辜勇胜
 * @Title: UserServiceImpl
 * @Package com.darkhole.shiro.service
 * @Description: TODO(用户数据处理逻辑实现类)
 * @date 2018/6/25 13:46
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Service
public class UserServiceImpl implements UserService{
    //用户数据接口
    @Resource
    private UserMapper userMapper;
    @Override
    /**
     * @Description: TODO(根据用户账号查询用户基本信息和权限信息)
     * @param account 用户账号
     * @throws
     */
    public User getUserInfoWithPerms(String account) {
        if(StringUtils.isNull(account)) throw new NullPointerException("用户账号为空!");
        User user = userMapper.selectUserInfoAndPermsByAccount(account);
        return user;
    }
}
