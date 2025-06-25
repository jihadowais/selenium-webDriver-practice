package quiz.chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
For this chapter, I'd like to give you an optional exercise that you can try on your own.

Go to our test site, the-internet, and use the findElement and findElements to complete the following scenario.
Click on the “Shifting Content” link.
Then click on the first example Menu Element.
Then print how many of these menu elements appear.
*/

public class ShiftingContentPage {
    private WebDriver driver;

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
    public void openHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @DataProvider
    public Object[][] getMenuItems() {
        return new Object[][] {
                { Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery") }
        };
    }

    @Test(dataProvider = "getMenuItems")
    public void shouldAccessMenuItemsCorrectlyTest(List<String> menuItems) {
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();

        List<WebElement> elements = driver.findElements(By.tagName("li"));
        List<String> actualMenuItems = new ArrayList<>();

        for (WebElement element: elements)
            actualMenuItems.add(element.getText());

        Assert.assertEquals(actualMenuItems, menuItems, "Menu elements are not as expected.");

        System.out.printf("%nNumber of Menu Elements: %d.%n", elements.size()); // this line is the quiz requirement
    }

}
