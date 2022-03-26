package stepdefinitions.apisteps;
import org.checkerframework.checker.units.qual.C;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;


import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

import static Hooks.Hooks.spec;
import static utilities.WriteToTxt.saveRegistrantData;

public class RegistrantApiSteps  {

  Registrant registrant = new Registrant();
    Faker faker = new Faker();
    Response response;
import io.cucumber.java.tr.Fakat;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Registrant;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveRegistrantData;
import static Hooks.Hooks.spec;
public class RegistrantApiSteps  {

    Registrant registrant = new Registrant();
    Faker faker = new Faker();
    Response response;
    Registrant []registrants;

    @Given("user sets the necessary path params")
    public void user_sets_the_necessary_path_params() {

        spec.pathParams("first", "api", "second", "register");

    }
    @Given("user sets the expected data {string}, {string} {string} {string} {string} {string} and {string}")
    public void user_sets_the_expected_data_and(String firstname, String lastname, String ssn, String email, String username, String password, String lan) {

        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        username = faker.name().username();
        password = faker.internet().password(8, 15, true, true);

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(ssn);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
        registrant.setLangKey(lan);
//        Map<String ,Object> expectedData = new HashMap<>();
//        expectedData.put("firstName", firstname);

    }
    @Given("user sends the POST request and gets the response")
    public void user_sends_the_post_request_and_gets_the_response() {



        response = given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
    }
    @When("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files() {



    @When("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files()
    {

        saveRegistrantData(registrant);
    }
    @Then("user validates api records")
    public void user_validates_api_records() throws  Exception{
        response.then().statusCode(201);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();

        Registrant actualRegistrant = obj.readValue(response.asString(), Registrant.class);

        System.out.println(actualRegistrant);

        assertEquals(registrant.getLogin(), actualRegistrant.getLogin());
        assertEquals(registrant.getEmail(), actualRegistrant.getEmail());

        assertEquals(registrant.getFirstName(), actualRegistrant.getFirstName());
        assertEquals(registrant.getLastName(), actualRegistrant.getLastName());
        assertEquals(registrant.getSsn(), actualRegistrant.getSsn());


    }




    @Given("user sends the get request for users data")
    public void user_sends_the_get_request_for_users_data() {


        response = getRequest(generateToken(), ConfigurationReader.getProperty("api_appointments"));

        //This can be also used
        /*
        response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);
         */


    }

    }


=======
>>>>>>> origin/ibrahim
}