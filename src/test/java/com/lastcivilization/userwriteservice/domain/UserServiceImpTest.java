package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private UserServiceImp underTest;

    @Test
    void shouldCreateUser() {
        //given
        when(equipmentService.createNewEquipment()).thenReturn(0L);
        when(statsService.createNewStats()).thenReturn(0L);
        when(paymentService.createNewAccount()).thenReturn(0L);
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(userRepository).save(any(UserDto.class));
        UserDto expectedDto = buildUserDto();
        //when
        UserDto userDto = underTest.createUser(USER_LOGIN, USER_EMAIL, USER_KEYCLOAK_ID);
        //then
        assertThat(userDto).isEqualTo(expectedDto);
    }

    private UserDto buildUserDto() {
        return new UserDto(null, USER_KEYCLOAK_ID, USER_LOGIN, USER_EMAIL, 0L, 0L, 0L);
    }
}