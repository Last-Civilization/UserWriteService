package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import com.lastcivilization.userwriteservice.domain.exception.ApplicationException;
import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PaymentServiceAdapter implements PaymentService {

    private final PaymentClient paymentClient;
    private final UserCreateSage userCreateSage;

    @Override
    public Long createNewAccount(String workflowId) {
        long id;
        try {
            id = paymentClient.createNewAccount().id();
        } catch (FeignException exception){
            userCreateSage.callThrownException(workflowId);
            throw new ApplicationException(exception.getMessage());
        }
        userCreateSage.setAccount(workflowId, id);
        return id;
    }
}
