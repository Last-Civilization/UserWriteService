package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import com.lastcivilization.userwriteservice.domain.view.UserModel;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;

public class UserService {

    private final StatsService statsService;
    private final EquipmentService equipmentService;
    private final PaymentService paymentService;
    private final UserRepository userRepository;
    private final UserCreateSage userCreateSage;

    public UserService(StatsService statsService, EquipmentService equipmentService, PaymentService paymentService, UserRepository userRepository,
                       UserCreateSage userCreateSage) {
        this.statsService = statsService;
        this.equipmentService = equipmentService;
        this.paymentService = paymentService;
        this.userRepository = userRepository;
        this.userCreateSage = userCreateSage;
    }

    public UserModel createUser(String login, String email, String keycloakId) {
        String workflowId = userCreateSage.startWorkflow();
        User user = buildUser(login, email, keycloakId);
        user.setEquipment(equipmentService.createNewEquipment(workflowId));
        user.setStats(statsService.createNewStats(workflowId));
        user.setAccount(paymentService.createNewAccount(workflowId));
        UserModel userModel = Mapper.toDto(user);
        return userRepository.save(userModel);
    }

    private User buildUser(String login, String email, String keycloakId) {
        return User.Builder.anUser()
                .login(login)
                .email(email)
                .keycloakId(keycloakId)
                .build();
    }
}
