package com.darkhole;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 辜勇胜
 * @Title: DarkholeApplication
 * @Package com.darkhole
 * @Description: TODO(应用启动类)
 * @date 2018/6/15 15:39
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@EnableSwagger2
@MapperScan("**.dao")
@SpringBootApplication
public class DarkholeApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DarkholeApplication.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DarkholeApplication.class);
    }
}
