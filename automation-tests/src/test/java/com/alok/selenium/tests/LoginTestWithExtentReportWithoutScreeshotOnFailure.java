// ✅ try-catch vs throws – Quick Notes

// try-catch is used to handle exceptions immediately where they occur.
// throws is used to declare that a method might throw an exception and pass it to the caller.

// try-catch is mostly used for checked exceptions like IOException, InterruptedException, etc.
// throws is also used for checked exceptions, but it delegates the handling to the calling method.

// You must use try-catch or throws for checked exceptions (compiler will force you).
// For unchecked exceptions (like NullPointerException), it's optional to handle.

// You can chain throws across multiple methods, but eventually someone must handle it using try-catch.

// Use try-catch when:
// - You want to log the error
// - You want to take a screenshot or retry
// - You want to prevent test failure or crash

// Use throws when:
// - You're writing a utility/helper method
// - You want the caller to decide how to handle the exception
// - You want to keep the method clean and simple

// Example:
// public void pause() throws InterruptedException {
//     Thread.sleep(1000); // throws checked exception
// }

// public void test() throws InterruptedException {
//     pause(); // still not handled
// }

// public void runTest() {
//     try {
//         test(); // finally handled
//     } catch (InterruptedException e) {
//         System.out.println("Handled here");
//     }
// }

// Funny Tip: throws = "Not my problem!" 😅
// try-catch = "Okay, I’ll handle it!" 💪

package com.alok.selenium.tests; // Package declaration for organizing test classes

import org.testng.annotations.*; // Importing TestNG annotations for test lifecycle management
import org.openqa.selenium.By; // Importing Selenium By class for locating web elements

import com.alok.selenium.base.BaseTest; // Importing base test class for WebDriver setup/teardown
import com.alok.selenium.utils.ExtentReportManager; // Importing custom utility for Extent Reports

/**
 * Test class to validate login functionality using Extent Reports. This version
 * does not capture screenshots on failure.
 */
public class LoginTestWithExtentReportWithoutScreeshotOnFailure extends BaseTest {

	// Interview Tip: Use @BeforeClass to initialize resources like reports before
	// tests run.
	@BeforeClass
	public void startReport() {
		ExtentReportManager.initReport(); // Initialize Extent Report
	}

	// Interview Tip: Keep test methods focused and descriptive. Use logging for
	// traceability.
	@Test
	public void loginFunctionality() {
		ExtentReportManager.createTest("Login Test"); // Create a test entry in the report

		try {
			driver.get("https://practicetestautomation.com/practice-test-login/"); // Navigate to login page
			ExtentReportManager.logInfo("Navigated to login page"); // Log navigation step

			driver.findElement(By.id("username")).sendKeys("student"); // Enter username
			ExtentReportManager.logInfo("Entered username"); // Log username entry
			driver.findElement(By.id("password")).sendKeys("Password123"); // Enter password
			ExtentReportManager.logInfo("Entered password"); // Log password entry

			driver.findElement(By.id("submit")).click(); // Click login button
			ExtentReportManager.logInfo("Clicked login button"); // Log click action

			// Interview Tip: Use URL/content validation to confirm successful login.
			boolean loginSuccess = driver.getCurrentUrl().contains("practice"); // Check if login was successful

			if (loginSuccess) {
				ExtentReportManager.logPass("Login successful"); // Log success
			} else {
				// Interview Tip: Even without screenshots, logging failure helps in debugging.
				ExtentReportManager.logFail("Login failed"); // Log failure
			}

		} catch (Exception e) {
			// Interview Tip: Always catch exceptions to prevent test crashes and log them
			// properly.
			ExtentReportManager.logFail("Exception occurred: " + e.getMessage()); // Log exception
		}
	}

	// Interview Tip: Use @AfterClass to clean up resources like reports after tests
	// finish.
	@AfterClass
	public void endReport() {
		ExtentReportManager.flushReport(); // Flush the report to write all logs to file
	}
}
