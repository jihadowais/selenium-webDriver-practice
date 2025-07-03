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

    /**
     * <code>driver.getWindowHandles()</code> returns a <code>Set<String></code> → which does not guarantee order by definition.<br>
     * So technically, relying on the last one in the Set to be the newest tab is <b>not guaranteed by the Java Set contract</b>.<br>
     * <br>
     * <b><u>But in practice:</u></b><br>
     * Selenium’s internal implementation does <b>return handles in the order</b> they were opened (because under the hood it’s a <b><i>LinkedHashSet</i></b>).<br>
     * <br>
     * <b><i>So usually the last handle is the newest.</i></b><br>
     * <br>
     * This is convenient but <b>not 100% robust</b> because you’re depending on internal Selenium behavior not guaranteed by the Java Set interface.<br>
     * <hr>
     * ✔ A safer and clearer approach is to <b>collect the handles into a List</b> (which does guarantee order) and pick the last one explicitly.<br>
     * <b><u>Example:</u></b>
     * <pre>
     * {@code
     *      public void switchToNewTab() {
     *          List<String> windows = new ArrayList<>(driver.getWindowHandles());
     *          driver.switchTo().window(windows.get(windows.size() - 1));
     *      }
     * }
     * </pre><br>
     * In this approach, <b>No looping and switching</b> needed to every window in the set, that's unnecessary and inefficient.
     */
    public void switchToNewTab() {
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(window -> driver.switchTo().window(window));
    }

    public int getNumberOfOpenedTabs() {
        return driver.getWindowHandles().size();
    }
}
