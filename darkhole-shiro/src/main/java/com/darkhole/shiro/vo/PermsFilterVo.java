package com.darkhole.shiro.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 辜勇胜
 * @Title: PermsFilterVo
 * @Package com.darkhole.shiro.vo
 * @Description: TODO()
 * @date 2018/6/29 13:28
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class PermsFilterVo {
    //需要过滤权限的url
    private String url;
    //存放角色列表
    private List<String> roles;
    //存放权限列表
    private List<String> perms;
    //存放认证类型  --> anon:无需登陆即可访问     authc:登录后才可访问
    private String authType;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }


    //将权限转换为字符串
    public String getStringOfPermsFilter(){
        StringBuffer sb = new StringBuffer();
        if("anon".equals(this.authType)||"authc".equals(this.authType)){
            sb.append(this.authType);
        }else {
            if(this.roles!= null && this.roles.size()>0){
                sb.append("roles[");
                for(int i = 0;i<this.roles.size();i++){
                    sb.append(this.roles.get(i));
                    if(i<this.roles.size()-1){
                        sb.append(",");
                    }
                }
                sb.append("]");

                if(this.perms!=null && this.perms.size()>0){
                    sb.append(",");
                }
            }


            if(this.perms!=null && this.perms.size()>0){
               sb.append("perms[");
               for(int i = 0;i<this.perms.size();i++){
                   sb.append(this.perms.get(i));
                   if(i<this.perms.size()-1){
                       sb.append(",");
                   }
               }
               sb.append("]");
            }
        }
        if(sb.length()<=0){
            return "authc";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       /* PermsFilterVo p = new PermsFilterVo();
        List<String> rList = new ArrayList<>();
        List<String> pList = new ArrayList<>();
        rList.add("医生");
        rList.add("护士");
        rList.add("导医");
        pList.add("查看");
        //p.setAuthType("authc");
        p.setPerms(pList);
        p.setRoles(rList);
        System.out.println(p.getStringOfPermsFilter());*/

       PermsFilterVo p = new PermsFilterVo();
        List<String> rList = new ArrayList<>();
        List<String> pList = new ArrayList<>();
        rList.add("医生");
        rList.add("护士");
        rList.add("导医");
        pList.add("查看");
        p.setUrl("/getUserInfoWithPerms");
        p.setPerms(pList);
        p.setRoles(rList);
        String s = JSON.toJSONString(rList);
        System.out.println(JSON.toJSONString(rList));
        JSONArray ss = (JSONArray) JSON.parse(s);
        System.out.println(JSON.toJSONString(p));
    }

}
