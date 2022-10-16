package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import com.lastcivilization.userwriteservice.domain.exception.ApplicationException;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
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
    private final UserCreateSage userCreateSage;

    @Override
    public Long createNewStats(String workflowId) {
        long id;
        try {
            id = statsClient.createNewStats().id();
        }catch (FeignException exception){
            userCreateSage.callThrownException(workflowId);
            throw new ApplicationException(exception.getMessage());
        }
        userCreateSage.setStats(workflowId, id);
        return id;
    }
}
