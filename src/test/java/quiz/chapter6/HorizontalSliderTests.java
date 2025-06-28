package quiz.chapter6;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {
    @Test(dataProvider = "getSliderMovesData", dataProviderClass = HorizontalSliderTestData.class)
    public void sliderMovesTest(int numOfRightMoves, int numOfLeftMoves, String expectedShownNumber) {
        HorizontalSliderPage sliderPage = homePage.clickHorizontalSlider();
        sliderPage.moveSlider(numOfRightMoves, numOfLeftMoves);
        String actualShownNumber = sliderPage.getShownNumber();
        Assert.assertEquals(actualShownNumber, expectedShownNumber, "The shown number doesn't reflect the made steps in the slider.");
    }
}
