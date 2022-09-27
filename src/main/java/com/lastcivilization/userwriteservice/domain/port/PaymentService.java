package com.lastcivilization.userwriteservice.domain.port;

public interface PaymentService {

    Long createNewAccount();

    void deleteAccount(long id);
}
