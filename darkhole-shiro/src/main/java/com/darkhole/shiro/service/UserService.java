package com.darkhole.shiro.service;

import com.darkhole.shiro.model.User;
import org.springframework.stereotype.Service;

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
}
