package com.lastcivilization.userwriteservice.infrastructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserWriteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWriteServiceApplication.class, args);
    }

}
