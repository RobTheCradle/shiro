package com.darkhole.shiro.config;


import com.alibaba.fastjson.JSON;
import com.darkhole.shiro.model.Perms;
import com.darkhole.shiro.model.Role;
import com.darkhole.shiro.model.User;
import com.darkhole.shiro.service.UserService;
import com.darkhole.shiro.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * @author 辜勇胜
 * @Title: CustomRealm
 * @Package com.darkhole.shiro
 * @Description: TODO(shiro自定义安全中心)
 * @date 2018/6/15 16:04
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class CustomRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    /**
     * @Description: TODO(权限控制--读取并赋予用户角色/权限)
     * @param principalCollection
     * @throws
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String account= (String) principalCollection.getPrimaryPrincipal();
        User user = userService.getUserInfoWithPerms(account);

        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for(Role role:user.getRoles()){
            simpleAuthorizationInfo.addRole(role.getrName());
            for(Perms perms : role.getPermsList()){
                simpleAuthorizationInfo.addStringPermission(perms.getpName());
            }
        }

        return null;
    }
    /**
     * @Description: TODO(登陆控制--验证用户合法性)
     * @param authenticationToken
     * @throws
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //只是根据用户名查询出，不涉及密码
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (user != null) {
            // 把获取到的用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 把从数据库中查询出来的用户信息放到AuthenticationInfo中,
            // 即把正确的用户名，密码，交给shiro,再和前台输入的校验。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getuAccount(), user.getuPassword(), "customRealm");
            return authenticationInfo;


          /*  sysUser.setAccount(user.getAccount());
            try {
                sysUser = sysUserMapper.selectByProperty(sysUser);
                sysUser.setVerify(user.getAccount());
                request.getSession().setAttribute("sysUser", sysUser);
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), MD5Util.md5(user.getPassword(), sysUser.getSalt()), user.isRememberMe());
                subject.login(token);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("错误的用户名或密码");
                status = false;
            }*/
        } else {
            return null;
        }
    }
}
