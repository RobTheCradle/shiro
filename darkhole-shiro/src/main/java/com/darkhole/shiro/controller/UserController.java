package com.darkhole.shiro.controller;

import com.darkhole.shiro.model.User;
import com.darkhole.shiro.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 辜勇胜
 * @Title: UserController
 * @Package com.darkhole.shiro.controller
 * @Description: TODO(用户管理控制器)
 * @date 2018/6/25 12:09
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Controller
public class UserController {
    //用户数据处理逻辑
    @Resource
    private UserService userService;
    /**
     * @Description: TODO(根据用户账号获取用户基本信息和权限信息)
     * @param account 账号
     * @throws
     */
    @GetMapping("/getUserInfoWithPerms")
    @ResponseBody
    public User getUserInfoWithPerms(String account){
        User user = null;
        try {
           user = userService.getUserInfoWithPerms(account);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }
    @ApiOperation(value="登陆", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户实体user", required = true, dataType = "String")
    })
    @GetMapping("/login")
    @ResponseBody
    public boolean login(String account , String password, HttpServletRequest request){
        return userService.login(account,password, request);
    }
    @GetMapping("/test")
    public String index(){
        return "index";
    }
    @GetMapping("/defend")
    public String defend(){
        return "page/common/test";
    }

}
