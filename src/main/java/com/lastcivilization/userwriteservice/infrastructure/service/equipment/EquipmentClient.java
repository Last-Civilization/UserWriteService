package com.lastcivilization.userwriteservice.infrastructure.service.equipment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "equipment-read-service", url = "${test.url:#{null}}")
public interface EquipmentClient {

    @PostMapping("/equipments")
    Equipment createNewEquipment();

    @DeleteMapping("/equipments/{id}")
    void deleteEquipment(@PathVariable long id);
}
