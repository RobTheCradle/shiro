package com.darkhole.shiro.dao;

import com.darkhole.shiro.model.Url;

import java.util.List;

public interface UrlMapper {
    int deleteByPrimaryKey(String urlId);

    int insert(Url record);

    int insertSelective(Url record);

    Url selectByPrimaryKey(String urlId);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKey(Url record);

    /**
     * 根据url修改权限列表
     * @param record
     * @return
     */
    int updateByUrl(Url record);
    /**
     * 获取所有url的权限信息
     */
    List<Url> selectUrls();
}