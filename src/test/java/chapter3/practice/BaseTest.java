package chapter3.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().minimize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void openHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(dataProvider = "getPageTitle", dataProviderClass = TestData.class)
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

        softAssert.assertAll("Some elements are not visible or have wrong redirection URL.");
    }

    @Test
    public void verifyElementsAreClickableTest() {
        List<WebElement> webElements = driver.findElements(By.tagName("li"));
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element:webElements) {
            String elementName = element.getText();
            String elementURL = element.findElement(By.tagName("a")).getDomProperty("href");
            System.out.println("Element: " + elementName + ", Link: " + elementURL);
            softAssert.assertTrue(isValidURL(elementURL), "Element is not clickable, may be the URL is wrong or not found. The found element URL is: " + elementURL);
        }

        softAssert.assertAll();
    }

    boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
