package com.lastcivilization.userwriteservice.infrastructure.keycloak;

import com.lastcivilization.userwriteservice.domain.dto.UserDto;
import com.lastcivilization.userwriteservice.utils.IntegrationBaseClass;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class KeycloakListenerTest extends IntegrationBaseClass{

    private static final String KEYCLOAK_ID = "d1ba60c5-97c1-4b54-b636-90541baef365";
    private static final String USERNAME = "test2";
    private static final String EMAIL = "test2@test.pl";

    @Test
    void shouldHandleUserCreateAccount() throws InterruptedException {
        //given
        rabbitTemplate.convertAndSend("keycloak.queue", "{\n" +
                "  \"@class\" : \"com.github.aznamier.keycloak.event.provider" +
                ".EventClientNotificationMqMsg\",\n" +
                "  \"time\" : 1659268118717,\n" +
                "  \"type\" : \"REGISTER\",\n" +
                "  \"realmId\" : \"TeamsFinder\",\n" +
                "  \"clientId\" : \"teamsfinder\",\n" +
                "  \"userId\" : \"" + KEYCLOAK_ID + "\",\n" +
                "  \"ipAddress\" : \"192.168.176.1\",\n" +
                "  \"details\" : {\n" +
                "    \"auth_method\" : \"openid-connect\",\n" +
                "    \"auth_type\" : \"code\",\n" +
                "    \"register_method\" : \"form\",\n" +
                "    \"last_name\" : \"test2\",\n" +
                "    \"redirect_uri\" : \"http://localhost:9090/login/oauth2" +
                "/code/keycloak\",\n" +
                "    \"first_name\" : \"test2\",\n" +
                "    \"code_id\" : \"64972a21-fc28-4b26-8b33-766908216b6e\"," +
                "\n" +
                "    \"email\" : \""+EMAIL+"\",\n" +
                "    \"username\" : \"" + USERNAME + "\"\n" +
                "  }\n" +
                "}");
        //when
        Thread.sleep(5000, 0);
        List<UserDto> users = userRepository.findAll();
        //then
        assertThat(users.stream().filter(user -> (Objects.equals(user.keycloakId(), KEYCLOAK_ID) && Objects.equals(user.login(), USERNAME)  && Objects.equals(user.email(), EMAIL)))).isNotEmpty();
    }
}