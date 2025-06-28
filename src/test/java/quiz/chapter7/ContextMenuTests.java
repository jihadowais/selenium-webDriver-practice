package quiz.chapter7;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {
    @Test
    public void verifyContextMenuAlertMessage() {
        ContextMenuPage contextPage = homePage.clickContextMenu();
        contextPage.rightClickHotSpotArea();
        String actualAlertMessage = contextPage.getAlertMessage();
        contextPage.acceptsAlert();
        Assert.assertEquals(actualAlertMessage, "You selected a context menu", "Alert message is not correct.");
    }
}
