package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("stats-read-service")
interface StatsClient {

    @PostMapping("/stats")
    Long createNewStats();
}
