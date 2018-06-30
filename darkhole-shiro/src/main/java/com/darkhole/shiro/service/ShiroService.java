package com.darkhole.shiro.service;

import com.darkhole.shiro.vo.PermsFilterVo;

/**
 * 权限控制接口
 */
public interface ShiroService {
    /**
     * 添加或修改url权限
     * @param permsFilterVo
     * @return
     */
    int applyUrlPerms(PermsFilterVo permsFilterVo);

    /**
     * 重载权限
     */
    void updatePermission();
}
