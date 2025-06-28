package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private final WebDriver driver;
    private final By tagetArea = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) { this.driver = driver; }

    private WebElement getTargetArea() {
        return driver.findElement(tagetArea);
    }

    public void rightClickHotSpotArea() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTargetArea()).contextClick().perform();
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

    public void acceptsAlert() {
        driver.switchTo().alert().accept();
    }
}
