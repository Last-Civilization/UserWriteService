package com.lastcivilization.userwriteservice.infrastructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lastcivilization.userwriteservice.infrastructure.service")
public class UserWriteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWriteServiceApplication.class, args);
    }

}
