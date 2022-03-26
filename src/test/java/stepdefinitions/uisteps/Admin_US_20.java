package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.DoctorEditAppointmentPage;
import pages.AdminSignIn;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Admin_US_20 {
    DoctorEditAppointmentPage dp=new DoctorEditAppointmentPage();
    AdminSignIn adminSignIn =new AdminSignIn();

    @Given("admin goes to medunna page")
    public void admin_goes_to_medunna_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
        Driver.waitAndClick(adminSignIn.signinLink);
        Driver.waitAndClick(adminSignIn.signButton);
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
    @And("admin navigates to user management page")
    public void adminNavigatesToUserManagementPage() {

        Driver.waitAndClick(adminSignIn.adminMenu);
        Driver.waitAndClick(adminSignIn.userManegement);
    }


    @And("admin clicks the delete buttonn and alert button")
    public void adminClicksTheDeleteButtonnAndAlertButton() {


        Driver.waitAndClick(adminSignIn.page138);
        Driver.wait(5);
        Driver.waitAndClick(adminSignIn.deleteButton);
        Driver.clickWithJS(adminSignIn.deleteButton);
        //Driver.waitAndClick(signIn.deleteAlert);
        Driver.clickWithJS(adminSignIn.deleteAlert);
        Driver.clickWithJS(adminSignIn.deleteAlertExit);

    }


    @And("Admin verifies that user deleted")
    public void adminVerifiesThatUserDeleted() {
        Driver.wait(1);
        Assert.assertTrue(adminSignIn.deleteSuccessMessage.isDisplayed());


    }
    @Given("admin clicks the view button")
    public void admin_clicks_the_view_button() {

    }

    @Given("admin verifies all user's info")
    public void admin_verifies_all_user_s_info() {

    }



}

