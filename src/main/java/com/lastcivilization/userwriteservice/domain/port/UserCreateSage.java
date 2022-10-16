package com.lastcivilization.userwriteservice.domain.port;

public interface UserCreateSage {

    String startWorkflow();

    String setEquipment(String workflowId, long id);

    String setStats(String workflowId, long id);

    String setAccount(String workflowId, long id);

    String callThrownException(String workflowId);
}
