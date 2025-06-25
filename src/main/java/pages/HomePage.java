package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static pages.HelperMethods.isValidURL;

public class HomePage {
    private final WebDriver driver;
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final String title;
    private WebElement currentElement;

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

    public void setCurrentElement(String element) {
        currentElement = driver.findElement(By.linkText(element));
    }

    public boolean isCurrentElementDisplayed() {
        return currentElement.isDisplayed();
    }

    public String getCurrentElementURL() {
        return currentElement.getDomProperty("href");
    }

    public Map<String, Boolean> getElementsIsValidURLs() {
        Map elementsIsValidURLs = new HashMap();
        List<WebElement> webElements = driver.findElements(By.tagName("li"));

        for(WebElement element:webElements) {
            elementsIsValidURLs.put(element.getText(), isValidURL(element.findElement(By.tagName("a")).getDomProperty("href")));
        }
        return elementsIsValidURLs;
    }

}
