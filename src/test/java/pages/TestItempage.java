package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestItempage {


    public TestItempage(){


        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "password")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")

    public WebElement saveButton;

    @FindBy(id="entity-menu")

    public WebElement itemstitlesButton;


    @FindBy(xpath = "(//a[@href='/c-test-item'])[1]")

    public WebElement testitembutton;


    @FindBy(id = "jh-create-entity")

    public WebElement createanitemButtom;

    @FindBy(id = "c-test-item-name")

    public WebElement testitemName;

    @FindBy(id = "c-test-item-description")

    public WebElement testitemDescription;

    @FindBy(id = "c-test-item-price")

    public WebElement testitemPrice;


    @FindBy(id = "c-test-item-defaultValMin")

    public WebElement testitemdefaultValMin;

    @FindBy(id = "c-test-item-defaultValMax")

    public WebElement testitemdefaultValMax;

    @FindBy(id = "c-test-item-createdDate")
    public WebElement testitemcreateDate;

    @FindBy(id = "save-entity")

    public WebElement testitemSaveButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")

    public WebElement toastcontainer;

}
