package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static pages.HelperMethods.isValidURL;

public class HomePage {
    private final WebDriver driver;
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
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgetPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    private void clickLink(String linkTextSelector) {
        driver.findElement(By.linkText(linkTextSelector)).click();
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
