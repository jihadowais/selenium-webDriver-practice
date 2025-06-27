package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select getDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }

    public void selectOption(String option) {
        getDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedOptions = getDropdownElement().getAllSelectedOptions();
        return selectedOptions.stream().map(element->element.getText()).collect(Collectors.toList());
    }
}
