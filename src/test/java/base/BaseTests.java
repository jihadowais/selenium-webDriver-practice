package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected String domainURL = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void openHomePage() {
        driver.get(domainURL);
        homePage = new HomePage(driver);
    }
}
