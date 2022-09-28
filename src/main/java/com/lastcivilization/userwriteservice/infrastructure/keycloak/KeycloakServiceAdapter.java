package com.lastcivilization.userwriteservice.infrastructure.keycloak;

import com.lastcivilization.userwriteservice.domain.port.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class KeycloakServiceAdapter implements KeycloakService {

    private final KeycloakProperties keycloakProperties;

    @Override
    public void deleteUser(String keycloakId) {
        Keycloak keycloak = buildKeyCloak();
        deleteResource(keycloakId,
                keycloak);
    }

    private Keycloak buildKeyCloak() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakProperties.getAuthUrl())
                .realm(keycloakProperties.getMasterRealm())
                .clientId(keycloakProperties.getClientId())
                .username(keycloakProperties.getUsername())
                .password(keycloakProperties.getPassword())
                .build();
    }

    private void deleteResource(String keycloakId, Keycloak keycloak) {
        RealmResource realmResource =
                keycloak.realm(keycloakProperties.getRealm());
        UsersResource usersResource = realmResource.users();
        usersResource.delete(keycloakId);
    }
}
