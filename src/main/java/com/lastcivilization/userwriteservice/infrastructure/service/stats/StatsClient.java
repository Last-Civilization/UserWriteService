package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stats-read-service", url = "${test.url:#{null}}")
public interface StatsClient {

    @PostMapping("/stats")
    Stats createNewStats();
}
