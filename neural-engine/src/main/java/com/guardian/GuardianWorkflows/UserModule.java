package com.guardian.GuardianWorkflows;

import software.amazon.awssdk.services.dynamodb.model.*;

public class UserModule {

    public static void main(String[] args) {

    // Define the attribute definitions
    AttributeDefinition idAttributeDefinition = AttributeDefinitiona.builder()
            .attributeName("ID")
            .attributeType(ScalarAttributeType.N)
            .build();
    AttributeDefinition emailAttributeDefinition = AttributeDefinition.builder()
            .attributeName("email")
            .attributeType(ScalarAttributeType.S)
            .build();

    // Define the key schema elements
    KeySchemaElement idKeySchemaElement = KeySchemaElement.builder()
            .attributeName("ID")
            .keyType(KeyType.HASH)
            .build();

    // Define the table
    CreateTableRequest createTableRequest = CreateTableRequest.builder()
            .tableName("User")
            .attributeDefinitions(idAttributeDefinition, emailAttributeDefinition)
            .keySchema(idKeySchemaElement)
            .provisionedThroughput(
                    ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build()
            )
            .build();

    System.out.println(createTableRequest);

}