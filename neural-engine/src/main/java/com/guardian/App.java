package com.guardian;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.CreateTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableResponse;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.regions.Region;

//import static software.amazon.awssdk.services.dynamodb.DynamoDbClient.*;

import com.guardian.GuardianWorkflows.UserModule;
import com.guardian.GuardianWorkflows.userworkflows.CreateNewUserRequest;

// import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
// import software.amazon.awssdk.regions.Region;

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

        UserModule user = new UserModule();
        CreateTableRequest req = user.getUserRequest();
        DynamoDbWaiter dbWaiter = dbClient.waiter();
        
        try {
            // CreateTableResponse response = dbClient.createTable(req);
            // DescribeTableRequest tableRequest = DescribeTableRequest.builder()
            //         .tableName("User")
            //         .build();

            // // Wait until the Amazon DynamoDB table is created
            // WaiterResponse<DescribeTableResponse> waiterResponse =  dbWaiter.waitUntilTableExists(tableRequest);
            // waiterResponse.matched().response().ifPresent(System.out::println);

            // String newTable = response.tableDescription().tableName();
            // System.out.println(newTable);
            CreateNewUserRequest user4CreateRequest = new CreateNewUserRequest(4, "test4@example.com");
            dbClient.putItem(UserModule.addUserRequest(user4CreateRequest.request()));
            System.out.println("Added successfully!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
}
