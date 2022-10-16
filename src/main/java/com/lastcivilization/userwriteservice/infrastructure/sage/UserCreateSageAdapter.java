package com.lastcivilization.userwriteservice.infrastructure.sage;

import com.lastcivilization.userwriteservice.domain.port.UserCreateSage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserCreateSageAdapter implements UserCreateSage {

    private final UserCreateSageClient userCreateSageClient;

    @Override
    public String startWorkflow(){
        return userCreateSageClient.startWorkflow();
    }

    @Override
    public String setEquipment(String workflowId, long id){
        return userCreateSageClient.setEquipment(workflowId, id);
    }

    @Override
    public String setStats(String workflowId, long id){
        return userCreateSageClient.setStats(workflowId, id);
    }

    @Override
    public String setAccount(String workflowId, long id){
        return userCreateSageClient.setAccount(workflowId, id);
    }

    @Override
    public String callThrownException(String workflowId){
        return userCreateSageClient.callThrownException(workflowId);
    }
}
