package com.lastcivilization.userwriteservice.domain.port;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;

public interface UserRepository {

    UserDto save(UserDto userDto);
}
