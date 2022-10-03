package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import com.lastcivilization.userwriteservice.domain.exception.ApplicationException;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.infrastructure.service.stats.StatsClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StatsServiceAdapter implements StatsService {

    private final StatsClient statsClient;

    @Override
    public Long createNewStats() {
        try {
            return statsClient.createNewStats().id();
        }catch (FeignException exception){
            throw new ApplicationException(exception.getMessage());
        }
    }
}
