package largeDeepDOM;

import base.BaseTests;
import org.testng.annotations.Test;

public class LargeDeepDOMTests extends BaseTests {
    /**
     * This is just for practicing scroll down to an existing DOM element using JavaScript script.
     */
    @Test
    public void scrollToTableTest() {
        homePage.clickLargeDeepDOM().scrollToTable();
    }
}
