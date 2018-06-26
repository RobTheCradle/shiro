package com.darkhole.utils;

/**
 * @author 辜勇胜
 * @Title: StringUtils
 * @Package com.darkhole.utils
 * @Description: TODO(字符串处理工具)
 * @date 2018/6/25 11:54
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public class StringUtils {
    
    /**
     * @Description: TODO(判断字符串是否为空) 
     * @param str 
     * @throws   
     */
    public static boolean isNull(String str){
        return str==null || "".equals(str.trim());
    }
}
