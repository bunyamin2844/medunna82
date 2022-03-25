package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditPage {

    public EditPage() {

        PageFactory.initElements(Driver.getDriver(), this);


        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "account-menu")
    public WebElement sign;

    @FindBy(id = "username")
    public WebElement id;

    @FindBy(id = "password")
    public WebElement passwords;

    // @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2])")
    //public WebElement click;

    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2]/span")
    public WebElement Click;

    //FindBy(xpath="//*[@id="login-page"]/div/form/div[3]/button[2]/span")

    // public void setClick(WebElement click) {
    //  this.click = click;

//
//   @FindBy(id = "password")
//    public WebElement password;
//@FindBy(xpath="//button[@type='submit']")
//     public WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]/a/span")
    public WebElement pages;


    @FindBy(xpath = "//*[@id=\"entity-menu\"]/div/a[1]/span")
    public WebElement searchp;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[1]/div[2]/input")
    public WebElement SSN;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[16]/div/a[3]")
    public WebElement show;

    @FindBy(xpath ="//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[16]/div/a[2]")

    //@FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[13]/div/a[1]/span/span")
    public WebElement edit;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div[2]/div/table/tbody/tr/td[16]/div/a[2]")
    public WebElement editingn;

   // @FindBy(id="patient-id\"")
    //public WebElement ID;

    @FindBy(name="id")
    public WebElement iD;

    @FindBy( name="firstName")
    public WebElement fn;

    @FindBy(name="lastName")
    public WebElement ln;

    @FindBy(name="birthDate")
    public WebElement birth;


    @FindBy(name="email")
    public WebElement emailing;

    @FindBy(name="phone")
    public WebElement phone;

   // @FindBy(id = "name=\"id\"")
    //public WebElement ID;

    //@FindBy(name="startDate")
    //public WebElement startDate;

    //@FindBy(name="endDate")
    //public WebElement endDate;

    //@FindBy(name="status")
    //public WebElement status;

    //@FindBy(name="anamnesis")
    //public WebElement anamnesis;

    //@FindBy(name="treatment")
    //public WebElement treatment;



}


