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

    public DynamicLoadingRenderedElementPage openLinksInNewTabs() {
        driver.findElement(example1Link).sendKeys(Keys.CONTROL, Keys.RETURN);
        driver.findElement(example2Link).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingRenderedElementPage(driver);
    }
}
