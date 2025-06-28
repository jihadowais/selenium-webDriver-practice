package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HorizontalSliderPage {
    private final WebDriver driver;
    private final By input = By.tagName("input");
    private final By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) { this.driver = driver; }

    private WebElement accessSlider() {
        return driver.findElement(input);
    }

    public void move(int numberOfRightMoves, int numberOfLeftMoves) {
        List<CharSequence> pressedKeys = new ArrayList<>();

        for (int j=0; j<numberOfRightMoves; j++)
            pressedKeys.add(Keys.ARROW_RIGHT);
        for (int j=0; j<numberOfLeftMoves; j++)
            pressedKeys.add(Keys.ARROW_LEFT);

        accessSlider().sendKeys(Keys.chord(pressedKeys));
    }

    public String getShownNumber() {
        return driver.findElement(range).getText();
    }
}
