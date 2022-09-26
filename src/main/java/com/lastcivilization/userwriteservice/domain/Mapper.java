package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.view.UserModel;

class Mapper {

    static UserModel toDto(User user){
        return new UserModel(user.getId(), user.getKeycloakId(), user.getLogin(), user.getEmail(), user.getStats(), user.getEquipment(), user.getAccount());
    }
}
