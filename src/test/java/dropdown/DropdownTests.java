package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DropdownPage;

import java.util.List;

public class DropdownTests extends BaseTests {
    @Test(dataProvider = "getDropdownVisibleOptions", dataProviderClass = DropdownTestData.class)
    public void selectOptionTest(String expectedSelectedOption) {
        DropdownPage dropdown = homePage.clickDropdown();
        dropdown.selectOption(expectedSelectedOption);

        List<String> selectedVisibleOptions = dropdown.getSelectedOptions();
        int actualNumberOfSelectedOptions = selectedVisibleOptions.size();
        String actualSelectedVisibleOption = selectedVisibleOptions.getFirst();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualNumberOfSelectedOptions, 1, "The selected options are more than 1 option. It should only select: '" + expectedSelectedOption + "'.");
        softAssert.assertEquals(actualSelectedVisibleOption, expectedSelectedOption, "The chosen selected option: '" + expectedSelectedOption + "', is not the visible option.");
        softAssert.assertAll("Selection error. The number of selected options maybe more than 1 or maybe select the wrong option.");
    }
}
