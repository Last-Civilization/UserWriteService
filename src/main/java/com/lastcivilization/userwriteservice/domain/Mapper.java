package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.view.UserModel;

final class Mapper {

    private Mapper(){
        throw new RuntimeException("You can not create instance of this class!");
    }

    static UserModel toDto(User user){
        return new UserModel(user.getId(), user.getKeycloakId(), user.getLogin(), user.getEmail(), user.getStats(), user.getEquipment(), user.getAccount());
    }
}
