package stepdefinitions.uisteps;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorEditAppointmentPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorAppointmentStepDefs {

    DoctorEditAppointmentPage dp=new DoctorEditAppointmentPage();
    Faker faker=new Faker();
    List<String> expectedAppointmentInfo=new ArrayList<String>();


    @Given("go to login page {string}")
    public void go_to_login_page(String loginPageURl) {
        Driver.getDriver().get(loginPageURl);

    }
    @Given("sign in as doctor: username {string}, password {string}")
    public void sign_in_as_doctor_username_password(String username, String password) {
        Driver.waitAndSendText(dp.usernameTextBox,username);
        Driver.waitAndSendText(dp.passwordTextBox,password);
        Driver.waitAndClick(dp.signInButton);

    }
    @Given("navigate to my appointments page")
    public void navigate_to_my_appointments_page() {
        Driver.waitAndClick(dp.myPagesDropDown);
        Driver.waitAndClick(dp.myAppointmentsLink);
        Driver.wait(2);

    }

    @And("find the patient and click edit button, patient id:{string}")
    public void findThePatientAndClickEditButtonPatientId(String patientId) {

        for(int i=1;i<15;i++){
            if(Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText().contains(patientId)){
                Driver.wait(2);
                Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[13]")).click();
                break;
            }
        }

    }


    @And("edit the appointment information: {string}, {string}, {string}, {string}, {string}")
    public void editTheAppointmentInformation(String anamnesis, String treatment, String diagnosis, String prescription, String description) {
        expectedAppointmentInfo.add(anamnesis);
        expectedAppointmentInfo.add(treatment);
        expectedAppointmentInfo.add(diagnosis);
        expectedAppointmentInfo.add(prescription);
        expectedAppointmentInfo.add(description);

        Driver.clearAndSendText(dp.anemnesisTextBox,anamnesis);
        Driver.clearAndSendText(dp.treatmentTextBox,treatment);
        Driver.clearAndSendText(dp.diagnosisTextBox,diagnosis);
        Driver.clearAndSendText(dp.prescriptionTextBox,prescription);
        Driver.clearAndSendText(dp.descriptionTextBox,description);

    }

    @And("click save button")
    public void clickSaveButton() {
        Driver.waitAndClick(dp.saveButton);
        Driver.wait(2);
    }

    @Given("verify the appointment updated message")
    public void verify_the_appointment_updated_message() {
        Assert.assertTrue(dp.appointmentUpdatedMessage.isDisplayed());

    }

    @And("navigate back to my appointments page")
    public void navigateBackToMyAppointmentsPage() {
        Driver.wait(2);
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        Driver.wait(2);

    }

    @And("verify the edited information of the patient appointment, patient id {string}")
    public void verifyTheEditedInformationOfThePatientAppointmentPatientId(String patientId) {
        List<String>acttualAppointmentInfo=new ArrayList<>();
        for(int i=1;i<20;i++) {
            if(Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText().contains(patientId)){
                for(int k=5; k<10; k++){
                    acttualAppointmentInfo.add(Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td["+k+"]")).getText());
                }
                break;
            }

        }
        // System.out.println(acttualAppointmentInfo);
        // System.out.println(expectedAppointmentInfo);
        Assert.assertEquals(expectedAppointmentInfo,acttualAppointmentInfo);
    }

    @And("verify appoitment can't be saved")
    public void verifyAppoitmentCanTBeSaved() {
        Assert.assertTrue(dp.FieldRequiredMessage.isDisplayed());

    }


    @Then("verify that status can only be set as {string}, {string} or {string}")
    public void verifyThatStatusCanOnlyBeSetAsOr(String pending, String completed, String cancelled) {
        List<String>expectedClickableStatusOptions=new ArrayList<>();
        expectedClickableStatusOptions.add(pending);
        expectedClickableStatusOptions.add(completed);
        expectedClickableStatusOptions.add(cancelled);

        List<String>actualClickableStatusOptions=new ArrayList<>();

        Driver.waitAndClick(dp.statusDropDown);
        for(int i=0; i<dp.statusOptions.size(); i++){
            if(dp.statusOptions.get(i).isEnabled()){
                actualClickableStatusOptions.add(dp.statusOptions.get(i).getText());
            }
        }

        //System.out.println(expectedClickableStatusOptions);
        //System.out.println(actualClickableStatusOptions);

        Assert.assertEquals(expectedClickableStatusOptions,actualClickableStatusOptions);
        System.out.println("Deneme");
    }
}
