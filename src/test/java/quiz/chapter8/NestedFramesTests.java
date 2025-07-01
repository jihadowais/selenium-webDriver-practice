package quiz.chapter8;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NestedFramesTests extends BaseTests {
    @Test
    public void verifyLeftBottomDisplayedTextFramesTest() {
        var framesPage = homePage.clickFrames();
        var nestedFramesPage = framesPage.clickNestedFrames();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left iframe message is incorrect.");
        softAssert.assertEquals(nestedFramesPage.getMiddleFrameText(), "MIDDLE", "Middle iframe message is incorrect.");
        softAssert.assertEquals(nestedFramesPage.getRightFrameText(), "RIGHT", "Right iframe message is incorrect.");
        softAssert.assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom iframe message is incorrect.");
        softAssert.assertAll();
    }
}
