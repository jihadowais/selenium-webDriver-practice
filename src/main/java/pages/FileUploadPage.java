package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private final WebDriver driver;

    private final By inputField = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By dragDropUpload = By.id("drag-drop-upload");
    private final By uploadedFiles = By.id("uploaded-files");
    private final By uploadingResultMessage = By.tagName("h3");

    public FileUploadPage(WebDriver driver) { this.driver = driver; }

    private void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public void uploadFileByClickingUploadButton(String filePath) {
        driver.findElement(inputField).sendKeys(filePath);
        clickUploadButton();
    }

    public void dragDropFile() {
        driver.findElement(dragDropUpload);
    }

    public String getUploadedFilesName() {
        return driver.findElement(uploadedFiles).getText();
    }

    public String getUploadingResultMessage() {
        return driver.findElement(uploadingResultMessage).getText();
    }
}
