package com.guardian.GuardianWorkflows;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserModule {

    public static void main(String[] args) {

    // Define the attribute definitions, how table is defined and differentiated
    AttributeDefinition idAttributeDefinition = AttributeDefinitiona.builder()
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

    KeySchemaElement firstNameKeySchemaElement = KeySchemaElement.builder()
            .attributeName("firstName")
            .keyType(KeyType.HASH)
            .build();

    KeySchemaElement lastNameKeySchemaElement = KeySchemaElement.builder()
            .attributeName("lastName")
            .keyType(KeyType.HASH)
            .build();

    KeySchemaElement positionKeySchemaElement = KeySchemaElement.builder()
            .attributeName("position")
            .keyType(KeyType.RANGE)
            .build();

    KeySchemaElement passwordKeySchemaElement = KeySchemaElement.builder()
            .attributeName("position")
            .keyType(KeyType.HASH)
            .build();

    // Define the table
    CreateTableRequest createTableRequest = CreateTableRequest.builder()
            .tableName("User")
            .attributeDefinitions(idAttributeDefinition, emailAttributeDefinition)
            .keySchema(idKeySchemaElement, emailKeySchemaElement, firstNameKeySchemaElement, lastNameKeySchemaElement, positionKeySchemaElement, passwordKeySchemaElement)
            .provisionedThroughput(
                    ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build()
            )
            .build();

    System.out.println(createTableRequest);

}