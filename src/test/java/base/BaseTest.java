package base;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("report/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // mode sans interface graphique (obligatoire en CI)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*"); // évite certaines erreurs récentes
        options.addArguments("--user-data-dir=/tmp/profile-" + System.currentTimeMillis()); // profil unique

        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterEachTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        extent.flush(); // génère le rapport HTML
    }
}
