package tests.RestAssured;

import com.google.gson.reflect.TypeToken;
import domain.Pojos.PojoTest;
import domain.Pojos.PojoTestList;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeTest;
import tests.RestAssured.file.payLoad;
import tests.RestAssured.file.resource;
import utils.RestUtils.JsonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class GooglePlacesAPI {

    Properties prop = new Properties();

    @Before
    public void getHost() throws IOException {

        FileInputStream fis = new FileInputStream("/Users/alibaba/Public/testjavalabs/src/main/resources/config.properties");
        prop.load(fis);
    }

    @Test
    public void restAssuredTestGETWithGoogleAPI(){
        RestAssured.baseURI = "https://maps.googleapis.com/";
        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("key", "AIzaSyDplZlEH0YvpSysLGmdQjqwS5qLy_Nt8Jk").
                when().
                get("maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name", equalTo ("Sydney")).and().body("results[6].place_id", equalTo("ChIJ1-v38TauEmsRHbUt24abGq8")).
        and().header("Server", "scaffolding on HTTPServer2");
        }

        @Test
    public void restAssuredTestPOST(){
            RestAssured.baseURI = "https://maps.googleapis.com/";
            given().
                    queryParam("key", "AIzaSyDplZlEH0YvpSysLGmdQjqwS5qLy_Nt8Jk").
                    body("{"+
                            "\"location\": {"+
                            "\"lat\": -33.8669710,"+
                            "\"lng\": 151.1958750"+
                            "},"+
                            "\"accuracy\": 50,"+
                            "\"name\": \"Google Shoes!\","+
                            "\"phone_number\": \"(02) 9374 4000\","+
                            "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
                            "\"types\": [\"shoe_store\"],"+
                            "\"website\": \"http://www.google.com.au/\","+
                            "\"language\": \"en-AU\""+
                            "}").
                    when().
                    post("/maps/api/place/add/json").
                    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));
        }

        @Test
    public void restAssuredTestGETWithList(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
            Response res = given().
                    header("contentType", "application/json").
                    param("postId", "2").
                    when().
                    get(resource.placeGetDataForList()).
                    then().assertThat().statusCode(200).
                    extract().response();
            String response = res.asString();
            System.out.println(response);
            JsonPath js = new JsonPath(response);
            Type pojoTestList = new TypeToken<ArrayList<PojoTest>>(){}.getType();
            List<PojoTest> pt = JsonUtils.deserializeWithGson(response, pojoTestList);
            //PojoTest  pt = JsonUtils.deserializeWithGson(response, PojoTest.class);
                System.out.println(pt.get(1).getEmail());

        }

    @Test()
    public void restAssuredTestGETWithSingleObject() throws IOException {

        RestAssured.baseURI = prop.getProperty("HOST");
        Response res = given().
                header(prop.getProperty("HeaderKeyContentType"), prop.getProperty("HeaderValueContentType")).
                param("postId", "2").
                param("id", "6").
                when().
                get(resource.placeGetData()).
                then().assertThat().statusCode(200).
                extract().response();
        String response = res.asString();
        PojoTest[] pt = JsonUtils.deserializeWithGson(response, PojoTest[].class);
        for(int i=0; i<pt.length; i++) {
            System.out.println(pt[i].getBody());
        }

    }
        @Test
    public void restAssuredTestPOSTWithDifferentAPI(){
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                header("contentType", "application/json").
                body(payLoad.payLoad()).
                when().
                put("/posts/2").
                then().assertThat().statusCode(200);
        }

}
