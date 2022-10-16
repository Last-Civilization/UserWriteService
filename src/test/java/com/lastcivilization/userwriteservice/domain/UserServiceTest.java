package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import com.lastcivilization.userwriteservice.domain.view.UserModel;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

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

    @Mock
    private UserCreateSage userCreateSage;

    @InjectMocks
    private UserService underTest;

    @Test
    void shouldCreateUser() {
        //given
        when(equipmentService.createNewEquipment(anyString())).thenReturn(0L);
        when(statsService.createNewStats(anyString())).thenReturn(0L);
        when(paymentService.createNewAccount(anyString())).thenReturn(0L);
        when(userCreateSage.startWorkflow()).thenReturn("workflowId");
        doAnswer(invocationOnMock -> invocationOnMock.getArgument(0)).when(userRepository).save(any(UserModel.class));
        UserModel expectedDto = buildUserDto();
        //when
        UserModel userModel = underTest.createUser(USER_LOGIN, USER_EMAIL, USER_KEYCLOAK_ID);
        //then
        assertThat(userModel).isEqualTo(expectedDto);
    }

    private UserModel buildUserDto() {
        return new UserModel(null, USER_KEYCLOAK_ID, USER_LOGIN, USER_EMAIL, 0L, 0L, 0L);
    }
}