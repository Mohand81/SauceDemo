package base;


import Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class TestSimulation extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestSimulation.class);

    @Test
    public void testLogin() {
        test = extent.createTest("Test Login");
        driver.get("https://www.saucedemo.com/v1/");

        LoginPage ObjloginPage = new LoginPage(driver);
        ObjloginPage.LoginRemp();

    }

}
