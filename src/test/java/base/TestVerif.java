package base;

import Pages.LoginPage;
import Pages.ProductPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestVerif extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestVerif.class);

    @BeforeMethod
    public void loginBeforeEachTest() {
        driver.get("https://www.saucedemo.com/v1/");
        LoginPage ObjLoginPage = new LoginPage(driver);
        ObjLoginPage.LoginRemp();
    }

    @Test
    public void Verif (){
        test = extent.createTest("Test verif");
        ProductPage ObjProductPage = new ProductPage(driver);
        Assert.assertEquals(ObjProductPage.VerifProduct(), "Products");

    }
}
