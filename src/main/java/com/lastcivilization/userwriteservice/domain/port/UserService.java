package com.lastcivilization.userwriteservice.domain.port;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;

public interface UserService {

    UserDto createUser(String login, String email, String keycloakId);
}
