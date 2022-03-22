package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminSignIn {
    public AdminSignIn(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath ="//*[@id='account-menu']/a" )
    public WebElement signinLink;

    @FindBy(id = "login-item")
    public WebElement signButton;
    @FindBy(xpath = "//*[@id='admin-menu']/a/span")
    ////*[@id="admin-menu"]/a/span
    public WebElement adminMenu;

    @FindBy(xpath = "//*[@id='admin-menu']/div")
    public WebElement userManegement;

    @FindBy(xpath = "//a[contains(text(),'138')]")
    public WebElement page138;


    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButton;


    @FindBy (xpath = "//button[@class='btn btn-danger']")
    public WebElement deleteAlert;

    @FindBy (xpath = "(//span[@aria-hidden='true'])[3]")
    public WebElement deleteAlertExit;

    @FindBy (xpath = "//*[contains(text(),'A user is updated with identifier')]")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = "//span[contains(text(),'View')]")
    public WebElement viewButton;
   ///////////////////////////////////////////////

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[2]/div[2]/div/nav/ul/li[6]/a")
    public WebElement page147;
    @FindBy(xpath = "//*[@id='bakalim']/td[11]/div/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//*[@value='ROLE_USER']")
    public WebElement roleUser;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement saveButton;

}
