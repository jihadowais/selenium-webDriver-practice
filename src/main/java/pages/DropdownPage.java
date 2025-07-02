package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private WebElement getDropdownElement() {
        return driver.findElement(dropdown);
    }

    private Select getDropdownSelect() {
        return new Select(getDropdownElement());
    }

    public void selectOption(String option) {
        getDropdownSelect().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedOptions = getDropdownSelect().getAllSelectedOptions();
        return selectedOptions.stream().map(element->element.getText()).collect(Collectors.toList());
    }

    public void setMultipleAttribute() {
        ((JavascriptExecutor)driver).executeScript(
          "arguments[0].setAttribute('multiple', '')", getDropdownElement());
    }

    public void selectMultipleOptions(List<String> options) {
        Select select = getDropdownSelect();
        options.forEach(option -> select.selectByVisibleText(option));
    }

    public boolean isMultiple() {
        return getDropdownSelect().isMultiple();
    }
}
