package com.lastcivilization.userwriteservice.infrastructure.service.equipment;

import com.lastcivilization.userwriteservice.domain.exception.ApplicationException;
import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import com.lastcivilization.userwriteservice.infrastructure.service.equipment.EquipmentClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EquipmentServiceAdapter implements EquipmentService {

    private final EquipmentClient equipmentClient;
    private final UserCreateSage userCreateSage;

    @Override
    public Long createNewEquipment(String workflowId) {
        long id;
        try{
            id = equipmentClient.createNewEquipment().id();
        } catch (FeignException exception){
            userCreateSage.callThrownException(workflowId);
            throw new ApplicationException(exception.getMessage());
        }
        userCreateSage.setEquipment(workflowId, id);
        return id;
    }
}
