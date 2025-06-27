package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class EmailSentPage {
    private final WebDriver driver;
    private final By messageContent = By.id("content");

    public EmailSentPage(WebDriver driver) {this.driver = driver;}

    public String getMessageContent() {
        return driver.findElement(messageContent).getText();
    }

    public boolean isEmailSent() {
        String url = "https://the-internet.herokuapp.com/email_sent";
        return url.equalsIgnoreCase(driver.getCurrentUrl());
    }

    public boolean isOnEmailSentPage() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("/email_sent");
    }
}
