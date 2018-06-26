package com.darkhole.shiro.dao;

import com.darkhole.shiro.model.Url;

public interface UrlMapper {
    int deleteByPrimaryKey(String urlId);

    int insert(Url record);

    int insertSelective(Url record);

    Url selectByPrimaryKey(String urlId);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKey(Url record);
}