package navigations;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {
    /**
     * This is not a real test. It's just for practice & to utilise the window manager navigation.
     */
    @Test
    public void navigatorTest() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goToPage("https://www.google.com");
    }
}
