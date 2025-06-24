package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class BaseTest {
    private WebDriver driver;  // create a Selenium WebDriver object

    @BeforeClass
    public void setUp() {
        // Selenium webdriver need to know the exec. chromedriver path
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        // instantiate a driver object to interact with the browser & do any automations
        driver = new ChromeDriver(); // we can instantiate any other driver // ex. FirefoxDriver(); EdgeDriver(); ..
        driver.manage().window().maximize(); // maximize the window // .fullscreen() to make it in fullscreen mode
        // driver.manage().window().setSize(new Dimension(375, 812)); // set window size to iphone size
    }

    @AfterClass
    public void tearDown() {
        driver.quit();  // close(): closes the window, NOT the sessions // quit(): close any of the windows that are open and complete out this session.
    }

    @BeforeMethod
    public void reopenHome() {
        driver.get("https://the-internet.herokuapp.com/"); // launch the browser for our App
    }

    @Test(enabled = false, dataProvider = "getPageTitle", dataProviderClass = TestData.class)
    public void shouldShowAppTitleCorrectlyTest(String page, String title) {
        System.out.println(driver.getTitle()); // print the App title
        String actual = driver.getTitle();
        Assert.assertEquals(actual, title);
    }

    @Test(dataProvider = "getURLs", dataProviderClass = TestData.class)
    public void shouldShowElementAndRedirectToExpectedUrlTest(String elementName, String expectedURL) {
        WebElement element = driver.findElement(By.linkText(elementName));
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(element.isDisplayed());

        element.click();
        String actualURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualURL, expectedURL);

        softAssert.assertAll();
    }
}
