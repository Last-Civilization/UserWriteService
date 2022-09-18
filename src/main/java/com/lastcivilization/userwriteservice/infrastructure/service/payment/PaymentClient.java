package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("payment-read-service")
interface PaymentClient {

    @PostMapping("/payments")
    Long createNewAccount();
}
