package com.lastcivilization.userwriteservice.domain.port;

import com.lastcivilization.userwriteservice.domain.view.UserModel;

import java.util.List;

public interface UserRepository {

    UserModel save(UserModel userModel);

    List<UserModel> findAll();
}
