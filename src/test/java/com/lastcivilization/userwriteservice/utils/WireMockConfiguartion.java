package com.lastcivilization.userwriteservice.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
class WireMockConfiguartion {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer(){
        return new WireMockServer(9561);
    }
}
