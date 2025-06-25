package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By logoutButton = By.cssSelector("#content div a");
    private By successMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver) { this.driver = driver; }

    private LoginPage logout() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    private boolean messageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    private String readDisplayedMessage() {
        return driver.findElement(successMessage).getText();
    }
}
