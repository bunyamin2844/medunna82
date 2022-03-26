package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.RoomPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RoomStepDef {
    RoomPage roomPage = new RoomPage();
    Faker faker=new Faker();

    @Given("admin on the Login Medunna Page")
    public void admin_on_the_login_medunna_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @Given("admin enters username {string}")
    public void admin_enters_username(String string) {
        Driver.waitAndSendText(roomPage.username, string);

    }

    @Given("admin enters password  {string}")
    public void admin_enters_password(String string) {
        Driver.waitAndSendText(roomPage.password, string);
    }

    @Given("admin clicks sign in button")
    public void admin_clicks_sign_in_button() {
        Driver.waitAndClick(roomPage.sign);
    }

    @When("admin on the room click room button")
    public void admin_room_on_the_room_click_room_button() {
        Driver.waitAndClick(roomPage.clicksRoom);
    }

    @When("admin create a new room")
    public void admin_create_a_new_room() {
        Driver.waitAndClick(roomPage.createNewRoom);
    }

    @When("admin give a room number {string}")
    public void admin_give_a_room_number(String string) {
        Driver.waitAndSendText(roomPage.roomNumber, string);

    }

    @When("admin give a room type {string}")
    public void admin_give_a_room_type(String string) {
        Select select = new Select(roomPage.roomTypeDropdown);
        Driver.wait(2);
        select.selectByIndex(2);

    }

    @When("admin give status")
    public void admin_give_status() {
        Driver.waitAndClick(roomPage.checkbox);

    }

    @When("admin give a price {string}")
    public void admin_give_a_price(String string) {
        Driver.waitAndSendText(roomPage.price, string);
    }

    @When("admin give a description {string}")
    public void admin_give_a_description(String string) {
        Driver.waitAndSendText(roomPage.description, string);
    }

    @When("admin create date {string}")
    public void admin_create_date(String string) {
        Driver.waitAndSendText(roomPage.createdDate, string);

    }

    @When("admin save all")
    public void admin_save_all() {
        Driver.waitAndClick(roomPage.submitButton);

    }
    @Given("admin on the room edit page")
    public void admin_on_the_room_edit_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("admin_room_editPage"));
    }

    @Given("admin give a rooms numbers {string}")
    public void admin_give_a_rooms_numbers(String string) {
     // Driver.waitAndSendText(roomPage.roomNumber,string);
        Driver.wait(3);
        roomPage.roomNumber.sendKeys(faker.number().digits(3));
    }
    @Given("admin give a rooms types {string}")
    public void admin_give_a_rooms_types(String roomType) {
        Select select = new Select(roomPage.roomTypeDropdown);
        Driver.wait(2);
        select.selectByIndex(3);

    }
    @Given("admin give statuses clicks")
    public void admin_give_statuses_clicks() {
        Driver.waitAndClick(roomPage.checkbox);

    }
    @Given("admin give a prices {string}")
    public void admin_give_a_prices(String string) {

        Driver.waitAndSendText(roomPage.price,string);
    }
    @Given("admin give a descriptions {string}")
    public void admin_give_a_descriptions(String string) {
        Driver.waitAndSendText(roomPage.description,string);

    }
    @Given("admin creates dates {string}")
    public void admin_creates_dates(String string) {
        Driver.waitAndSendText(roomPage.createdDate,string);

    }
    @When("admin saves alls")
    public void admin_saves_alls() {
        Driver.waitAndClick(roomPage.submitButton);

    }
    @When("admin delete room")
    public void admin_delete_room() {
        Driver.waitAndClick(roomPage.delete);
    }
    @When("admin delete again")
    public void admin_delete_again() {
        Driver.waitAndClick(roomPage.delete1);
    }

    @Then("admin take success message")
    public void admin_take_success_message() {
        Assert.assertTrue(roomPage.deleteMessage.isDisplayed());
        //deneme
    }




}




