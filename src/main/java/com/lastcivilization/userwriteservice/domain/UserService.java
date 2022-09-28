package com.lastcivilization.userwriteservice.domain;

import com.lastcivilization.userwriteservice.domain.exception.ApplicationException;
import com.lastcivilization.userwriteservice.domain.port.KeycloakService;
import com.lastcivilization.userwriteservice.domain.port.Logger;
import com.lastcivilization.userwriteservice.domain.view.UserModel;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.PaymentService;
import com.lastcivilization.userwriteservice.domain.port.StatsService;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;

public class UserService{

    private final StatsService statsService;
    private final EquipmentService equipmentService;
    private final PaymentService paymentService;
    private final UserRepository userRepository;
    private final KeycloakService keycloakService;
    private final Logger logger;

    public UserService(StatsService statsService, EquipmentService equipmentService, PaymentService paymentService, UserRepository userRepository,
                       KeycloakService keycloakService, Logger logger) {
        this.statsService = statsService;
        this.equipmentService = equipmentService;
        this.paymentService = paymentService;
        this.userRepository = userRepository;
        this.keycloakService = keycloakService;
        this.logger = logger;
    }

    public UserModel createUser(String login, String email, String keycloakId) {
        User user = buildUser(login, email, keycloakId);
        try{
            user.setEquipment(equipmentService.createNewEquipment());
            user.setStats(statsService.createNewStats());
            user.setAccount(paymentService.createNewAccount());
            UserModel userModel = Mapper.toDto(user);
            return userRepository.save(userModel);
        } catch (ApplicationException exception){
            try{
                equipmentService.deleteEquipment(user.getEquipment());
            } catch (Exception deleteEquipmentException){
                logger.error(deleteEquipmentException.getMessage());
            }
            try{
                statsService.deleteStats(user.getStats());
            } catch (Exception deleteStatsException){
                logger.error(deleteStatsException.getMessage());
            }
            try{
                paymentService.deleteAccount(user.getAccount());
            } catch (Exception deleteAccountException){
                logger.error(deleteAccountException.getMessage());
            }
            try{
                keycloakService.deleteUser(keycloakId);
            } catch (Exception deleteUserException){
                logger.error(deleteUserException.getMessage());
            }
        }
        return null;
    }

    private User buildUser(String login, String email, String keycloakId) {
        return User.Builder.anUser()
                .login(login)
                .email(email)
                .keycloakId(keycloakId)
                .build();
    }
}
