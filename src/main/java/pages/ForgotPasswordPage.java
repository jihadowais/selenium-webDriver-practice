package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private By emailInput = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {this.driver = driver;}

    public void setEmailInput(String emailAddress) {
        driver.findElement(emailInput).sendKeys(emailAddress);
    }

    public EmailSentPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

    public EmailSentPage retrievePassword(String emailAddress) {
        setEmailInput(emailAddress);
        return clickRetrievePasswordButton();
    }
}
