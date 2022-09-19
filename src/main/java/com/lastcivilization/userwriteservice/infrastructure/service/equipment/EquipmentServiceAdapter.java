package com.lastcivilization.userwriteservice.infrastructure.service.equipment;

import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import com.lastcivilization.userwriteservice.infrastructure.service.equipment.EquipmentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile({"dev", "prod"})
class EquipmentServiceAdapter implements EquipmentService {

    private final EquipmentClient equipmentClient;
    @Override
    public Long createNewEquipment() {
        return equipmentClient.createNewEquipment().id();
    }
}
