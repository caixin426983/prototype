package com.cx.prototype.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Description Swagger2接口配置类
 * @Author cx
 * @Date 2019/1/7 14:37
 **/
@Configuration
@EnableSwagger2
public class Swagger {


    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.cx.prototype.mode.controller")).
                paths(PathSelectors.any()).
                build().
                apiInfo(apiInfo()).
                securitySchemes(securitySchemes());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").
                description("更多Spring Boot相关文章请关注：http://blog.didispace.com/").
                termsOfServiceUrl("http://blog.didispace.com/").
                version("1.0").
                build();
    }

    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }


}
