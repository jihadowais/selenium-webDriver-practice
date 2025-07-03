package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingRenderedElementPage {
    private final WebDriver driver;
    private final By startButton = By.cssSelector("#start button");
    private final By displayedMessage = By.cssSelector("#finish h4");

    public DynamicLoadingRenderedElementPage(WebDriver driver) { this.driver = driver; }

    public void clickStartButton() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(displayedMessage));
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(displayedMessage).isDisplayed();
    }

    public boolean isStartButtonExist() {
        return driver.findElement(startButton).isDisplayed();
    }
}
