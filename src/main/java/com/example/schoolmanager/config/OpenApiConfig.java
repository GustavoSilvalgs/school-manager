package com.example.schoolmanager.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("School Manager with Java and Spring Boot")
                        .version("v1")
                        .description("School Manager")
                        .termsOfService("https://github.com/GustavoSilvalgs")
                        .license(
                                new License()
                                .name("Apache 2.0")
                                .url("https://github.com/GustavoSilvalgs")));
    }
}
