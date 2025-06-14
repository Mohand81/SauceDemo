package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="user-name")
    private WebElement UserName;

    @FindBy(id="password")
    private WebElement Password;

    @FindBy(id="login-button")
    private WebElement LoginButton;



    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void LoginRemp() {
        UserName.click();
        UserName.sendKeys("standard_user");

        Password.click();
        Password.sendKeys("secret_sauce");

        LoginButton.click();

    }
}
