package quiz.chapter6;

import org.testng.annotations.DataProvider;

public class HorizontalSliderTestData {
    @DataProvider
    public Object[][] getSliderMovesData() {
        return new Object[][] {
                {0, 0, "0"}, // no moves
                {1, 1, "0"}, // go & back => initial state
                {1, 0, "0.5"}, // move right only
                {0, 1, "0"}, // edge == move left only
                {8, 0, "4"},  // quiz req testcase
                {8, 3, "2.5"}, // move right & left
                {10, 0, "5"}, // max
                {11, 0, "5"} // edge => exceeding range
        };
    }
}
