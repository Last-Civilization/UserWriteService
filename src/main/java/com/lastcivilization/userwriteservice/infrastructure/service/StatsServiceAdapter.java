package com.lastcivilization.userwriteservice.infrastructure.service;

import com.lastcivilization.userwriteservice.domain.port.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StatsServiceAdapter implements StatsService {

    private final StatsClient statsClient;

    @Override
    public Long createNewStats() {
        return statsClient.createNewStats();
    }
}
