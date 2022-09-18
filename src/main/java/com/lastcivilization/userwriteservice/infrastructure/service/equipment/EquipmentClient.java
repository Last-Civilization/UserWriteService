package com.lastcivilization.userwriteservice.infrastructure.service.equipment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("equipment-read-service")
interface EquipmentClient {

    @PostMapping("/equipments")
    Long createNewEquipment();
}
