package utils;

import org.openqa.selenium.WebDriver;

import java.net.URL;

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
}
