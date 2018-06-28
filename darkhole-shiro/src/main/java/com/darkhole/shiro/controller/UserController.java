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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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



    public boolean executeCodecs(String ffmpegPath,String upFilePath,String codcFilePath,String mediaPicPath) {
        List<String> convert = new ArrayList<>();
        convert.add(ffmpegPath);//添加转换工具路径
        convert.add("-i");
        convert.add(upFilePath);//添加要转换格式的视频文件的路径
        convert.add("-qscale");//指定转换质量
        convert.add("6");
        convert.add("-ab");//设置音频码率
        convert.add("64");
        convert.add("-ac");//设置声道数
        convert.add("2");
        convert.add("-ar");//设置声音的采样频率
        convert.add("22050");
        convert.add("-r");//设置帧频
        convert.add("24");
        convert.add("-y");//添加参数-y，该参数指定将覆盖已存在的文件
        convert.add(codcFilePath);//格式转换后的保存路径

        List<String> cutpic = new ArrayList<>();
        cutpic.add(ffmpegPath);
        cutpic.add("-i");
        cutpic.add(upFilePath);
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss");//该参数指定截取的起始时间
        cutpic.add("17");//其实时间为17s
        cutpic.add("-t");//指定持续时间
        cutpic.add("0.001");//持续时间为1毫秒
        cutpic.add("-s");//指定截取图片的大小
        cutpic.add("800*280");
        cutpic.add(mediaPicPath);

        boolean mark = true;

        try {

        ProcessBuilder builder = new ProcessBuilder();
        builder.command(convert);
        builder.redirectErrorStream(true);
        builder.start();

        builder.command(cutpic);
        builder.redirectErrorStream(true);
        builder.start();
        }catch (Exception e){
            mark=false;
            System.out.println(e.getStackTrace());
        }



        return mark;
    }

    public static void main(String[] args) {

       UserController u =  new UserController();
       u.executeCodecs("D:/ffmpeg/ffmpeg.exe","D://upload/1.mp4","D://codc/1.flv","D://codc/23.jpg");

    }
}
