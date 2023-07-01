package com.guardian;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;
import software.amazon.awssdk.core.exception.SdkException;

import static software.amazon.awssdk.services.dynamodb.DynamoDbClient.*;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;

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
        DefaultCredentialsProvider cred = DefaultCredentialsProvider.create();
        System.out.println(cred.toString());
    }
}
