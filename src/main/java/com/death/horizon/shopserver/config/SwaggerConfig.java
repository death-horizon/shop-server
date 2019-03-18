package com.death.horizon.shopserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author dayday
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(operationParameters());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("shop Api文档")
                .description("shop server")
                .version("1.0")
                .build();
    }

    private List<Parameter> operationParameters() {
        Parameter parameter = new ParameterBuilder()
                .name("access-token")
                .description("登录验证")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        return List.of(parameter);
    }
}