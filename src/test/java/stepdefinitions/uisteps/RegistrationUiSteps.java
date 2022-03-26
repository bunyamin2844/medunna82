package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;

import static utilities.ReusableMethods.getScreenshot;
import static utilities.WriteToTxt.saveRegistrantData;


public class RegistrationUiSteps {

    RegistrationPage registration = new RegistrationPage();
   Registrant registrant = new Registrant();
    Faker faker = new Faker();
    RegistrationPage rp = new RegistrationPage();


    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {


        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }

    @Given("user sends data for the SSN {string}")
    public void user_sends_data_for_the_ssn(String ssn) throws Exception {

        // Driver.waitAndSendText(registration.ssnTextbox,ssn);

        ssn = faker.idNumber().ssnValid();
        Driver.waitAndSendText(registration.ssnTextbox, ssn);

    }

    @Given("user sends data for the FirstName {string}")
    public void user_sends_data_for_the_first_name(String firstname) throws Exception {
        firstname = faker.name().firstName();
        registrant.setFirstName(firstname);
        Driver.waitAndSendText(registration.firstnameTextbox, firstname);
    }

    @Given("user sends data for the LastName {string}")
    public void user_sends_data_for_the_last_name(String lastname) throws Exception {
        lastname = faker.name().lastName();
        registrant.setLastName(lastname);
        Driver.waitAndSendText(registration.lastnameTextbox, lastname);

    }

    @Given("user sends data for the Username {string}")
    public void user_sends_data_for_the_username(String username) throws Exception {

        username = registrant.getFirstName() + registrant.getLastName();
        Driver.waitAndSendText(registration.usernameTextbox, username);
    }


    @Given("user sends data for the Email {string}")
    public void user_sends_data_for_the_email(String email) {

        email = faker.internet().emailAddress();
        Driver.waitAndSendText(registration.emaiTextbox, email);
    }

    @Given("user sends data for the Email without @ sign and .com extension {string}")
    public void user_sends_data_for_the_email_without_sign_and_com_extension(String string) {

        Driver.waitAndSendText(registration.emaiTextbox, string);

    }

    @Given("user sends data for the blank Email {string}")
    public void user_sends_data_for_the_blank_email(String string) {

        Driver.waitAndSendText(registration.emaiTextbox, string);

    }

    //Mr.Necip



    @Then("user clicks on the register")
    public void user_clicks_on_the_register() {
        Driver.waitAndClick(registration.registerButton);
    }


    @Then("user clicks on the register button and see the success message as {string}")
    public void user_clicks_on_the_register_button_and_see_the_success_message_as(String string) {
        Driver.waitAndClick(registration.registerButton);
        Driver.wait(2);
        //Assert.assertTrue(registration.successMessageToastContainer.isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(registration.successMessageToastContainer, 5).isDisplayed());
    }

    @Then("user takes screenshot of successful login")
    public void user_takes_screenshot_of_successful_login() throws IOException {
        getScreenshot("success message");
    }

    @Then("user takes screenshot of unsuccessful login due to failed email")
    public void user_takes_screenshot_of_unsuccessful_login_due_to_failed_email() throws IOException {

        getScreenshot("unsuccessful login due to email");
    }


    @Then("user creates the records to a correspondent file")
    public void user_creates_the_records_to_a_correspondent_file() {

        saveRegistrantData(registrant);
    }

    @Given("user provides ssn id {string}")
    public void user_provides_ssn_id(String ssn) {
        ssn = faker.idNumber().ssnValid();
        registrant.setSsn(ssn);
        Driver.waitAndSendText(rp.ssnTextbox, ssn);
    }

    @Given("user provides firstname and lastname {string} and {string}")
    public void user_provides_firstname_and_lastname_and(String firstName, String lastName) {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        registrant.setFirstName(firstName);
        registrant.setLastName(lastName);
        Driver.waitAndSendText(rp.firstnameTextbox, firstName);
        Driver.waitAndSendText(rp.lastnameTextbox, lastName);
    }

    @Then("user creates username {string}")
    public void user_creates_username(String userName) {
        userName = registrant.getFirstName() + registrant.getLastName();
        Driver.waitAndSendText(rp.usernameTextbox, userName);
    }

    @Then("user provides also email {string}")
    public void user_provides_also_email(String email) {
        email = faker.internet().emailAddress();
        registrant.setEmail(email);
        Driver.waitAndSendText(rp.emaiTextbox, email);
    }

    @Then("user provides the password {string}")
    public void user_generates_the_password(String password) {
        password = faker.internet().password(8, 20, true, true);
        registrant.setPassword(password);
        Driver.waitAndSendText(rp.passwordTextbox, password);
        Driver.waitAndSendText(rp.passwordConfirmationTextbox, password);
    }

    @Then("user registers and validates")
    public void user_registers_and_validates() {
        Driver.waitAndClick(rp.registerButton);
        Assert.assertTrue(Driver.waitForVisibility(rp.successMessageToastContainer, 3).isDisplayed());
    }

    @Then("user validates the password strength {string}")
    public void user_validates_the_password_strength(String level) {
        if(1==Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength1.isDisplayed());
        }else if(2==Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength2.isDisplayed());
        }else if (3==Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength3.isDisplayed());
        }
    }





    @Then("verify the SSN number is valid")
    public void userVerifiesTheSSNNumberIsValid() {
        rp.firstnameTextbox.click();
        try {
            Assert.assertFalse(rp.ssnInvalidMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @And("leave the SSN box blank")
    public void leaveTheSSNBoxBlank() {
        rp.ssnTextbox.sendKeys("");
    }
    @Then("verify SSN required message is displayed")
    public void verifySSNRequiredMessageIsDisplayed() {
        rp.firstnameTextbox.click();
        try {
            Assert.assertTrue(rp.ssnRequiredMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(false);
        }
    }
    @And("enter nine digit SSN without - ssn {string}")
    public void enterNineDigitSSNWithoutSsn(String ssn) {
        rp.ssnTextbox.sendKeys(ssn);
    }
    @Then("verify the SSN invalid message is displayed")
    public void verifyTheSSNInvalidMessageIsDisplayed() {
        rp.firstnameTextbox.click();
        try{
            Assert.assertTrue(rp.ssnInvalidMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(false);
        }
    }
    @And("enter eight digit SSN {string}")
    public void userShouldEnterEightDigitSSN(String ssn) {
        rp.ssnTextbox.sendKeys(ssn);
    }
    @And("enter ten digit SSN {string}")
    public void userShouldEnterTenDigitSSN(String ssn) {
        rp.ssnTextbox.sendKeys(ssn);
    }
    @And("enter valid firstname {string}")
    public void enterValidFirstname(String firstName) {
        rp.firstnameTextbox.sendKeys(firstName);
    }
    @Then("verify first name is valid")
    public void verifyFirstNameIsValid() {
        rp.lastnameTextbox.click();
        try {
            Assert.assertFalse(rp.firstNameRequiredMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @And("leave first name box blank")
    public void leaveFirstNameBoxBlank() {
        rp.firstnameTextbox.sendKeys("");
    }
    @Then("verify first name required message is displayed")
    public void verifyFirstNameRequiredMessageIsDisplayed() {
        rp.lastnameTextbox.click();
        try {
            Assert.assertTrue(rp.firstNameRequiredMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(false);
        }
    }
    @And("enter valid lastname {string}")
    public void enterValidLastname(String lastName) {
        rp.lastnameTextbox.sendKeys(lastName);
    }
    @Then("verify lastname is valid")
    public void verifyLastnameIsValid() {
        rp.usernameTextbox.click();
        try{
            Assert.assertFalse(rp.lastNameRequiredMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @And("leave last name blank")
    public void leaveLastNameBlank() {
        rp.lastnameTextbox.sendKeys("");
    }
    @Then("verify last name required message is displayed")
    public void verifyLastNameRequiredMessageIsDisplayed() {
        rp.usernameTextbox.click();
        try {
            Assert.assertTrue(rp.lastNameRequiredMessage.isDisplayed());
        }catch(Exception e){
            Assert.assertTrue(false);
        }
    }

    //Mrs Zehra

    @Given("users provides the password {string}")
    public void users_provides_the_password(String password) {

        Driver.waitAndSendText(rp.firstnameTextbox, password);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);


    }

    @Then("user valides the password strength {string}")
    public void user_valides_the_password_strength(String rgb) {

        Assert.assertTrue(rp.returnPasswordStrength(rgb).isDisplayed());


    }

    //MR.Edward

    @And("user sends data for the New Password {string}")
    public void user_sends_data_for_the_new_password(String password) {
        password = faker.internet().password(8, 20, true, true);
        registrant.setPassword(password);
        Driver.waitAndSendText(rp.passwordTextbox, password);

    }
    @And("user sends data for the New password confirmation {string}")
    public void user_sends_data_for_the_new_password_confirmation( String password) {
        Driver.waitAndSendText(rp.passwordConfirmationTextbox, password);


    }
    @Then("user clicks on the registration button and see the message registration saved  as {string}")
    public void user_clicks_on_the_registration_button_and_see_the_message_registration_saved_as(String registration) {

    }





}