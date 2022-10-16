package com.lastcivilization.userwriteservice.infrastructure.sage;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "user-create-sage", url = "${test.url:#{null}}")
interface UserCreateSageClient {

    @GetMapping("/users/workflows")
    String startWorkflow();

    @PutMapping("/users/workflows/{workflowId}/equipments/{id}")
    String setEquipment(@PathVariable String workflowId, @PathVariable long id);

    @PutMapping("/users/workflows/{workflowId}/stats/{id}")
    String setStats(@PathVariable String workflowId, @PathVariable long id);

    @PutMapping("/users/workflows/{workflowId}/accounts/{id}")
    String setAccount(@PathVariable String workflowId, @PathVariable long id);

    @PutMapping("/users/workflows/{workflowId}/exceptions")
    String callThrownException(@PathVariable String workflowId);

}
