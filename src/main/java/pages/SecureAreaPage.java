package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By logoutButton = By.cssSelector("#content div a");
    private By alertMessage = By.id("flash");
    private String url = "https://the-internet.herokuapp.com/secure";

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
        if (url.equalsIgnoreCase(driver.getCurrentUrl()))
            return true;
        return false;
    }
}
