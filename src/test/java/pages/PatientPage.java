package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPage {

    public PatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

//    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
//    public WebElement itemsAndTitlesDropdown;

//    @FindBy(xpath = "//*[contains(text(),'Items&Titles')]")
//    public WebElement ItemsTitlesDrowdown;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public  WebElement myPagesDropDown;

    @FindBy(xpath="//a[@class='dropdown-item active']")
    public WebElement PatientDropDown;

    @FindBy(xpath = "(//a[@href='/patient/1051'])[2]")
    public WebElement ViewButtonPatient1051;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[2]")
    public WebElement EditButtonPatient1051;

    @FindBy(xpath = "//a[@href='/patient-detail/4860']")
    public WebElement ViewButtonPatient4860;

    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement patientPageVerifyStaff;

    @FindBy(xpath = "//a[@class='dropdown-item'])[1]")
    public WebElement patientButton;


    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement patientPageVerifyAdmin;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement patientEditStaff;


    @FindBy(xpath = "//span[text()='Patients']")
    public WebElement patientsVerify;

    @FindBy(xpath = "//a[@class='page-link']")
    public WebElement lastPageNavigator;
    @FindBy(id = "patient-firstName")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement lastNameBox;
    @FindBy(xpath = "//*[@id='patient-birthDate']")
    public WebElement birthDateBox;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement eMailBox;
    @FindBy(xpath = "//*[@id='patient-phone']")
    public WebElement phoneNumberBox;
    @FindBy(xpath = "//*[@id='patient-gender']")
    public WebElement genderDropDown;
    @FindBy(xpath = "//*[@id='patient-bloodGroup']")
    public WebElement bloodGroupDropDown;
    @FindBy(xpath = "//*[@id='patient-adress']")
    public WebElement addressBox;
    @FindBy(xpath = "//*[@id='patient-description']")
    public WebElement descriptionBox;
    @FindBy(xpath = "//*[@id='patient-user']")
    public WebElement userPatientDropDown;
    @FindBy(xpath = "//*[@id='patient-country']")
    public WebElement countryDropDown;
    @FindBy(id = "patient-cstate")
    public WebElement stateDropDown;
    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div")
    public WebElement savedPatientStaff;
    @FindBy(xpath = "//*[@id='app-view-container']/div")
    public WebElement savedPatientAdmin;
    @FindBy(xpath = "//*[contains(text(),'A Patient is updated with identifier 1051')]")
    public WebElement savedToastAdmin;



}
