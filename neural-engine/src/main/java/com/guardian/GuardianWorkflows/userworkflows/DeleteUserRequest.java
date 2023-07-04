package com.guardian.GuardianWorkflows.userworkflows;

import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;

public class DeleteUserRequest extends UserRequests {

    public DeleteUserRequest(int id, String email) {
        super(id, email);
    }

    @Override
    public DeleteItemRequest request() {
        return DeleteItemRequest.builder()
                                    .tableName("User")
                                    .key(super.getKeyMap())
                                    .build();
    }

}