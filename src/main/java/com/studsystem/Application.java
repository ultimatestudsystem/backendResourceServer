package com.studsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class Application {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.studsystem.controllers"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
