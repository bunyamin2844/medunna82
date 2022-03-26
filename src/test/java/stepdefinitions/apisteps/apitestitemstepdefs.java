package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.TestItem;
import utilities.ConfigurationReader;
import java.io.IOException;
import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtils.getRequestTestItem;
import static utilities.ApiUtils.postRequestTestItem;
import static utilities.Autentication.generateToken;
import static utilities.WriteToTxt.saveTestItemData;

public class apitestitemstepdefs {

    Faker faker = new Faker();
    TestItem testitemobject = new TestItem();
    Response response;




    @Given("Given user sets the necessary path params")
    public void given_user_sets_the_necessary_path_params() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();

        spec.pathParams("first", "api", "second", "c-test-items");

    }
    @And("user sets the expected data {string} {string} {string} {string} {string}")
    public void userSetsTheExpectedData(String name, String description, String defaultValMin, String defaultValMax, String createdDate) {


        // name=faker.name().name();
        //    createdDate=new SimpleDateFormat("dd/mm/yyyy hh:mm").format(new Date());


        testitemobject.setName(name);
        testitemobject.setDescription(description);
        testitemobject.setDefaultValMin(defaultValMin);
        testitemobject.setDefaultValMax(defaultValMax);
        testitemobject.setCreatedDate(createdDate);

    }
    @And("user sends the POST request and gets the response for test items")

    public void user_sends_the_post_request_and_gets_the_response_for_test_items() {


        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        //  response=  given().spec(spec).auth().basic("alexxela","Karaca5506").contentType(ContentType.JSON).body(testitemobject).when().post("/{first}/{second}");

        postRequestTestItem(generateToken(), ConfigurationReader.getProperty("test_item_endpoint") ,testitemobject );
       // getRequestTestItem(generateToken(),ConfigurationReader.getProperty("test_item_endpoint"));
    }

    @And("user get the datas")
    public void userGetTheDatas() {


        response=   given().spec(spec).auth().basic("alexxela","Karaca5506").contentType(ContentType.JSON).when().get("/{first}/{second}");


    }
    @And("user saves the api records to correspondent files  for test items")
    public void user_saves_the_api_records_to_correspondent_files_for_test_items() {




        saveTestItemData(testitemobject);

    }
    @Then("user validates api records  for test items")
    public void user_validates_api_records_for_test_items() throws IOException {

     response.prettyPrint();
        response.then().statusCode(201);

        ObjectMapper obj =new ObjectMapper();

        TestItem testitemactualdata =obj.readValue(response.asString(),TestItem.class);

        Assert.assertEquals(testitemobject.getName(),testitemactualdata.getName());
        Assert.assertEquals(testitemobject.getPrice(),testitemactualdata.getPrice());
        Assert.assertEquals(testitemobject.getCreatedDate(),testitemactualdata.getCreatedDate());
        Assert.assertEquals(testitemobject.getDefaultValMin(),testitemactualdata.getDefaultValMin());
        Assert.assertEquals(testitemobject.getDefaultValMax(),testitemactualdata.getDefaultValMax());
    }



}
