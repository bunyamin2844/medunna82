package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoctorEditPage {

    public DoctorEditPage(){PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(xpath="(//*[contains(text(),'My Appointments')])[1]")
    public WebElement My_Patient_Button;

    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    public WebElement Request_Inpatient;

    @FindBy(xpath = "//h2[@id='hospitalmsappfrontendApp.appointment.home.createOrEditLabel']")
    public WebElement Id_TextBox;

    //example
    @FindBy(xpath = "//option[@value='UNAPPROVED']")
    public WebElement Status;

}
