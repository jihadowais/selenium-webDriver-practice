package scrolling;

import base.BaseTests;
import org.testng.annotations.Test;

public class InfiniteScrollTests extends BaseTests {
    @Test
    public void scrollToFifthParagraphTest() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
