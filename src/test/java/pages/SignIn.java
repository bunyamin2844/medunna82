package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {



    @FindBy(xpath = "//*[@id='admin-menu']/a/span")
    ////*[@id="admin-menu"]/a/span
    public WebElement adminMenu;

    @FindBy(xpath = "//*[@id='admin-menu']/div")
    public WebElement userManegement;
    @FindBy(xpath = "//*[@id='system']/td[11]/div/a[3]/svg/path")
    public WebElement deleteButton;

}
