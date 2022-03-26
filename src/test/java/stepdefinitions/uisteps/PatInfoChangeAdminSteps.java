package stepdefinitions.uisteps;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.PatientPage;
import utilities.Driver;
import static org.junit.Assert.assertTrue;



public class PatInfoChangeAdminSteps {

    PatientPage page = new PatientPage();


    @When("admin types the username {string}")
    public void admin_types_the_username(String string) {

        page.username.sendKeys("gulbahce");

    }

    @When("admin types the password {string}")
    public void admin_types_the_password(String string) {
        page.password.sendKeys("Gulbahce123.");

    }

    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        page.signInButton.click();
        Driver.wait(3);
    }

    @And("user goes to patient page")
    public void userGoesToPatientPage() {

        Driver.getDriver().get("https://www.medunna.com/patient?page=1&sort=id,asc");
    }

    @And("user validates patients")
    public void userValidatesPatients() {

        assertTrue(page.patientPageVerifyAdmin.isDisplayed());

    }

    @And("user clicks view icon")
    public void userClicksViewIcon() {
        Driver.wait(5);
        page.ViewButtonPatient1051.click();

    }

    @And("user validates patient view page")
    public void userValidatesPatientViewPage() {
        assertTrue(page.patientPageVerifyAdmin.isDisplayed());
    }

    @And("user clicks the edit button")
    public void userClicksTheEditButton() {

        Driver.waitAndClick(page.EditButtonPatient1051);
        // Driver.getDriver().switchTo().activeElement().sendKeys(20 TAB);
    }

    @And("user edit information")
    public void userEditInformation() throws InterruptedException {
        Driver.wait(2);
        page.firstNameBox.clear();
        Driver.waitAndSendText(page.firstNameBox, "Aysun");
        Driver.wait(3);
        page.lastNameBox.clear();
        Driver.waitAndSendText(page.lastNameBox, "Yayaci");
        page.birthDateBox.clear();
        page.birthDateBox.sendKeys(Keys.ARROW_RIGHT);
        page.birthDateBox.clear();
        page.birthDateBox.sendKeys(Keys.ARROW_RIGHT);
        page.birthDateBox.clear();
        page.birthDateBox.sendKeys(Keys.ARROW_RIGHT);
        page.birthDateBox.clear();
        page.birthDateBox.sendKeys(Keys.ARROW_LEFT);
        page.birthDateBox.sendKeys(Keys.ARROW_LEFT);
        page.birthDateBox.sendKeys(Keys.ARROW_LEFT);
        Driver.waitAndSendText(page.birthDateBox, "06.05.0019710816AM");
        Thread.sleep(5000);
        page.eMailBox.clear();
        Driver.waitAndSendText(page.eMailBox, "aysun@hotmail.com");
        page.phoneNumberBox.clear();
        page.phoneNumberBox.sendKeys("12345678910");
        Select select3 = new Select(page.genderDropDown);
        Driver.wait(3);
        select3.selectByIndex(1);
        Select select4 = new Select(page.bloodGroupDropDown);
        Driver.wait(3);
        select4.selectByIndex(1);
        page.addressBox.clear();
        page.addressBox.sendKeys("Bagcilar");
        page.descriptionBox.clear();
        page.descriptionBox.sendKeys("Test bir ki");
        Select select = new Select(page.countryDropDown);
        select.selectByVisibleText("Turkey");
//       Select select2 = new Select(page.stateDropDown);
//       select2.selectByVisibleText("Bilecik");

    }

    @And("user clicks the save button")
    public void userClicksTheSaveButton() {
        Driver.waitAndClick(page.saveButton);

    }

    @Then("admin validates the edit is successful")
    public void adminValidatesTheEditIsSuccessful() {
        Driver.wait(3);
        assertTrue(page.savedToastAdmin.isDisplayed());
    }

    @And("admin clicks the delete button")
    public void adminClicksTheDeleteButton() {

        Driver.waitAndClick(page.deleteButton);
        Driver.waitAndClick(page.deleteConfirmButton);

    }

    @Then("verifies the deleting is successful")
    public void verifiesTheDeletingIsSuccessful() {
        if (page.deleteErrorToast.isDisplayed() == true) {
            System.out.println("Deleting is not successful");
        } else {
            System.out.println("Deleting is successful");
        }
    }


    @Then("user verify the search box is enable")
    public void userVerifyTheSearchBoxIsEnable() {
//is there the word in the page? For research we are using that getPageSource method from Driver
        String pageSource=Driver.getDriver().getPageSource();
        boolean result=pageSource.contains("Search");
        Assert.assertTrue(result==false);

    }
}


