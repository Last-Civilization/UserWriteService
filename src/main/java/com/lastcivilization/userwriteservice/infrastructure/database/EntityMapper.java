package com.lastcivilization.userwriteservice.infrastructure.database;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}
