package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * You can implement any method, ex: <br>
     * before/afterAnyCall </br>
     * before/afterAnyWebDriverCall </br>
     * before/afterGet </br>
     * before/afterGetTitle </br>
     * before/afterGetPageSource </br>
     * before/afterClose </br>
     * before/afterQuit </br>
     * before/afterGetWindowHandles </br>
     * before/afterExecuteScript </br>
     * before/afterPerform </br>
     * before/afterAnyWebElementCall </br>
     * before/afterClick </br>
     * before/afterSubmit </br>
     * before/afterSendKeys </br>
     * before/afterClear </br>
     * before/afterGetAttribute </br>
     * before/afterIsEnabled </br>
     * before/afterGetText </br>
     * before/afterFindElements </br>
     * before/afterIsDisplayed </br>
     * before/afterGetCssValue </br>
     * before/afterAddCookie </br>
     * before/afterFullscreen </br>
     * before/afterNewWindow </br>
     * before/afterAlert </br>
 * Search for each of them...
 */
public class EventReporter implements WebDriverListener {
    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        System.out.println(
                "This method will run before clicking any element."
                + "\nYou're clicking the element: "
                + element.getText()
                + "...\n"
        );
    }
}
