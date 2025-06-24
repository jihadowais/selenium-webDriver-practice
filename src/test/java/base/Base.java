package base;

import org.openqa.selenium.Dimension;
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
        driver.manage().window().maximize(); // maximize the window // .fullscreen() to make it in fullscreen mode
        driver.manage().window().setSize(new Dimension(375, 812)); // set window size to iphone size
    }

    @Test
    public void verifyAppTitleTest() {
        System.out.println(driver.getTitle()); // print the App title
        driver.quit();  // close(): closes the window, NOT the sessions // quit(): close any of the windows that are open and complete out this session.
    }
}
