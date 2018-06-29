package com.darkhole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author 辜勇胜
 * @Title: SwaggerConfig
 * @Package com.darkhole
 * @Description: TODO()
 * @date 2018/6/28 14:44
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Configuration
public class SwaggerConfig {


        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.darkhole"))
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("springboot利用swagger构建api文档")
                    .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
                    .termsOfServiceUrl("http://blog.csdn.net/saytime")
                    .version("1.0")
                    .build();
    }

}
