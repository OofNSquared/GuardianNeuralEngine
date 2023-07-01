package com.guardian;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;

import static software.amazon.awssdk.services.dynamodb.DynamoDbClient.*;

//import software.amazon.awssdk.services.dynamodb.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DynamoDbClient dbClient = DynamoDbClient.create();
    }
}
