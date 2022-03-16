package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.DoctorEditAppointmentPage;
import pages.SignIn;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Admin_US_20 {
    DoctorEditAppointmentPage dp=new DoctorEditAppointmentPage();
    SignIn signIn =new SignIn();

    @Given("admin goes to medunna page")
    public void admin_goes_to_medunna_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_sign_in"));
    }
    @Given("admin type the username {string}")
    public void admin_type_the_username(String string) {
        Driver.waitAndSendText(dp.usernameTextBox,string);

    }
    @Given("admin type the password {string}")
    public void admin_type_the_password(String string) {
        Driver.waitAndSendText(dp.passwordTextBox,string);

    }
    @Given("admin cliks sign in buttonn")
    public void admin_cliks_sign_in_buttonn() {
        Driver.waitAndClick(dp.signInButton);

    }
    @Given("admin clicks administration button")
    public void admin_clicks_administration_button() {
        Driver.waitAndClick(signIn.adminMenu);

    }

    @When("admin cliks user manegement button")
    public void admin_cliks_user_manegement_button() {
        Driver.waitAndClick(signIn.userManegement);

    }


    @When("admin clicks the delete buttonn")
    public void admin_clicks_the_delete_buttonn() {

        Driver.waitAndClick(signIn.deleteButton);
    }


}

