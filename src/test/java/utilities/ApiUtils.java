package utilities;


import io.restassured.http.ContentType;

import io.restassured.response.Response;
import pojos.TestItem;

import static io.restassured.RestAssured.given;

public class ApiUtils {


    public static Response postRequestTestItem(Object token, String endpoint, TestItem item){
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).body(item).when().post(endpoint);
        return  response;
    }



    public static Response getRequestTestItem(Object token, String endpoint){
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);
        return  response;
    }
}
