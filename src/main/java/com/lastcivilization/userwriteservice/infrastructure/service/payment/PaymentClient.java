package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "payment-read-service", url = "${test.url:#{null}}")
public interface PaymentClient {

    @PostMapping("/payments")
    Payment createNewAccount();
}
