package base;

import com.google.common.io.Files;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.HomePage;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected String domainURL = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriver chromeDriver = new ChromeDriver(getChromeOptions());
        driver = new EventFiringDecorator(new EventReporter()).decorate(chromeDriver);
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

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * A private method that sets some options to the automated chrome webdriver.<br>
     * It returns an instance of ChromeOptions class.<br>
     * Call this method when instantiating the chrome webdriver.
     * @return ChromeOptions instance.
     */
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // to open chrome in the maximized mode
        options.addArguments("--headless"); // this will run the tests without opening the browser
        return options;
    }
}
