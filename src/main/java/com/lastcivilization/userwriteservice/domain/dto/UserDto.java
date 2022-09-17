package com.lastcivilization.userwriteservice.domain.dto;

public record UserDto (
        long id,
        String keycloakId,
        String login,
        String email,
        Long stats,
        Long equipment,
        int money
){ }
