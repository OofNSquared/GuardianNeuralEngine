package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class CreateNewUserRequest {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String position;

    public CreateNewUserRequest(int id, String email, String firstName, String lastName, String password, String position) {
        if (isNullOrBlank(email) || isNullOrBlank(firstName) || isNullOrBlank(lastName) || isNullOrBlank(password) || isNullOrBlank(position)) throw new IllegalArgumentException("no entries can be null or blank");
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.position = position;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("first name cannot be null or blank");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("last name cannot be null or blank");
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("password cannot be null or blank");
        this.password = password;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("position name cannot be null or blank");
        this.position = position;
    }

    private boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }

    public PutItemRequest request() {
        HashMap<String, AttributeValue> request = new HashMap<>();
        
        request.put("ID", AttributeValue.builder().n(String.valueOf(this.id)).build());
        request.put("email", AttributeValue.builder().s(this.email).build());
        request.put("first_name", AttributeValue.builder().s(this.firstName).build());
        request.put("last_name", AttributeValue.builder().s(this.lastName).build());
        request.put("password", AttributeValue.builder().s(this.password).build());
        request.put("position", AttributeValue.builder().s(this.position).build());
        
        return PutItemRequest.builder()
                                .tableName("User")
                                .item(request)
                                .build();
    }

}
