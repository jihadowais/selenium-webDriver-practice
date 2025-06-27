package dropdown;

import org.testng.annotations.DataProvider;

public class DropdownTestData {
    @DataProvider
    public Object[][] getDropdownVisibleOptions() {
        return new Object[][] {
                {"Option 1"},
                {"Option 2"},
        };
    }
}
