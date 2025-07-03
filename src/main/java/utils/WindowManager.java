package utils;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.Set;

public class WindowManager {
    private final WebDriver driver;
    private final WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void goToPage(String url) {
        navigate.to(url);
    }

    public void goToPage(URL url) {
        navigate.to(url);
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();

        for (String window: windows) {
            driver.switchTo().window(window);
            if (tabTitle.equals(driver.getTitle())) break;
        }
    }

    public void switchToNewTab() {
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(window -> driver.switchTo().window(window));
    }

    public int getNumberOfOpenedTabs() {
        return driver.getWindowHandles().size();
    }
}
