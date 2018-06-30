package com.darkhole.shiro.controller;

import com.darkhole.shiro.service.ShiroService;
import com.darkhole.shiro.vo.PermsFilterVo;
import com.darkhole.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 辜勇胜
 * @Title: ShiroController
 * @Package com.darkhole.shiro.controller
 * @Description: TODO(权限管理控制器)
 * @date 2018/6/25 12:09
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @Resource
    private ShiroService shiroService;
    /**
     * 添加或修改url所需权限
     * @param permsFilter
     * @return
     */
    @PostMapping("/applyUrlPerms")
    @ResponseBody
    public boolean applyUrlPerms(@RequestBody PermsFilterVo permsFilter){
        if(permsFilter==null || StringUtils.isNull(permsFilter.getUrl())) return false;
        int res = shiroService.applyUrlPerms(permsFilter);
        shiroService.updatePermission();
        if(res>0) return true;

        return false;
    }
}
