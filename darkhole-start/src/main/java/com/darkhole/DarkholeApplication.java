package com.darkhole;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 辜勇胜
 * @Title: DarkholeApplication
 * @Package com.darkhole
 * @Description: TODO(应用启动类)
 * @date 2018/6/15 15:39
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@MapperScan("**.dao")
@SpringBootApplication
public class DarkholeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DarkholeApplication.class,args);
    }
}
