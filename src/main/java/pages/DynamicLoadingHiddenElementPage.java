package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingHiddenElementPage {
    private final WebDriver driver;
    private final By startButton = By.cssSelector("#start button");
    private final By loadingBar = By.id("loading");
    private final By displayedMessage = By.cssSelector("#finish h4");

    public DynamicLoadingHiddenElementPage(WebDriver driver) { this.driver = driver; }

    public void clickStartButton() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingBar)));

        // Can be done using the fluent wait, the same but with more control
        // FluentWait wait = new FluentWait(driver)
        //         .withTimeout(Duration.ofSeconds(5))
        //         .pollingEvery(Duration.ofSeconds(1))
        //         .ignoring(NoSuchElementException.class);
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(displayedMessage).isDisplayed();
    }

    public String getDisplayedMessage() {
        return driver.findElement(displayedMessage).getText();
    }
}
