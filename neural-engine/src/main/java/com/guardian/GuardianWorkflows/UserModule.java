package com.guardian.GuardianWorkflows;

import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;

public class UserModule {

    public static void main(String[] args) {

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
            .keyType(KeyType.HASH)
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

    System.out.println(createTableRequest);
    }

    public static Map<String, AttributeValue> createUserItem() {
        Map<String, AttributeValue> item = new HashMap<>();
        
        item.put("id", AttributeValue.builder().n("1").build());
        item.put("email", AttributeValue.builder().s("test@example.com").build());
        item.put("first_name", AttributeValue.builder().s("John").build());
        item.put("last_name", AttributeValue.builder().s("Doe").build());
        item.put("password", AttributeValue.builder().s("password123").build());
        item.put("position", AttributeValue.builder().s("Developer").build());
        
        return item;
    }

}