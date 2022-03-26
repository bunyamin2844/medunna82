package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SettingsPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SettingsPageSteps {
    SettingsPage settingsPage=new SettingsPage();
    @Given("user on the Medunna Page")
    public void user_on_the_medunna_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));

    }
    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        Driver.waitAndSendText(settingsPage.username,string);
    }
    @Given("user enters password  {string}")
    public void user_enters_password(String string) {
        Driver.waitAndSendText(settingsPage.password,string);

    }
    @Given("user clicks sign in button.")
    public void user_clicks_sign_in_button() {
        Driver.waitAndClick(settingsPage.signInButton);

    }
    @Given("user on settings page")
    public void user_on_settings_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("app_settinsPage"));
    }

    @When("user entry firstname {string}")
    public void user_entry_firstname(String string) {
        Driver.waitAndSendText(settingsPage.firstName,string);
    }
    @When("user entry lastname {string}")
    public void user_entry_lastname(String string) {
        Driver.waitAndSendText(settingsPage.lastName,string);
    }
    @When("user entry email {string}")
    public void user_entry_eemail(String string) {
        Driver.waitAndSendText(settingsPage.email,string);
    }

    @When("user entry FirstName {string}")
    public void user_entry_first_name(String string) {
        Driver.waitAndSendText(settingsPage.firstName,string);
    }
    @When("user entry LastName {string}")
    public void user_entry_last_name(String string) {
       Driver.waitAndSendText(settingsPage.lastName,string);
    }
    @When("user entry Email {string}")
    public void user_entry_email(String string) {
        Driver.waitAndSendText(settingsPage.email,string);
    }
    @Then("user clicks save button")
    public void user_clicks_save_button() {
        settingsPage.saveButton.click();
    }
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));

    }



}
