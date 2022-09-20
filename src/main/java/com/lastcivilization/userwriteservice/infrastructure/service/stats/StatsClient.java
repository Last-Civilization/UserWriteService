package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stats-read-service", url = "http://localhost:9561")
interface StatsClient {

    @PostMapping("/stats")
    Stats createNewStats();
}
