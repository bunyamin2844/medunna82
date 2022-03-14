package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.PatientPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import static org.junit.Assert.assertTrue;

public class PatInfoChangeStaffSteps {

    PatientPage page = new PatientPage();

    @Given("user goes the login page")
    public void user_goes_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));

    }

    @When("staff types the username {string}")
    public void staffTypesTheUsername(String username) {
        page.username.sendKeys("halukdertli");
    }

    @When("staff types the password {string}")
    public void staffTypesThePassword(String password) {
        page.password.sendKeys("Haluk123.");
    }

//    @And("staff clicks MYPAGES dropdown")
//    public void staffClicksMYPAGESDropdown() {
//        page.myPagesDropDown.click();
//    }

    @And("staff goes to search patient page")
    public void staffGoesTosSearchPatientPage() {
        Driver.getDriver().get("https://www.medunna.com/search-patient?page=1&sort=id,asc");

    }

    @And("staff clicks view button")
    public void staffClicksViewButton() {
        Driver.waitAndClick(page.ViewButtonPatient1051);

    }

    @Then("staff verify the patient page")
    public void staffVerifyThePatientPage() {
        Driver.wait(2);
        assertTrue(page.patientPageVerifyStaff.isDisplayed());
    }

    @And("staff clicks the edit button")
    public void staffClicksTheEditButton() {
        Driver.waitAndClick(page.patientEditStaff);
        
    }

    @And("staff clicks save button")
    public void staffClicksSaveButton() {
        Driver.waitAndClick(page.saveButton);
    }

    @And("verify the delete button is enable the displayed")
    public void verifyTheDeleteButtonIsEnableTheDisplayed() {
            String pageSource=Driver.getDriver().getPageSource();
            boolean result=pageSource.contains("delete");
            Assert.assertTrue(result==false);
        }



    @And("staff search a patient")
    public void staffSearchAPatient() {
        Driver.waitAndSendText(page.patientSearchBox,"319-04-4812");
    }

    @Then("verify the patient information are invoked")
    public void verifyThePatientInformationAreInvoked() {
        Assert.assertTrue(page.Result.isDisplayed());
    }


}
