package tests.RestAssured;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GoogleRepresentativesAPI {

    @Test
    public void getRepresentativesFromGoogleAPI(){
        RestAssured.baseURI = "https://www.googleapis.com/civicinfo/v2";
                given().
                        param("key", "AIzaSyBG93DzJH5VvcaJsxj6GlH1DuSArilEyqc").
                        queryParam("address", "28 Southwind Aliso Viejo, CA ").
                 when().
                 get("/representatives").
                        then().assertThat().statusCode(200);

    }
}
