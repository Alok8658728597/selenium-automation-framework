package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.alok.selenium.base.DownloadLogic;
import com.alok.selenium.pages.FileUploadDownload;

public class FileUploadDownloadTest extends DownloadLogic {
    FileUploadDownload fud;

    @Test(enabled=false)
    public void uploadFileTest() {
        // ✅ Initialize page object with WebDriver
        fud = new FileUploadDownload(driver);

        // ✅ Navigate to the file upload page
        fud.open();

        // ✅ Perform file upload and capture dynamic success message
        String actualMessage = fud.uploadFile();

        // ✅ Assertion using endsWith — useful when message starts with dynamic content (like file name)
        Assert.assertTrue(actualMessage.endsWith("uploaded successfully."),
            "Upload message did not end with expected text. Actual: " + actualMessage);
    }
    @Test
    public void fileDownload() throws InterruptedException {
    	fud = new FileUploadDownload(driver);
    	fud.downloadFile();
    	
    }
}
