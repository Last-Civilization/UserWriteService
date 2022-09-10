package com.lastcivilization.userwriteservice.infrastructure.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("equipment-read-service")
interface EquipmentClient {

    @RequestMapping(method = RequestMethod.POST, value = "/equipments")
    Long createNewEquipment();
}
