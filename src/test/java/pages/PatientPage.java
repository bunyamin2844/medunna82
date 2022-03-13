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

    @FindBy(xpath = "(//a[@href='/patient/1051'])[2]")
    public WebElement ViewButtonPatient1051;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[2]")
    public WebElement EditButtonPatient1051;

    @FindBy(xpath = "(//div/table/tbody/tr/td)[2]")
    public WebElement patientPageVerifyStaff;

    @FindBy(xpath = "//a[@class='dropdown-item'])[1]")
    public WebElement patientButton;

    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement patientPageVerifyAdmin;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement patientEditStaff;

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
    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientSearchBox;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement Result;

    @FindBy(xpath = "((//a[@class='btn btn-danger btn-sm'])[5]")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement deleteErrorToast;


}
