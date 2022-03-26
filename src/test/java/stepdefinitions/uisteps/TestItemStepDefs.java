package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.TestItempage;
import pojos.TestItem;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.WriteToTxt.saveTestItemData;

public class TestItemStepDefs {

   TestItempage testitem=new TestItempage();
    TestItem testitemobject = new TestItem();
    Faker faker=new Faker();

    @Given("users is on the login page")
    public void users_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }
    @And("user enters in {string} {string} and clicks save button")
    public void user_enters_in_and_clicks_save_button(String username, String password) {

        Driver.waitAndSendText(testitem.usernameTextbox,username);
        Driver.waitAndSendText(testitem.passwordTextbox,password);
        Driver.waitAndClick(testitem.saveButton);


    }
    @And("user clicks on ItemsTitles")
    public void user_clicks_on_items_titles() {

        Driver.waitAndClick(testitem.itemstitlesButton);

    }
    @And("user clicks on Test Item")
    public void user_clicks_on_test_item() {

        Driver.waitAndClick(testitem.testitembutton);

    }
    @And("user clicks on Create a New Test Item button")
    public void user_clicks_on_create_a_new_test_item_button() {

        Driver.waitAndClick(testitem.createanitemButtom);

    }
    @And("user enter name {string}")
    public void user_enter_name(String name) {

        name =faker.name().name();
        testitemobject.setName(name);

        Driver.waitAndSendText(testitem.testitemName,name);



    }
    @And("user enters description {string}")
    public void user_enters_description(String description) {

        testitemobject.setDescription(description);

        Driver.waitAndSendText(testitem.testitemDescription,description);

    }
    @And("user enters price {string}")
    public void user_enters_price(String price) {

        testitemobject.setPrice(price);

        Driver.waitAndSendText(testitem.testitemPrice,price);

    }
    @And("user enters Default Min. Value {string}")
    public void user_enters_default_min_value(String minvalue) {

        testitemobject.setDefaultValMin(minvalue);

        Driver.waitAndSendText(testitem.testitemdefaultValMin,minvalue);



    }
    @And("user enters Default Max. Value {string}")
    public void user_enters_default_max_value(String maxvalue) {

        testitemobject.setDefaultValMax(maxvalue);

        Driver.waitAndSendText(testitem.testitemdefaultValMax,maxvalue);

    }
    @And("user enters the day and time {string}")
    public void user_enters_the_day_and_time(String date) {

       // date = new SimpleDateFormat("yyyyMMddhh").format(new Date());
      //  date=faker.date();

        testitemobject.setCreatedDate(date);

        Driver.waitAndSendText(testitem.testitemcreateDate,date);

    }
    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {

        Driver.waitAndClick(testitem.testitemSaveButton);

    }

    @Then("user validates that creation a test item is succesful")
    public void user_validates_that_creation_a_test_item_is_succesful() {

        Assert.assertTrue(Driver.waitForVisibility(testitem.toastcontainer,5).isDisplayed());

    }

}
