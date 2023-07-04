package com.guardian.GuardianWorkflows;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
// import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
// import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
// import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
// import software.amazon.awssdk.services.dynamodb.model.KeyType;
// import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
// import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import java.util.HashMap;
import java.util.Map;

public class UserModule {

        private CreateTableRequest userRequest;

    // Define the attribute definitions, how table is defined and differentiated
    AttributeDefinition idAttributeDefinition = AttributeDefinition.builder()
            .attributeName("ID")
            .attributeType(ScalarAttributeType.N)
            .build();
    AttributeDefinition emailAttributeDefinition = AttributeDefinition.builder()
            .attributeName("email")
            .attributeType(ScalarAttributeType.S)
            .build();

    // Define the key schema elements, additional elements
    KeySchemaElement idKeySchemaElement = KeySchemaElement.builder()
            .attributeName("ID")
            .keyType(KeyType.HASH)
            .build();

    KeySchemaElement emailKeySchemaElement = KeySchemaElement.builder()
            .attributeName("email")
            .keyType(KeyType.RANGE)
            .build();

    // KeySchemaElement firstNameKeySchemaElement = KeySchemaElement.builder()
    //         .attributeName("firstName")
    //         .keyType(KeyType.HASH)
    //         .build();

    // KeySchemaElement lastNameKeySchemaElement = KeySchemaElement.builder()
    //         .attributeName("lastName")
    //         .keyType(KeyType.HASH)
    //         .build();

    // KeySchemaElement positionKeySchemaElement = KeySchemaElement.builder()
    //         .attributeName("position")
    //         .keyType(KeyType.RANGE)
    //         .build();

    // KeySchemaElement passwordKeySchemaElement = KeySchemaElement.builder()
    //         .attributeName("position")
    //         .keyType(KeyType.HASH)
    //         .build();

    public static PutItemRequest addUserRequest(HashMap userItem) {
        return PutItemRequest.builder()
                                        .tableName("User")
                                        .item(userItem)
                                        .build();
    }

    public static GetItemRequest getUserRequest(HashMap keyItem) {
        return GetItemRequest.builder()
                                .tableName("User")
                                .key(keyItem)
                                .build();
    }
    
    public static HashMap getKeyMap() {
        HashMap<String, AttributeValue> keyToGet = new HashMap<String, AttributeValue>();
        keyToGet.put("ID", AttributeValue.builder().n("3").build());
        keyToGet.put("email", AttributeValue.builder().s("test3@example.com").build());
        return keyToGet;
    }

    public UserModule() {
        this.userRequest = createTableRequest;
    }

    public CreateTableRequest getUserRequest() {
        return this.userRequest;
    }

    // Define the table
    CreateTableRequest createTableRequest = CreateTableRequest.builder()
            .tableName("User")
            .attributeDefinitions(idAttributeDefinition, emailAttributeDefinition)
            .keySchema(idKeySchemaElement, emailKeySchemaElement)
            .provisionedThroughput(
                    ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build()
            )
            .build();


    //System.out.println(createTableRequest);
}