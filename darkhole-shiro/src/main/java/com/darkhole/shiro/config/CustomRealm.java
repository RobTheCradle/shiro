package com.darkhole.shiro.config;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 辜勇胜
 * @Title: CustomRealm
 * @Package com.darkhole.shiro
 * @Description: TODO(shiro自定义安全中心)
 * @date 2018/6/15 16:04
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class CustomRealm extends AuthorizingRealm {
    /**
     * @Description: TODO(权限控制--读取并赋予用户角色/权限)
     * @param principalCollection
     * @throws
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }
    /**
     * @Description: TODO(登陆控制--验证用户合法性)
     * @param authenticationToken
     * @throws
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        return null;
    }
}
