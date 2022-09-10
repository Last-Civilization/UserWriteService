package com.lastcivilization.userwriteservice.utils;

import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
class TestBeanConfiguration {

    @Bean
    EquipmentService equipmentService(){
        return new EquipmentService() {
            @Override
            public Long createNewEquipment() {
                return 0L;
            }
        };
    }

    @Bean
    StatsService statsService(){
        return new StatsService() {
            @Override
            public Long createNewStats() {
                return 0L;
            }
        };
    }
}
