package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private final WebDriver driver;

    private final String upperFrame = "frame-top";
    private final String bottomFrame = "frame-bottom";

    private final String leftFrame = "frame-left";
    private final String middleFrame = "frame-middle";
    private final String rightFrame = "frame-right";

    private final By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) { this.driver = driver; }

    public String getBottomFrameText() {
        driver.switchTo().frame(bottomFrame);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getLeftFrameText() {
        driver.switchTo().frame(upperFrame);
        driver.switchTo().frame(leftFrame);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getMiddleFrameText() {
        driver.switchTo().frame(upperFrame);
        driver.switchTo().frame(middleFrame);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getRightFrameText() {
        driver.switchTo().frame(upperFrame);
        driver.switchTo().frame(rightFrame);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

}
