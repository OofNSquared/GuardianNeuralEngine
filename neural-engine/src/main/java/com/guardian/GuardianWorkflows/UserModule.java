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

    public static HashMap<String, AttributeValue> createUserItem() {
        HashMap<String, AttributeValue> item = new HashMap<>();
        
        item.put("ID", AttributeValue.builder().n("1").build());
        item.put("email", AttributeValue.builder().s("test@example.com").build());
        //item.put("first_name", AttributeValue.builder().s("John").build());
        //item.put("last_name", AttributeValue.builder().s("Doe").build());
        //item.put("password", AttributeValue.builder().s("password123").build());
        //item.put("position", AttributeValue.builder().s("Developer").build());
        
        return item;
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