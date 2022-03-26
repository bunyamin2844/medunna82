package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RoomPage {
    public RoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sign;
    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[3]/ul/li[6]/a")
    public WebElement clicksRoom;
    @FindBy(xpath = "//span[.='Create a new Room']")
    public WebElement createNewRoom;
    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumber;
    @FindBy(xpath = "//*[@id=\"room-roomType\"]")
    public WebElement roomTypeDropdown;
    @FindBy(id = "room-status")
    public WebElement checkbox;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;
    @FindBy(id = "room-description")
    public WebElement description;
    @FindBy(id = "room-createdDate")
    public WebElement createdDate;
    @FindBy(id = "save-entity")
    public WebElement submitButton;
   @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[4]/td[8]/div/a[3]/span/span")
    public WebElement delete;
   @FindBy(xpath = "//*[@id=\"jhi-confirm-delete-room\"]/span")
    public WebElement delete1;
    @FindBy(xpath ="//*[@id=\"root\"]/div/div/div[1]/div" )
    public WebElement deleteMessage;
}
