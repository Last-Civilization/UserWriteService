package com.lastcivilization.userwriteservice.infrastructure.database;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.lastcivilization.userwriteservice.infrastructure.database.EntityMapper.MAPPER;

@Component
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = MAPPER.toEntity(userDto);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return MAPPER.toDto(savedUserEntity);
    }
}
