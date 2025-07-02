package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeDeepDOMPage {
    private final WebDriver driver;
    private final By table = By.id("large-table");

    public LargeDeepDOMPage(WebDriver driver) { this.driver = driver; }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();", tableElement);
    }
}
