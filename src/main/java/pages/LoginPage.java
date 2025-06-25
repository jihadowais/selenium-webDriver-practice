package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//*[@id=\"login\"]/button");

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void setUsernameInput(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click(); // submit();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage login(String username, String password) {
        setUsernameInput(username);
        setPasswordInput(password);
        return clickLoginButton();
    }
}
