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
        int paragraphsNumber;

        do {
            ((JavascriptExecutor) driver).executeScript(script);
            paragraphsNumber = getPresentNumberOfParagraphs();
        } while (paragraphsNumber<index && index>=1);
    }

    private int getPresentNumberOfParagraphs() {
        return driver.findElements(paragraphAdded).size();
    }
}
