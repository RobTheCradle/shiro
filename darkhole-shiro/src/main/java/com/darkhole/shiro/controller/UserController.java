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
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
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
        cutpic.add("1024x780");
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
    private static boolean processFLV(String oldfilepath) {

        /*if (!checkfile(PATH)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }*/

        // 文件命名
        Calendar c = Calendar.getInstance();
        String savename = String.valueOf(c.getTimeInMillis())+ Math.round(Math.random() * 100000);
        List<String> commend = new ArrayList<String>();
        commend.add("D:\\ffmpeg\\ffmpeg.exe");
        commend.add("-i");
        commend.add(oldfilepath);
        commend.add("-ab");
        commend.add("56");
        commend.add("-ar");
        commend.add("44100");
        commend.add("-qscale");
        commend.add("8");
        commend.add("-r");
        commend.add("15");
        commend.add("-s");
        commend.add("1024x780");
        commend.add("d:\\cdoc\\1.flv");

        try {
            Runtime runtime = Runtime.getRuntime();
            Process proce = null;
            //视频截图命令，封面图。  8是代表第8秒的时候截图
            String cmd = "";
            String cut = "     d:\\ffmpeg\\ffmpeg.exe   -i   "
                    + oldfilepath
                    + "   -y   -f   image2   -ss   8   -t   0.001   -s   600x500   d:\\cdoc\\"
                    + "a.jpg";
            String cutCmd = cmd + cut;
            proce = runtime.exec(cutCmd);
            //调用线程命令进行转码
            ProcessBuilder builder = new ProcessBuilder(commend);
            builder.command(commend);
            builder.start();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {

       UserController u =  new UserController();
       u.executeCodecs("D:/ffmpeg/ffmpeg.exe","D:/upload/10-7.mp4","D:/cdoc/3.flv","D://cdoc/24.jpg");
       // processFLV("d:\\upload\\1.mp4");
    }

    @GetMapping("/video")
    public String getVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("d:/cdoc/2.flv");
        RandomAccessFile in = new RandomAccessFile(file,"r");
       // in.skip((long)(1024*1024*50));
        try {
            ServletOutputStream fileOutputStream = response.getOutputStream();
            response.setContentType("video/x-flv");
            response.setContentLength((int) in.length());
            //定义一个缓冲数组
            byte[] b = new byte[10];
            /*byte[] c = new byte[1024];
            in.read(c);
            for(byte b1 : c){
                System.out.print(String.valueOf(b1));
            }*/
//定义一个索引

            int len = -1;
          /*  byte[] data = new byte[] { 'F', 'L', 'V', '1', '1', '0', '0', '0', '9', '0',
            '0', '0', '9' };*/
            //byte[] data = new byte[] {0x46, 0x4C, 0x56, 0x01, 0x05, 0x00, 0x00, 0x00, 0x09};
           // fileOutputStream.write(data,0,data.length);

            while((len = in.read(b))!=-1){
                fileOutputStream.write(b,0,len);
            }


            fileOutputStream.flush();
            fileOutputStream.close();




        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
   /* @GetMapping("/videos")
    public void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

        // TODO Auto-generated method stub



        resp.reset();

        resp.setContentType("Video/x-flv");



        String target = 1024*1024*50+"";  //接收参数，为字节数

        int targetInt = 0;




        String flvPath = "d:/cdoc/3.flv";




        RandomAccessFile raf = null;

        int totalByte = 0;

        try{

            raf = new RandomAccessFile(flvPath, "r");

            totalByte = (int)raf.length();



            if (target != null && !"".equals(target)) {

            try {

                targetInt = Integer.parseInt(target);

                byte[] headData = new byte[]{'F','L','V',1,1,0,0,0,9,0,0,0,9}; //拖动时间轴后的response中头信息需写入该字节

                //resp.getOutputStream().write(headData);

                resp.setContentLength(totalByte - targetInt + 13);

            } catch (NumberFormatException e) {

                targetInt = 0;

            }

        } else {

            resp.setContentLength(totalByte - targetInt);

        }



        //raf.skipBytes(targetInt);//跳过时间轴前面的字节;



        byte[] b = new byte[10];

        while(raf.read(b) != -1) {

            resp.getOutputStream().write(b);

        }

        resp.getOutputStream().flush();



    } catch (Exception e) {

        String simplename = e.getClass().getSimpleName();

        if(!"ClientAbortException".equals(simplename)){

            e.printStackTrace();

        }//web端拖动时间轴总有连接被重置的异常，暂时还不知如何解决，可以此方式不输出异常

    } finally {

        if(raf != null){

            raf.close();

        }

    }

}*/


}

