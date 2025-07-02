package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private final WebDriver driver;
    private final By paragraphAdded = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) { this.driver = driver; }

    /**
     * Scroll until paragraph with an input index number.
     * @param index 1-based.
     */
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        while (getPresentNumberOfParagraphs() < index && index > 0)
            ((JavascriptExecutor) driver).executeScript(script);
    }

    private int getPresentNumberOfParagraphs() {
        return driver.findElements(paragraphAdded).size();
    }
}
