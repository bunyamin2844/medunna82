package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StaffEditAppointmentPage {

    public StaffEditAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropDown;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientLink;

    @FindBy(xpath = "//tbody/tr[1]/td[16]//a[@class='btn btn-warning btn-sm']")
    public  WebElement showAppointmentsButton;

    @FindBy(xpath = "//a[@class='btn btn-warning btn-sm']")
    public  WebElement editButton;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateTextBox;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateTextBox;

    @FindBy(xpath = "//select[@id='appointment-status']/option")
    public List<WebElement> statusOptions;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anemnesisTextBox;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//textarea[@name='prescription']")
    public WebElement prescriptionTextBox;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionTextBox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath ="//div[contains(text(),'Appointment is updated')]" )
    public WebElement appointmentUpdatedMessage;

    @FindBy(id = "appointment-status")
    public  WebElement statusDropDown;

    @FindBy(id="appointment-physician")
    public WebElement physicianDropdown;

    @FindBy(xpath = "//select[@id='appointment-physician']/option")
    public List<WebElement> physicianList;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement showTestButton;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewResultButton;

    @FindBy(xpath = "//span[contains(text(),'Test Results')]")
    public WebElement testResultPageExpression;

}
