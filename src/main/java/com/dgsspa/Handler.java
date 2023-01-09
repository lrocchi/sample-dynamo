package com.dgsspa;

import com.dgsspa.model.Transaction;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Handler {
    private final DynamoDbClient dynamoDbClient;

    public Handler() {
        dynamoDbClient = DependencyFactory.dynamoDbClient();
    }

    public void sendRequest() {
        // TODO: invoking the api calls using dynamoDbClient.

    }
    public List<Transaction> queryTable(String partition_id, String sort_id) {
        try {
            DynamoDbEnhancedClient enhancedClient = DependencyFactory.dynamoDbEnhancedClient();

            DynamoDbTable<Transaction> transactionTable = enhancedClient.table("Transaction", TableSchema.fromBean(Transaction.class));
            QueryConditional queryConditional = QueryConditional
                    .keyEqualTo(Key.builder()
                            .partitionValue(partition_id).sortValue(sort_id)
                            .build());

            // Get items in the table and write out the ID value.
            Iterator<Transaction> results = transactionTable.query(queryConditional).items().iterator();

            List<Transaction> result = new ArrayList<Transaction>();
            while (results.hasNext()) {
                Transaction rec = results.next();
                result.add(rec);
                System.out.println("The title of the movie is "+rec.getProcess_id());
                System.out.println("The movie information  is "+rec.getTarget_status());
            }
            return result;

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
    public Transaction putItem(Transaction item){
        DynamoDbEnhancedClient enhancedClient = DependencyFactory.dynamoDbEnhancedClient();
        //Transaction transactionRecord = new Transaction();
        try {
            DynamoDbTable<Transaction> transactionTable = enhancedClient.table("Transaction", TableSchema.fromBean(Transaction.class));


            transactionTable.putItem(item);
        }catch (DynamoDbException  e){
            System.err.println(e.getMessage());
            //System.exit(1);
        }
        System.out.println("Customer data added to the table with id INVIO_PEC");
        return item;
    }
}
