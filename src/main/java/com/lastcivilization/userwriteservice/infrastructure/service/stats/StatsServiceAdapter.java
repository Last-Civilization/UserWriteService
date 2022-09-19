package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.infrastructure.service.stats.StatsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"dev", "prod"})
class StatsServiceAdapter implements StatsService {

    private final StatsClient statsClient;

    @Override
    public Long createNewStats() {
        return statsClient.createNewStats().id();
    }
}
