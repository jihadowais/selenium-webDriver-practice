package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void reopenHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(enabled = false, dataProvider = "getPageTitle", dataProviderClass = TestData.class)
    public void shouldShowAppTitleCorrectlyTest(String page, String title) {
        String actual = driver.getTitle();
        Assert.assertEquals(actual, title, "Page has no or wrong title .");
    }

    @Test(dataProvider = "getURLs", dataProviderClass = TestData.class)
    public void shouldShowElementAndRedirectToExpectedUrlTest(String elementName, String expectedURL) {
        WebElement element = driver.findElement(By.linkText(elementName));
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(element.isDisplayed(), "Element doesn't show.");

        element.click();
        String actualURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualURL, expectedURL, "Wrong redirection URL.");

        softAssert.assertAll();
    }
}
