package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoctorEditAppointmentPage {
    public DoctorEditAppointmentPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement usernameTextBox;
    //

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropDown;

    @FindBy(xpath = "//span[contains(text(),'My Appointments')]")
    public WebElement myAppointmentsLink;

    @FindBy(id = "appointment-status")
    public  WebElement statusDropDown;

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

    @FindBy(xpath ="//div[contains(text(),'The Appointment is updated with identifier')]" )
    public WebElement appointmentUpdatedMessage;

    @FindBy(xpath = "//div[contains(text(),'This field is required.')]")
    public WebElement FieldRequiredMessage;

    @FindBy(xpath = "//select[@id='appointment-status']/option")
    public List<WebElement> statusOptions;








}
