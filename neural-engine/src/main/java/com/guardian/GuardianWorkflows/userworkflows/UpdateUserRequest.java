package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

public class UpdateUserRequest {

    private int id;
    private String email;

    public UpdateUserRequest(int id, String email) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("email cannot be null or blank");
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("email cannot be null or blank");
        this.email = email;
    }

    private boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }

    public UpdateItemRequest getUserRequest(HashMap<String, AttributeValue> keyItem) {
        return UpdateItemRequest.builder()
                                .tableName("User")
                                .key(this.getKeyMap())
                                .updateExpression(email)
                                .build();
    }
    
    private HashMap<String, AttributeValue> getKeyMap() {
        HashMap<String, AttributeValue> keyToGet = new HashMap<String, AttributeValue>();
        keyToGet.put("ID", AttributeValue.builder().n(String.valueOf(this.id)).build());
        keyToGet.put("email", AttributeValue.builder().s(this.email).build());
        return keyToGet;
    }

    p

}