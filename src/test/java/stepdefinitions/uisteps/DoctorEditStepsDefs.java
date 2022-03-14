package stepdefinitions.uisteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.DoctorEditPage;
import utilities.Driver;
import java.security.Key;

public class DoctorEditStepsDefs {

    DoctorEditPage doctorEditPage = new DoctorEditPage();

    @Given("doctor clicks on my pages")
    public void doctor_clicks_on_my_pages() throws InterruptedException {
        Thread.sleep(4);
        for (int i = 0; i < 9; i++) {
            Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        }
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Given("doctor clicks on my appointments")
    public void doctor_clicks_on_my_appointments() {
        doctorEditPage.My_Patient_Button.click();
    }

    @Given("doctor clicks on patient edit button")
    public void doctor_clicks_on_patient_edit_button() throws InterruptedException {
        Thread.sleep(4);
        for (int i = 0; i < 14; i++) {
            Driver.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        }
        Driver.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Then("doctor clicks on request inpatient button")
    public void doctor_clicks_on_request_inpatient_button() throws InterruptedException {
        doctorEditPage.Request_Inpatient.click();
        Assert.assertTrue(doctorEditPage.Id_TextBox.isDisplayed());


        /*
        i.e 2
        Thread.sleep(4);
        String Expected = "MEDUNNA";
        String Actual = Driver.getDriver().getTitle();
        System.out.println(Actual);
        Assert.assertEquals(Expected,Actual);
         */
    }
}