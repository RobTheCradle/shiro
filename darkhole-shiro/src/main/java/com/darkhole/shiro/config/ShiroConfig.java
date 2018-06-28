package com.darkhole.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 辜勇胜
 * @Title: ShiroConfig
 * @Package com.darkhole.shiro
 * @Description: TODO(shiro整合配置)
 * @date 2018/6/15 16:10
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Configuration
public class ShiroConfig {


    /**
     * @Description: TODO(shiro权限过滤链)
     * @param manager
     * @throws
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager) {
        //配置自定义filter
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("roles",new CustomRolesAuthorizationFilter());
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/home");

        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/getUserInfoWithPerms", "roles[医生,护士],perms[查看]");
        filterChainDefinitionMap.put("/**","anon");

        //将权限注入到过滤链
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //注入自定义filter
        bean.setFilters(filterMap);
        return bean;
    }

    /**
     * @Description: TODO(声明SecurityManager)
     * @param customRealm 自定义认证中心
     * @throws
     */
    @Bean
    public SecurityManager securityManager(@Qualifier("customRealm") CustomRealm customRealm) {

        System.err.println("加载shiro");
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(customRealm);
        //注入记住我管理器;
        manager.setRememberMeManager(rememberMeManager());
        return manager;
    }

    /**
     * @Description: TODO(注册自定义的Realm)
     * @param
     * @throws
     */
    @Bean
    public CustomRealm customRealm() {
        CustomRealm myRealm=new CustomRealm();
        return myRealm;
    }

    /**
     * @Description: TODO(cookie管理对象;rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中)
     * @param
     * @throws
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {

        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    /**
     * @Description: TODO(cookie对象;这个参数是cookie的名称，对应前端的checkbox的name = rememberMe)
     * @param
     * @throws Exception
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //记住我cookie生效时间10天 ,单位秒;
        simpleCookie.setMaxAge(864000);
        return simpleCookie;
    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}




