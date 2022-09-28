package com.lastcivilization.userwriteservice.infrastructure.logger;

import com.lastcivilization.userwriteservice.domain.port.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class LoggerAdapter implements Logger {


    @Override
    public void error(String message) {
        log.error(message);
    }
}
