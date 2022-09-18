package com.lastcivilization.userwriteservice.infrastructure.database;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.lastcivilization.userwriteservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = MAPPER.toEntity(userDto);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return MAPPER.toDto(savedUserEntity);
    }

    @Override
    public List<UserDto> findAll() {
        return userJpaRepository.findAll()
                .stream().map(MAPPER::toDto)
                .collect(Collectors.toList());
    }
}
