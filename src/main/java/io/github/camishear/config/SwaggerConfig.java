package io.github.camishear.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .servers(
                        new Server("dev", "http://127.0.0.1:8080", "Local", List.of(), List.of())
                        ,new Server("test", "http://teste.com", "", new ArrayList<>(), new ArrayList<>())
                        )
                .select()
                //.apis(RequestHandlerSelectors.basePackage("io.github.camishear.api.controller"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    
    
    
    
    
    
    

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API CamisHars")
                .description("Aplicação para controle de serviços para cabeleleira")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact(
                "Wyllian Sales",
                "https://github.com/wylliansales",
                "wylliansalles@gmail.com");

    }
}
