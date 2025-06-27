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
        boolean actualIsOptionSelected = selectedVisibleOptions.contains(expectedSelectedOption);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualNumberOfSelectedOptions, 1, "The selected options are more than 1 option. It should only select: '" + expectedSelectedOption + "'.");
        softAssert.assertTrue(actualIsOptionSelected, "The chosen selected option: '" + expectedSelectedOption + "', is not the visible option.");
        softAssert.assertAll();
    }
}
