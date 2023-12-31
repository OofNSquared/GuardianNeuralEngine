package com.guardian.GuardianWorkflows.userworkflows;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;

public class UpdateUserRequest extends UserRequests {

    // FOR NOW, CAN ONLY UPDATE PASSWORD AND POSITION
    private int id;
    private String email;
    private String newPassword;
    private String newPosition;

    public UpdateUserRequest(int id, String email, String newPassword, String newPosition) {
        super(id, email);
        if (isNullOrBlank(newPassword) || isNullOrBlank(newPosition)) throw new IllegalArgumentException("fields cannot be null or blank");
        this.newPassword = newPassword;
        this.newPosition = newPosition;
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

    @Override
    public UpdateItemRequest request() {
        HashMap<String, String> attributeNames = new HashMap<String, String>();
        attributeNames.put("#P", "position");
        attributeNames.put("#password", "password");

        HashMap<String, AttributeValue> attributeValues = new HashMap<String, AttributeValue>();
        attributeValues.put(":password", AttributeValue.builder().s(this.newPassword).build());
        attributeValues.put(":position", AttributeValue.builder().s(this.newPosition).build());

        return UpdateItemRequest.builder()
                                .tableName("User")
                                .key(super.getKeyMap())
                                .updateExpression(this.updateExpressionString())
                                .expressionAttributeNames(attributeNames)
                                .expressionAttributeValues(attributeValues)
                                .build();
    }

    private String updateExpressionString() {
        return "SET #password=:password, #P=:position";
    }

}