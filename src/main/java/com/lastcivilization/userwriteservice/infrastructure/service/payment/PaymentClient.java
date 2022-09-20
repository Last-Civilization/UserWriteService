package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "payment-read-service", url = "http://localhost:9561")
interface PaymentClient {

    @PostMapping("/payments")
    Payment createNewAccount();
}
