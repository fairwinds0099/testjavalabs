package utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class noSqlDao {


    AWSCredentials credentials = new PropertiesCredentials(noSqlDao.class.getResourceAsStream("AwsCredentials.properties"));
    client =new

    AmazonDynamoDBClient(credentials);

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withRegion(Regions.US_EAST_1)
            .build();

    @Test
    public void createValues() {

        Map<String, AttributeValue> repAlabama1 = new HashMap<String, AttributeValue>();
        repAlabama1.put("name", "Bradley")


    }
}
