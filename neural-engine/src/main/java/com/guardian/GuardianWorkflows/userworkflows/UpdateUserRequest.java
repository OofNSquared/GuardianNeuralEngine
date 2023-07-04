package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

public class UpdateUserRequest {

    // FOR NOW, CAN ONLY UPDATE PASSWORD AND POSITION
    private int id;
    private String email;
    private String newPassword;
    private String newPosition;

    public UpdateUserRequest(int id, String email, String newPassword, String newPosition) {
        if (isNullOrBlank(email) || isNullOrBlank(newPassword) || isNullOrBlank(newPosition)) throw new IllegalArgumentException("fields cannot be null or blank");
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

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("new password cannot be null or blank");
        this.newPassword = newPassword;
    }

    public String getNewPosition() {
        return this.newPosition;
    }

    public void setNewPosition(String newPosition) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("new position cannot be null or blank");
        this.newPosition = newPosition;
    }


    private boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }

    public UpdateItemRequest request() {
        return UpdateItemRequest.builder()
                                .tableName("User")
                                .key(this.getKeyMap())
                                .updateExpression(this.updateExpressionString())
                                .build();
    }
    
    private HashMap<String, AttributeValue> getKeyMap() {
        HashMap<String, AttributeValue> keyToGet = new HashMap<String, AttributeValue>();
        keyToGet.put("ID", AttributeValue.builder().n(String.valueOf(this.id)).build());
        keyToGet.put("email", AttributeValue.builder().s(this.email).build());
        return keyToGet;
    }

    private String updateExpressionString() {
        return "SET: password=:" + this.newPassword + ", position=:" + this.newPosition;
    }

}