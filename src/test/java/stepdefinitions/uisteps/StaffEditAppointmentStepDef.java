package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.StaffEditAppointmentPage;
import utilities.DateUtils;
import utilities.Driver;

import java.util.Random;

public class StaffEditAppointmentStepDef {
    StaffEditAppointmentPage sp=new StaffEditAppointmentPage();
    Actions action=new Actions(Driver.getDriver());
    Random random=new Random();

    @And("navigate to search patient page")
    public void navigateToSearchPatientPage() {
        Driver.wait(2);
        Driver.waitAndClick(sp.myPagesDropDown);
        Driver.waitAndClick(sp.searchPatientLink);


    }

    @Given("enters patient's SSN to SSN box {string}")
    public void enters_patient_s_ssn_to_ssn_box(String ssn) {
        Driver.waitAndSendText(sp.ssnBox,ssn);

    }

    @And("find patient and click edit button, patient id:{string}")
    public void findPatientAndClickEditButtonPatientId(String id) {
       Driver.waitAndClick(sp.showAppointmentsButton);
       Driver.waitAndClick(sp.editButton);


    }

    @And("edit the patient appointment date")
    public void editThePatientAppointmentDate() {
        Driver.waitAndSendText(sp.startDateTextBox,DateUtils.getDate());
        sp.startDateTextBox.sendKeys(Keys.TAB);
        // action.sendKeys(Keys.TAB).perform();
        Driver.waitAndSendText(sp.startDateTextBox,"1445");

        Driver.clearAndSendText(sp.endDateTextBox,DateUtils.getDate());
        sp.endDateTextBox.sendKeys(Keys.TAB);
        Driver.waitAndSendText(sp.endDateTextBox,"1545");
    }


    @And("leave the Anamnesis, Treatment and Diagnosis fields blank")
    public void leaveTheAnamnesisTreatmentAndDiagnosisFieldsBlank() {
        Driver.waitAndClick(sp.anemnesisTextBox);
        sp.anemnesisTextBox.clear();
        Driver.waitAndClick(sp.treatmentTextBox);
        sp.treatmentTextBox.clear();
        Driver.waitAndClick(sp.diagnosisTextBox);
        sp.diagnosisTextBox.clear();
    }

    @And("select any current doctor from physician dropdown")
    public void selectAnyCurrentDoctorFromPhysicianDropdown() {
        Driver.waitAndClick(sp.physicianDropdown);
        int index=random.nextInt(sp.physicianList.size())+1;
//        if(index==0){
//            index=random.nextInt(sp.physicianList.size());
//        }
        System.out.println(sp.physicianList.size());
        Driver.wait(3);
        Driver.waitAndClick(sp.physicianList.get(index));
        System.out.println(sp.physicianList.get(index).getText());
        Driver.wait(3);

    }

    @And("find the patient and click show test button")
    public void findThePatientAndClickShowTestButton() {
        Driver.waitAndClick(sp.showAppointmentsButton);
        Driver.waitAndClick(sp.showTestButton);


    }

    @And("navigate to Test Results page")
    public void navigateToTestResultsPage() {
        Driver.waitAndClick(sp.viewResultButton);

    }

    @Then("verify test results page")
    public void verifyTestResultsPage() {
        Driver.wait(2);
        Assert.assertTrue(sp.testResultPageExpression.isDisplayed());
    }

    @Then("close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }
}
