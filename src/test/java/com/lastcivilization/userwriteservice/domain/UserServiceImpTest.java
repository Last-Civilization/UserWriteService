package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import com.lastcivilization.userwriteservice.domain.port.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    private static final String USER_LOGIN = "LOGIN";
    private static final String USER_EMAIL = "EMAIL";
    private static final String USER_KEYCLOAK_ID = "KEYCLOAK_ID";

    @Mock
    private EquipmentService equipmentService;
    @Mock
    private StatsService statsService;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp underTest;

    @Test
    void createUser() {
        //given
        when(equipmentService.createNewEquipment()).thenReturn(0L);
        when(statsService.createNewStats()).thenReturn(0L);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(userRepository).save(any(UserDto.class));
        //when
        UserDto userDto = underTest.createUser(USER_LOGIN, USER_EMAIL, USER_KEYCLOAK_ID);
        //then
        assertThat(userDto.getLogin()).isEqualTo(USER_LOGIN);
        assertThat(userDto.getEmail()).isEqualTo(USER_EMAIL);
        assertThat(userDto.getKeycloakId()).isEqualTo(USER_KEYCLOAK_ID);
        assertThat(userDto.getEquipment()).isEqualTo(0L);
        assertThat(userDto.getStats()).isEqualTo(0L);
    }
}