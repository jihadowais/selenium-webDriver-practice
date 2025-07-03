package multipleWindows;

import base.BaseTests;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends BaseTests {
    /**
     * This is not a real test. It's just for practising switching to new tab/window.
     */
    @Test
    public void verifySwitchToNewWindowTest() {
        homePage.clickMultipleWindows().clickLink();
        getWindowManager().switchToTab("New Window");
    }
}
