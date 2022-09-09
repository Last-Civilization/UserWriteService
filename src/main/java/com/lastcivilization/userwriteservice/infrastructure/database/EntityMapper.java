package com.lastcivilization.userwriteservice.infrastructure.database;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}
