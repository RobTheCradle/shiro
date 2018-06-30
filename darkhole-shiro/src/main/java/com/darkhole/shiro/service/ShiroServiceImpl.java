package com.darkhole.shiro.service;

import com.alibaba.fastjson.JSONObject;
import com.darkhole.shiro.dao.UrlMapper;
import com.darkhole.shiro.model.Url;
import com.darkhole.shiro.vo.PermsFilterVo;
import com.darkhole.utils.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限控制逻辑层
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private UrlMapper urlMapper;
    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;
    /**
     * 修改url需要的权限
     * @param permsFilterVo
     * @return
     */
    @Override
    public int applyUrlPerms(PermsFilterVo permsFilterVo) {
        Url url = new Url();
        if(permsFilterVo==null || StringUtils.isNull(permsFilterVo.getUrl())) return 0;
        url.setUrlHref(permsFilterVo.getUrl());
        url.setUrlPerms(JSONObject.toJSONString(permsFilterVo));
        return urlMapper.updateByUrl(url);
    }
    /**
     * 初始化权限
     */
    private Map<String, String> loadFilterChainDefinitions() {
        List<Url> urls = urlMapper.selectUrls();
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        for(Url url : urls){
            //filterChainDefinitionMap.put("/getUserInfoWithPerms", "roles[医生,护士],perms[查看]");
            PermsFilterVo permsFilterVo = JSONObject.parseObject(url.getUrlPerms(),PermsFilterVo.class);
            filterChainDefinitionMap.put(url.getUrlHref(), permsFilterVo.getStringOfPermsFilter());
        }
        return filterChainDefinitionMap;
    }

    /**
     * 重新加载权限
     */
    public void updatePermission() {

        synchronized (shiroFilterFactoryBean) {

            AbstractShiroFilter shiroFilter = null;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean
                        .getObject();
            } catch (Exception e) {
                throw new RuntimeException(
                        "get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
                    .getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
                    .getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean
                    .setFilterChainDefinitionMap(loadFilterChainDefinitions());
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean
                    .getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim()
                        .replace(" ", "");
                manager.createChain(url, chainDefinition);
            }

            System.out.println("更新权限成功！！");
        }
    }
}
