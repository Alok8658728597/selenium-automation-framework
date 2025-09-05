// ✅ Use sendKeys() for input type="file" elements — this is the simplest way to upload files
// ❗ Use AutoIT or Robot class only for non-standard file upload dialogs (e.g., OS-level popups)

package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadDownload {
	private WebDriver driver;

	// ✅ URL of the file upload demo page
	private final String url = "https://www.testautomationcentral.com/demo/file_upload.html";

	// ✅ Locator for the file input element (standard HTML input)
	private final By chooseFile = By.id("file-input");

	// ✅ Constructor to initialize WebDriver (important for Page Object Model)
	public FileUploadDownload(WebDriver driver) {
		this.driver = driver;
	}

	// ✅ Opens the file upload page in the browser
	public FileUploadDownload open() {
		driver.get(url); // Navigates to the upload page
		return this; // Enables method chaining
	}

	// ✅ Uploads the file and returns the success message
	public String uploadFile() {
		// ✅ Locate the file input and send the file path
		WebElement uploadElement = driver.findElement(chooseFile);
		uploadElement.sendKeys("C:\\Users\\ALSWAIN\\Downloads\\New folder.zip"); // Absolute path required

		// ✅ Click the Upload button to trigger the upload
		driver.findElement(By.xpath("//button[text()='Upload']")).click();

		// ✅ Locate the success message using partial match (contains)
		WebElement message = driver.findElement(By.xpath("//p[contains(text(),'uploaded successfully.')]"));

		// ✅ Return the dynamic success message for assertion in test class
		return message.getText();
	}

	public void downloadFile() throws InterruptedException {
		driver.get("https://demo.automationtesting.in/FileDownload.html");

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement downloadlink = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(@href,\"AutomationTesting/raw/master/samplefile.pdf\")]")));
		wait.until(ExpectedConditions.elementToBeClickable(downloadlink)).click();

		Thread.sleep(9000);
	}
}
