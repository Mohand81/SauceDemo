package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(id="user-name")
    private WebElement UserName;

    @FindBy (xpath= "//div[contains(text(), 'Products')]")
    private WebElement Product;

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String VerifProduct() {
        return Product.getText();
    }

    }


