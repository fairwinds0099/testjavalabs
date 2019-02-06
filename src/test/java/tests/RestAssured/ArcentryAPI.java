package tests.RestAssured;

import domain.Pojos.PojoArcentry;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static utils.RestUtils.JsonUtils.deserializeWithGson;

public class ArcentryAPI {


    @Test
    public void restAssuredGetWithArcentry() {
        RestAssured.baseURI = "https://arcentry.com/api/v1/doc/214cebfe-273c-4910-8967-5f16f7829059";
        Response response = given().
                header("contentType", "application/json").
                param("key", "fd96f8c17c3b4e373414591f9df16f6804c8598b204a7f8d178169d2d5e61e97").
                when().
                get();
        //then().assertThat().statusCode(200).
        //extract().response();
        //System.out.println(res);
        String res = response.asString();
        //System.out.println(res);
   // }
       // @Test
             //  public void deSerialize(){
        //String resp = "{\"id\":\"214cebfe-273c-4910-8967-5f16f7829059\",\"title\":\"my first document\",\"created\":\"2019-02-05T05:30:25.198Z\",\"lastChange\":\"2019-02-05T05:36:25.235Z\",\"user\":{\"id\":\"eb6093af-35cb-4e6a-9398-3e056ee3264c\",\"email\":\"aliisiklar@gmail.com\"},\"folder\":{\"id\":\"73b4dc65-9697-4d96-927d-178abb71cc46\",\"title\":\"my first folder\"}}";
        PojoArcentry pojoArcentry = deserializeWithGson(res, PojoArcentry.class);
        System.out.println(pojoArcentry.getTitle());
    }
}
