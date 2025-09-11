package com.alok.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.alok.selenium.utils.ScreenshotUtil;

import java.time.Duration;

public class ScreenshotSpecificBase {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options); // Selenium Manager resolves driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@AfterMethod(alwaysRun = true) // This method runs after every @Test method, even if the test is skipped or
									// fails
	public void captureScreenshotOnFailureAndTeardown(ITestResult result) {

		// ITestResult is an interface provided by TestNG that contains details about
		// the test method just executed
		// result.getStatus() returns an int value representing the test result status:
		// 1 = SUCCESS, 2 = FAILURE, 3 = SKIP

		// ITestResult.FAILURE is a constant with value 2, meaning the test has failed
		// So this condition checks: "Did the test fail?"
		if (ITestResult.FAILURE == result.getStatus()) {

			// If the test failed, capture a screenshot using the WebDriver and the test
			// method name
			// result.getName() returns the name of the test method (e.g., "testLogin")
			ScreenshotUtil.captureScreenshot(driver, result.getName());
		}

		// After screenshot logic, quit the browser to clean up resources
		// This ensures no browser remains open after test execution
		if (driver != null) {
			driver.quit();
		}
	}

}