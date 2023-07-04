package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class CreateNewUserRequest {

    private String id;
    private String email;


    public CreateNewUserRequest(String id, String email) {
        if (isNullOrBlank(id) | isNullOrBlank(email)) throw new IllegalArgumentException("id and email cannot be null or blank");
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (isNullOrBlank(id)) throw new IllegalArgumentException("id cannot be null or blank");
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


    public HashMap<String, AttributeValue> request() {
        HashMap<String, AttributeValue> request = new HashMap<>();
        
        request.put("ID", AttributeValue.builder().n(this.id).build());
        request.put("email", AttributeValue.builder().s(this.email).build());
        //request.put("first_name", AttributeValue.builder().s("John").build());
        //request.put("last_name", AttributeValue.builder().s("Doe").build());
        //request.put("password", AttributeValue.builder().s("password123").build());
        //request.put("position", AttributeValue.builder().s("Developer").build());
        
        return request;
    }

}
