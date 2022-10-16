package com.lastcivilization.userwriteservice.infrastructure.keycloak;

import com.lastcivilization.userwriteservice.infrastructure.keycloak.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
class KeycloakUnregisterAspect {

    private final KeycloakService keycloakService;

    @AfterThrowing("execution(* com.lastcivilization.userwriteservice.domain.UserService.createUser(..))")
    public void handleErrorWhileRegisterUser(JoinPoint joinPoint){
        keycloakService.deleteUser((String) joinPoint.getArgs()[2]);
    }

}
