package com.ezequiel.LaptopApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * localhost:8081/swagger-ui/
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Ezequiel Laptop",
                "Esto es una Api REST utilizando Spring",
                "v1",
                "http://www.google.com",
                new Contact("Ezequiel", "https://www.instagram.com/ezenunez3/", "ezequieln085@gmail.com"),
                "MIT",
                "www.google.com",
                Collections.EMPTY_LIST);
    }
}