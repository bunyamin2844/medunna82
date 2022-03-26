package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Autentication {

   static RequestSpecification spec;
    static Response response;

    public static void main(String[] args) {
        generateToken();

    }

    public static Object generateToken() {




        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();

        spec.pathParams("first","api","second","authenticate");

        Map<String,Object> expecteddata = new HashMap<>();

        expecteddata.put("username","alexxela");
        expecteddata.put("password","Karaca5506");
        expecteddata.put("rememberMe",true);

     response=   given().spec(spec).contentType(ContentType.JSON).body(expecteddata).when().post("/{first}/{second}");

    // response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        System.out.println(actualData.get("id_token"));

return actualData.get("id_token");

    }
}