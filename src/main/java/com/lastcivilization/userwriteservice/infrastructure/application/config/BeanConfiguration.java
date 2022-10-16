package com.lastcivilization.userwriteservice.infrastructure.application.config;

import com.lastcivilization.userwriteservice.domain.UserService;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.lastcivilization.userwriteservice")
@EnableJpaRepositories("com.lastcivilization.userwriteservice.infrastructure.database")
@EntityScan("com.lastcivilization.userwriteservice.infrastructure.database")
class BeanConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, EquipmentService equipmentService, StatsService statsService, PaymentService paymentService
            , UserCreateSage userCreateSage){
        return new UserService(statsService,equipmentService, paymentService, userRepository, userCreateSage);
    }
}
