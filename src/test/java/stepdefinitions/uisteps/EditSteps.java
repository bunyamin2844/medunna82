package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import pages.EditPage;
import pages.PatientPage;
import pages.RegistrationPage;
import pojos.Registrant;
import pojos.RegistrantUS22;
import utilities.ConfigurationReader;
import utilities.Driver;

public class EditSteps {

    Faker faker = new Faker();
   // Registrant registrant = new Registrant();//SAVE DATA AND REUSE DATA
    RegistrantUS22 registrant =new RegistrantUS22();

    RegistrationPage rp = new RegistrationPage();//INITIALIZED WEBELEMENTS
    //PatientPage ps = new PatientPage();
    EditPage ed = new EditPage();

    @Given("user enters into medunna login url")
    public void user_enters_into_medunna_login_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @When("user enters the username {string}")
    public void user_enters_the_username(String username) {
        //registrant.setUsernamet(username);
        Driver.waitAndSendText(ed.username, username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
       // registrant.setPassword(string);
        Driver.waitAndSendText(ed.password, string);
    }

    @When("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {

        Driver.waitAndClick(ed.Click);
    }

    @When("user navigates and clicks my pages")
    public void user_navigates_and_clicks_my_pages() {

        Driver.waitAndClick(ed.pages);
    }

    @When("selects on search patient button option")
    public void selects_on_search_patient_button_option() {

        Driver.waitAndClick(ed.searchp);
    }

    @When("user enters patient ssn {string}")
    public void user_enters_patient_ssn(String string) {
        Driver.waitAndClick(ed.SSN);
        //registrant.setSsn("185-82-6251");
    }

    //@When("navigates to show appointment and clicks on show appointment")
   // public void navigates_to_show_appointment_and_clicks_on_show_appointment() {
       // Driver.waitAndClick(ed.show);
//And navigates to show appointment and clicks on show appointment

   @When("user clicks on edit button")
    public void user_clicks_on_edit_button() {
       Driver.waitAndClick(ed.edit);
    }

    @When("user navigates and clicks on edit button")
    public void user_navigates_and_clicks_on_edit_button() {
        Driver.waitAndClick(ed.editingn);

    }
        @When("user enters ID,first name,last name,birthdate,email,phone")
        public void user_enters_ıd_first_name_last_name_birthdate_email_phone() {
            registrant.setiD("9054");
            registrant.setFn("Hopeful");
            registrant.setLn("Robellert");
            registrant.setBirth("05/10/2021");
            registrant.setEmailing("adan.mayert@gmail.com");
            registrant.setPhone("1234567889");

        }


    //@When("user enters ID,start date time,end date time,status,anamnesis,treatment")
    //public void user_enters_ıd_start_date_time_end_date_time_status_anamnesis_treatment() {
      //  registrant.setID("8833");
        //registrant.setStartDate("05/16/2022");
        //registrant.setEndDate("05/16/2022");
        //registrant.setStatus("PENDING");
        //registrant.setAnamnesis("Anamnesis");
        //registrant.setTreatment("Treatment");
    }
