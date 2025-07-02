package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

    public JavaScriptAlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public FramesPage clickFrames() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeDeepDOMPage clickLargeDeepDOM() {
        clickLink("Large & Deep DOM");
        return new LargeDeepDOMPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
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

    public boolean deleteCookie(String cookieName) {
        Cookie cookie = driver.manage().getCookieNamed(cookieName);
        if (cookie != null) {
            driver.manage().deleteCookie(cookie);
            return true;
        }
        return false;
    }

    public boolean isCookieExists(String cookieName) {
        return driver.manage().getCookieNamed(cookieName) != null;
    }
}
