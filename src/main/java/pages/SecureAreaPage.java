package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private final WebDriver driver;
    private final By logoutButton = By.cssSelector("#content div a");
    private final By alertMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver) { this.driver = driver; }

    public LoginPage logout() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    public boolean isMessageDisplayed() {
        return driver.findElement(alertMessage).isDisplayed();
    }

    public String readAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }

    public boolean isLoggedIn() {
        String url = "https://the-internet.herokuapp.com/secure";
        return url.equalsIgnoreCase(driver.getCurrentUrl());
    }
}
