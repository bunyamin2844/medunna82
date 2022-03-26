package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AppointmentPage;
import pojos.Appointment;
import utilities.ConfigurationReader;
import utilities.DatabaseUtility;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static utilities.DateUtils.getDate;
import static utilities.WriteToTxt.saveAppointData;

public class UIAppointmentSteps {

    AppointmentPage appointmentPage = new AppointmentPage();
    Faker faker = new Faker();
    Appointment appointment = new Appointment();

    @Given("user goes the login pagee")
    public void user_goes_the_login_pagee() {

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }


    @Given("user clicks on make an appointment")
    public void user_clicks_on_make_an_appointment() {

        Driver.waitAndClick(appointmentPage.MakeAnAppointmentButton);


    }
    @Given("user provides the appoinment name {string}")
    public void user_provides_the_appoinment_name(String firstname) {
        //firstname = faker.name().firstName();
        appointment.setFirstname(firstname);

        Driver.waitAndSendText(appointmentPage.firstnameTextbox, firstname);

    }
    @Given("user provides the appointment lastname {string}")
    public void user_provides_the_appointment_lastname(String lastname) {
        //lastname = faker.name().lastName();
        appointment.setLastname(lastname);
        Driver.waitAndSendText(appointmentPage.lastnameTextbox, lastname);

    }
    @Given("user provides ssn and email {string} and {string}")
    public void user_provides_ssn_and_email_and(String ssn, String email) {
        //ssn = faker.idNumber().ssnValid();
       // email = faker.internet().emailAddress();
        appointment.setSsn(ssn);
        appointment.setEmail(email);


        Driver.waitAndSendText(appointmentPage.ssnTextbox, ssn);
        Driver.waitAndSendText(appointmentPage.emailTextbox, email);





    }
    @When("user provides the phone number {string}")
    public void user_provides_the_phone_number(String phoneNumber) {
       // phoneNumber = faker.phoneNumber().cellPhone();
        appointment.setPhoneNumber(phoneNumber);

        Driver.waitAndSendText(appointmentPage.phoneTextbox, phoneNumber);
    }
    @When("user provides the date {string}")
    public void user_provides_the_date(String date) {
        //05-04-2022
//        date = getDate();
        appointment.setDate(date);

        Driver.waitAndSendText(appointmentPage.dateTextbox, date+ Keys.ENTER);



    }
    @Then("user requests appointment and verifies the success message")
    public void user_requests_appointment_and_verifies_the_success_message() {

        Driver.waitAndClick(appointmentPage.requestButton);
        saveAppointData(appointment);

        Assert.assertTrue(Driver.waitForVisibility(appointmentPage.successMessageToastContainer, 5).isDisplayed());



    }

    @Given("user connects to the database")
    public void user_connects_to_the_database() {
        DatabaseUtility.createConnection();
    }

    @And("user selects all firstname column data")
    public void user_selects_all_firstname_column_data() {

    }
    @Then("user verify {string} with the database")
    public void user_verify_name_with_the_database(String firstname) {
        List<Object> allColumnDAta = DatabaseUtility.getColumnData("select * from jhi_user","firstname");
        System.out.println(allColumnDAta);
        List<Object> expectedData = new ArrayList<>();
        expectedData.add(firstname);

        Assert.assertTrue(allColumnDAta.containsAll(expectedData));
    }
    @Then("close the database connection")
    public void close_the_database_connection() {

        DatabaseUtility.closeConnection();
    }

}