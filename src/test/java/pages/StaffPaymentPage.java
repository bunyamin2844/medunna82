package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffPaymentPage {

    public StaffPaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public  WebElement username;

    @FindBy(id = "password")
    public  WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public  WebElement signInButton;

    @FindBy(xpath= "//a[@class='btn btn-warning btn-sm']")
    public WebElement showAppointmentsButton;

    @FindBy(xpath = "(//span[text()='Payment / Invoice Process'])")
    public WebElement paymentButton;

    @FindBy(xpath = "//*[text()=' Show Invoice']")
    public  WebElement showInvoiceButton;

}



