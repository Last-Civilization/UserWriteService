package com.lastcivilization.userwriteservice.infrastructure.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("stats-read-service")
interface StatsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/stats")
    Long createNewStats();
}
