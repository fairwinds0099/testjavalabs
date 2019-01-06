package tests.RestAssured.file;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class reusableMethods {
    public JsonPath rawToJson(Response res){

            String response = res.asString();
            //System.out.println(response);
            JsonPath js = new JsonPath(response);
            return js;
    }

}
