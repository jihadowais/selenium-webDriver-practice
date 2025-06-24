package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
    private WebDriver driver;  // create a Selenium WebDriver object

    @BeforeClass
    public void setUp() {
        // Selenium webdriver need to know the exec. chromedriver path
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        // instantiate a driver object to interact with the browser & do any automations
        driver = new ChromeDriver(); // we can instantiate any other driver // ex. FirefoxDriver(); EdgeDriver(); ..
        driver.get("https://the-internet.herokuapp.com/"); // launch the browser for our App
    }

    @Test
    public void verifyAppTitleTest() {
        System.out.println(driver.getTitle()); // print the App title
        driver.close();
    }
}
