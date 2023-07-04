package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class CreateNewUserRequest {

    private int id;
    private String email;


    public CreateNewUserRequest(int id, String email) {
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


    public HashMap<String, AttributeValue> request(String firstName, String lastName, String password, String position) {
        HashMap<String, AttributeValue> request = new HashMap<>();
        
        request.put("ID", AttributeValue.builder().n(String.valueOf(this.id)).build());
        request.put("email", AttributeValue.builder().s(this.email).build());
        request.put("first_name", AttributeValue.builder().s(firstName).build());
        request.put("last_name", AttributeValue.builder().s(lastName).build());
        request.put("password", AttributeValue.builder().s(password).build());
        request.put("position", AttributeValue.builder().s(position).build());
        
        return request;
    }

}
