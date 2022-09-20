package com.lastcivilization.userwriteservice.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.lastcivilization.userwriteservice.infrastructure.service.equipment.EquipmentClient;
import com.lastcivilization.userwriteservice.infrastructure.service.payment.PaymentClient;
import com.lastcivilization.userwriteservice.infrastructure.service.stats.StatsClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@TestConfiguration
class WireMockConfiguartion {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer(){
        return new WireMockServer(9561);
    }
}
