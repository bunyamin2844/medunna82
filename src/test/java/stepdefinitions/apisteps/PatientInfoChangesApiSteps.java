package stepdefinitions.apisteps;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.PatientApi;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static utilities.ApiUtils.postRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.savePatientData;

public class PatientInfoChangesApiSteps {

    Response response;
    Map<String,Object> expectedData;

    @Given("user set the necessary path params")
    public void userSetTheNecessaryPathParams() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("medunna_login_url")).build();

        spec.pathParams("first","api","second","patients","third","1051");
    }


    @Given("user send the GET request for getting data")
    public void userSendTheGETRequestForGettingData() throws Exception{


        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(ConfigurationReader.getProperty("patient1051_endpoint"));

        response.prettyPrint();

    }
    @And("user sets the expected data")
    public void userSetsTheExpectedDataAnd() {
        expectedData = new HashMap<>();

        expectedData.put("firstName","Aysun");
        expectedData.put("lastName","Yayaci");
        expectedData.put("email","aysun@hotmail.com");
}

    @And("user validates the edited data")
    public void userValidatesTheEditedData() {
        Map<String,Object> actualData = response.as(HashMap.class);

        Map<String,Object> expectedData = new HashMap<>();

        expectedData.put("firstName","Aysun");
        expectedData.put("lastName","Yayaci");
        expectedData.put("email","aysun@hotmail.com");


        assertEquals(actualData.get("firstName"),expectedData.get("firstName"));
        assertEquals(actualData.get("lastName"),expectedData.get("lastName"));
        assertEquals(actualData.get("email"),expectedData.get("email"));

    }


}
