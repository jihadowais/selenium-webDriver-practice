package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private final WebDriver driver;
    private final By input = By.id("target");
    private final By result = By.id("result");

    public KeyPressesPage(WebDriver driver) { this.driver = driver; }

    public void enterSpecialKey(String key) {
        Keys pressedKey = Keys.valueOf(key);
        driver.findElement(input).sendKeys(pressedKey);
    }

    public void enterAlphanumericalKey(String key) {
        driver.findElement(input).sendKeys(key);
    }

    public void enterMultipleKeys(String key1, String key2) {
        String pressedKeys = Keys.chord(key1, key2);
        driver.findElement(input).sendKeys(pressedKeys);
    }

    public String getResultMessage() {
        return driver.findElement(result).getText();
    }

    public String getPressedSpecialKeyMessage(String key) {
        enterSpecialKey(key);
        return getResultMessage();
    }

    public String getPressedAlphanumericalKeyMessage(String key) {
        enterAlphanumericalKey(key);
        return getResultMessage();
    }

    public String getPressedMultipleKeysMessage(String key1, String key2) {
        enterMultipleKeys(key1, key2);
        return getResultMessage();
    }
}
