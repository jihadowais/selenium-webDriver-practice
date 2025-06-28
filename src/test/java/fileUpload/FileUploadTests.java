package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    @Test
    public void verifyUploadFileUsingButtonTest() {
        FileUploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFileByClickingUploadButton("/path/to/your/file/file.extension");
        String actualUploadedFileName = uploadPage.getUploadedFilesName();
        String actualUploadingResultMessage = uploadPage.getUploadingResultMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUploadedFileName, "file.extension", "The uploaded file name is not correct.");
        softAssert.assertEquals(actualUploadingResultMessage, "File Uploaded!", "The uploading success message is not correct.");
        softAssert.assertAll();
    }

    /**
     * Future Test method handling...
     */
    @Test
    public void verifyUploadFileUsingDragDropTest() {
        FileUploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.dragDropFile();
    }
}
