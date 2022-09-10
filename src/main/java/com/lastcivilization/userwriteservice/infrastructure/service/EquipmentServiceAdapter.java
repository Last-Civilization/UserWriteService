package com.lastcivilization.userwriteservice.infrastructure.service;

import com.lastcivilization.userwriteservice.domain.port.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class EquipmentServiceAdapter implements EquipmentService {

    private final EquipmentClient equipmentClient;
    @Override
    public Long createNewEquipment() {
        return equipmentClient.createNewEquipment();
    }
}
