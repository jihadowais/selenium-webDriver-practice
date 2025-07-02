package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private final WebDriver driver;
    private final By example1Link = By.cssSelector("#content .example a");

    public DynamicLoadingPage(WebDriver driver) { this.driver = driver; }

    public DynamicLoadingHiddenElementPage clickExample1() {
        driver.findElement(example1Link).click();
        return new DynamicLoadingHiddenElementPage(driver);
    }
}
