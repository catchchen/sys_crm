package com.company.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenk
 * @date 2021/11/1 13:43
 * @description swagger2 配置文件类
 */
@Configuration
@EnableSwagger2 //
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 是否开启（true 开启 false隐藏）生产环境 建议为false 隐藏
                // .enable(false)
                .apis(RequestHandlerSelectors.basePackage("com.company.controller"))
                // 扫描的路径，设置basePackage会将包下的所有被@Api标记的所有方法作为API
                // any() 表示所有路径
                .paths(PathSelectors.any()).build();
    }
    public ApiInfo apiInfo(){// 接口相关信息
        return new ApiInfoBuilder()
                // 设置文档标题
                .title("crm接口文档")
                // 文档描述
                .description("接口文档")
                // 服务器url
                .termsOfServiceUrl("http://localhost:9999/")
                // 版本号
                .version("1.0.0").build();// 构建者模式
    }
}
