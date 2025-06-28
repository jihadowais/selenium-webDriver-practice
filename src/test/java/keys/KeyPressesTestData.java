package keys;

import org.testng.annotations.DataProvider;

public class KeyPressesTestData {
    @DataProvider
    public Object[][] getSpecialKeysData() {
        return new Object[][] {
                {"BACK_SPACE", "You entered: BACK_SPACE"},
                {"SHIFT", "You entered: SHIFT"},
                {"PAGE_UP", "You entered: PAGE_UP"},
                {"SPACE", "You entered: SPACE"},
                {"ADD", "You entered: ADD"},
                {"ESCAPE", "You entered: ESCAPE"},
        };
    }

    @DataProvider
    public Object[][] getAlphanumericalKeysData() {
        return new Object[][] {
                {"J", "You entered: J"},
                {"/", "You entered: SLASH"},
                {"`", "You entered: BACK_QUOTE"},
        };
    }

    @DataProvider
    public Object[][] getMultipleKeysData() {
        return new Object[][] {
                {"SHIFT", "l", "You entered: L"},
                {"SHIFT", "a", "You entered: A"},
        };
    }
}
