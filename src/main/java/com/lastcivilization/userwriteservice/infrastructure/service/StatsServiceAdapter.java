package com.lastcivilization.userwriteservice.infrastructure.service;

import com.lastcivilization.userwriteservice.domain.port.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile({"dev", "prod"})
class StatsServiceAdapter implements StatsService {

    private final StatsClient statsClient;

    @Override
    public Long createNewStats() {
        return statsClient.createNewStats();
    }
}
