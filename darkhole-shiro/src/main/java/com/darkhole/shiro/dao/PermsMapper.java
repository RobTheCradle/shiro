package com.darkhole.shiro.dao;

import com.darkhole.shiro.model.Perms;

public interface PermsMapper {
    int deleteByPrimaryKey(String pId);

    int insert(Perms record);

    int insertSelective(Perms record);

    Perms selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(Perms record);

    int updateByPrimaryKey(Perms record);
}