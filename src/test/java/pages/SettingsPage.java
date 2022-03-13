package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
    public class SettingsPage {
        public SettingsPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }
      //  @FindBy(xpath = "//*[.='Sign in']")
      //  public WebElement firstSignButton;
        @FindBy(id = "username")
        public WebElement username;
        @FindBy(id = "password")
        public WebElement password;
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement signInButton;
    //    @FindBy(xpath = "//*[@class='dropdown-item active']")
     //   public WebElement settingsbutton;
        @FindBy(name = "//input[@name='firstName']")
        public WebElement firstName;
        @FindBy(name = "//input[@name='lastName']")
        public WebElement lastName;
        @FindBy(name="//input[@name='email']")
        public WebElement email;
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement saveButton;


    }

