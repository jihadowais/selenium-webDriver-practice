package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {
    private final WebDriver driver;
    private By figure;


    public HoversPage(WebDriver driver) { this.driver = driver; }

    private void setFigure(String userName) {
        figure = By.xpath("//div[@class='figure'][.//h5[contains(text(),'name: " + userName + "')]]");
    }

    public void hoverOverFigure(String userName) {
        setFigure(userName);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(figure)).perform();
    }

    public boolean isUserNameDisplayed(String userName) {
        // e.g. xpath("//h5[contains(text(),'Lilly')]");
        return driver.findElement(By.xpath("//h5[contains(text(),'" + userName + "')]")).isDisplayed();
    }

    public boolean isUserProfileLinkDisplayed(String userProfileLink) {
        List<WebElement> viewProfiles = driver.findElements(By.linkText("View profile"));

        for (WebElement element: viewProfiles) {
            if (element.getDomProperty("href").contains(userProfileLink) && element.isDisplayed())
                return true;
        }
        return false;
    }
}
