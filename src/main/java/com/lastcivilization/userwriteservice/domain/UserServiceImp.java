package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import com.lastcivilization.userwriteservice.domain.port.UserService;

public class UserServiceImp implements UserService {

    private final StatsService statsService;
    private final EquipmentService equipmentService;
    private final UserRepository userRepository;

    public UserServiceImp(StatsService statsService, EquipmentService equipmentService, UserRepository userRepository) {
        this.statsService = statsService;
        this.equipmentService = equipmentService;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(String login, String email, String keycloakId) {
        User user = buildUser(login, email, keycloakId);
        user.setEquipment(equipmentService.createNewEquipment());
        user.setStats(statsService.createNewStats());
        UserDto userDto = Mapper.toDto(user);
        return userRepository.save(userDto);
    }

    private User buildUser(String login, String email, String keycloakId) {
        return User.Builder.anUser()
                .login(login)
                .email(email)
                .keycloakId(keycloakId)
                .build();
    }
}
