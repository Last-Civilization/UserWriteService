package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PaymentServiceAdapter implements PaymentService {

    private final PaymentClient paymentClient;

    @Override
    public Long createNewAccount() {
        return paymentClient.createNewAccount().id();
    }
}
