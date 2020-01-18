package com.dhg.sell.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2Api版本管理配置,使用builder
 * 1:apiInfo:一些接口信息:标题,描述,版本,服务器
 * 2:docket: 生成具体的文档:扫描请求拦截的基本包(groupId),apiInfo,接口的路径
 */
@Configuration
@EnableSwagger2
public class Swagger2{
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dhg.sell"))
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Springboot使用Swagger2进行Api版本管理")
                .description("好的api给你一个统一资源定位")
                .termsOfServiceUrl("服务器的url")
                .version("1.0")
                .build();
    }

}
