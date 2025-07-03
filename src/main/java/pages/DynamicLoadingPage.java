package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private final WebDriver driver;
    private final By example1Link = By.cssSelector("#content .example a");
    private final By example2Link = By.partialLinkText("Example 2");

    public DynamicLoadingPage(WebDriver driver) { this.driver = driver; }

    public DynamicLoadingHiddenElementPage clickExample1() {
        driver.findElement(example1Link).click();
        return new DynamicLoadingHiddenElementPage(driver);
    }

    public DynamicLoadingRenderedElementPage clickExample2() {
        driver.findElement(example2Link).click();
        return new DynamicLoadingRenderedElementPage(driver);
    }

    /**
     *  This line: <code>driver.findElement(example1Link).sendKeys(Keys.CONTROL, Keys.RETURN);</code>
     *  simulates pressing <code>Ctrl</code> + <code>Enter</code> on the focused element.
     *  <br><br>
     *  <i>Can be done using <code>Key + Mouse Click</code></i>:
     *  <pre>
     *      {@code
     *      WebElement link = driver.findElement(example1Link);
     *      Actions actions = new Actions(driver);
     *
     *      actions.keyDown(Keys.CONTROL)   // Hold down a key.
     *             .click(link)             // Click it.
     *             .keyUp(Keys.CONTROL)     // Release the key.
     *             .build()                 // creates a composite action — a single atomic sequence of
     *                                      // all the actions you chained (keyDown, click, keyUp).
     *                                      // Which means: packages up all your steps into one Action object.
     *             .perform();              // executes that Action // Perform the whole built sequence all at once, in order.
     *      }
     *  </pre>
     */
    public DynamicLoadingRenderedElementPage openLinksInNewTabs() {
        driver.findElement(example1Link).sendKeys(Keys.CONTROL, Keys.RETURN);
        driver.findElement(example2Link).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingRenderedElementPage(driver);
    }
}
