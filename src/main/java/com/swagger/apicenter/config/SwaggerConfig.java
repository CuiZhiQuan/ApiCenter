package com.swagger.apicenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cuizhiquan
 * @Description
 * @date 2018/12/12 13:34
 * @Copyright (c) 2017, DaChen All Rights Reserved.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.apicenter"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API中心")
                .description("基于 swagger-bootstrap-ui 的API中心")
                .contact(contact())
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

    private Contact contact(){
        return new Contact("Cadolph","","cuizhiquan123@163.com");
    }
}
