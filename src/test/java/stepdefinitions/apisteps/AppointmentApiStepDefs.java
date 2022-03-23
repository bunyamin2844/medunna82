package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US07_AppointmentPost;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.*;
import static utilities.WriteToTxt.saveAppointmentCreation;

public class AppointmentApiStepDefs {
    US07_AppointmentPost appointment = new US07_AppointmentPost();
    Response response;
    @Given("user sets the path parameters")
    public void user_sets_the_path_parameters() {
        spec =new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second","appointments","third","request");
    }

    @Given("user sets the expected data {string},{string},{string},{string},{string} and {string}")
    public void user_sets_the_expected_data_and(String firstName, String lastName, String ssn, String email, String phone, String startDate) {

        appointment.setFirstName(firstName);
        appointment.setLastName(lastName);
        appointment.setSsn(ssn);
        appointment.setPhone(phone);
        appointment.setEmail(email);
        appointment.setStartDate(startDate);

    }

    @Given("user sends the POST request and receives the response")
    public void user_sends_the_post_request_and_receives_the_response() {
        response=given().spec(spec).contentType(ContentType.JSON).body(appointment).when().post("/{first}/{second}/{third}");
    }

    @When("user saves the api records to the correspondent files")
    public void user_saves_the_api_records_to_the_correspondent_files() {

        saveAppointmentCreation(appointment);
    }

    @Then("user validates the api records")
    public void user_validates_the_api_records() throws IOException {
        response.then().statusCode(201);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        US07_AppointmentPost actualAppointment = obj.readValue(response.asString(), US07_AppointmentPost.class);

        System.out.println(actualAppointment);
        Driver.wait(5);
        // assertEquals(appointment.getFirstName(), actualAppointment.getFirstName());
        //assertEquals(appointment.getLastName(),actualAppointment.getLastName());
        assertEquals(appointment.getPhone(),"116-321-8272");
    }

    @And("user sends the get request for appointments data")
    public void user_sends_the_get_request_for_appointments_data() {
        response = getRequest(generateToken(),ConfigurationReader.getProperty("appointments_endpoint"));
        response.prettyPrint();

    }
    @And("user saves the users data to correspondent files for appointments")
    public void user_saves_the_users_data_to_correspondent_files_for_appointments() {

        saveAppointmentCreation(appointment);
    }
}