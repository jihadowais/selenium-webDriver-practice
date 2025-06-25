package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");

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
}
