package tests.RestAssured;

import com.google.gson.Gson;
import domain.Pojos.PojoJiraSessionID;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import tests.RestAssured.file.resource;
import utils.RestUtils.JsonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class JiraAPI {
    Properties prop = new Properties();
    @Before
    public void getHost() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/alibaba/Public/testjavalabs/src/main/resources/config.properties");
        prop.load(fis);
    }
    @Test
    public void getSessionID(){
    PojoJiraSessionID jsid = new PojoJiraSessionID();
    jsid.setUsername("alibaba");
    jsid.setPassword("ebru1980");
    //System.out.println(JsonUtils.serializeWithGson(jsid));
    RestAssured.baseURI = prop.getProperty("JIRAHOST");
    Response res =  given().
            header(prop.getProperty("HeaderKeyContentType"), prop.getProperty("HeaderValueContentType")).
            //header("atlassian.xsrf.token", "nocheck").
    //body(JsonUtils.serializeWithGson(jsid)).
            body(jsid).
    when().
    get(resource.jiraGetSessionID()).
    then().
    extract().response();
    String json = res.asString();
    System.out.println(json);
}
}
