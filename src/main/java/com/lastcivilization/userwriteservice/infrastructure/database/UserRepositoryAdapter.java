package com.lastcivilization.userwriteservice.infrastructure.database;

import com.lastcivilization.userwriteservice.domain.view.UserModel;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.lastcivilization.userwriteservice.infrastructure.database.EntityMapper.MAPPER;

@Service
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserModel save(UserModel userModel) {
        UserEntity userEntity = MAPPER.toEntity(userModel);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return MAPPER.toDto(savedUserEntity);
    }

    @Override
    public List<UserModel> findAll() {
        return userJpaRepository.findAll()
                .stream().map(MAPPER::toDto)
                .collect(Collectors.toList());
    }
}
