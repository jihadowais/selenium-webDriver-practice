package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");
    private String title;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.title = driver.getTitle();
    }

    public String getTitle() {
        return title;
    }
    public LoginPage clickFormAuthentication() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }
}
