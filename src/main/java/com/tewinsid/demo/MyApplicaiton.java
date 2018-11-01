package com.tewinsid.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.tewinsid.demo.model")
public class MyApplicaiton extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MyApplicaiton.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyApplicaiton.class);
    }
}
