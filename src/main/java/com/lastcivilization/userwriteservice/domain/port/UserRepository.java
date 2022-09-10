package com.lastcivilization.userwriteservice.domain.port;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;

import java.util.List;

public interface UserRepository {

    UserDto save(UserDto userDto);

    List<UserDto> findAll();
}
