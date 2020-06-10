package com.restcountries.code.restcountriesApi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket appApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(newArrayList(new ApiKey("Authorization-Key", "Authorization", "header")))
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.restcountries.code.restcountriesApi.controller")).build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Country Service")
                .description("Country Service API")
                .version("1")
                .build();
    }
}
