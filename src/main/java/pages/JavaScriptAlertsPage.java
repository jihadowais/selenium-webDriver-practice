package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private final WebDriver driver;

    private final By alertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private final By confirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private final By promptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    private final By resultMessage = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) { this.driver = driver; }

    public void clickAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickConfirmAlertButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickPromptAlertButton() {
        driver.findElement(promptButton).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void inputText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String readResultMessage() {
        return driver.findElement(resultMessage).getText();
    }
}
