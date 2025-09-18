// INFO: Visible steps in test flow → e.g., "Browser launched", "Navigated to login page"
// DEBUG: Internal details not visible → e.g., "Reading locator from PageFactory", "Fetching data from Excel"
// WARN: Something unexpected but test continues → e.g., "Page took too long to load", "Unexpected alert appeared"
// ERROR: Something went wrong, test may fail → e.g., "Element not found", "Assertion failed"
// FATAL: Critical failure, test can't continue → e.g., "WebDriver crashed", "Missing config file"

package com.alok.selenium.tests;

import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.alok.selenium.base.BaseTest;
import com.alok.selenium.dataprovider.TestData;

public class DataDrivenLoginTestWithLog4j extends BaseTest {

	// Initialize Log4j logger for this test class
	Logger log = Logger.getLogger(DataDrivenLoginTestWithLog4j.class);

	@Test(dataProvider = "excelData", dataProviderClass = TestData.class)
	public void login(String username, String password) {
		try {
			// Log test start with user info
			log.info("Starting login test for user: " + username);

			// Navigate to login page
			log.info("Navigate to Login Page");
			driver.get("https://practicetestautomation.com/practice-test-login/");

			// Log locator usage for username field
			log.debug("Reading user field locator");
			driver.findElement(By.id("username")).sendKeys(username); // Use dynamic data from Excel

			// Log locator usage for password field
			log.debug("Reading password field locator");
			driver.findElement(By.id("password")).sendKeys(password); // Use dynamic data from Excel

			// Log button click action
			log.info("Clicking submit button");
			driver.findElement(By.id("submit")).click();

			// Capture and log page title after login
			String actualTitle = driver.getTitle();
			log.debug("Page title after login: " + actualTitle);

			// Validate login success based on title
			if (actualTitle.contains("Logged In Successfully")) {
				log.info("Login successful for user: " + username);
				Assert.assertTrue(true, "Login passed for valid user: " + username);
			} else {
				log.error("Login failed for user: " + username);
				Assert.fail("Login failed for invalid user: " + username);
			}

		} catch (NoSuchElementException e) {
			// Log element-related issues
			log.error("Element not found during login for user: " + username + " - " + e.getMessage());
		} catch (Exception e) {
			// Log any critical failure that stops test execution
			log.fatal("Critical error during login test for user: " + username + " - " + e.getMessage());
		}
	}
}

// 🔑 Log4j Interview Tips:
// - Use log levels wisely: INFO for flow, DEBUG for internal steps, ERROR/FATAL for failures.
// - Keep log4j.properties external for flexible log control.
// - Logs are essential for debugging failed CI runs and flaky tests.
// - Combine Log4j with reporting tools like ExtentReports for professional test reporting.
//Setting log4j.rootLogger=DEBUG helps during development to capture detailed logs. In production or CI, we usually switch to INFO or WARN to keep logs clean and focused
/*
 * ✅ What is log4j.properties? 
 * It’s a configuration file that tells Log4j:
 * Where to write logs (console, file, etc.) 
 * What format to use ?
 * What log level to capture (INFO, DEBUG, etc.)
 * 
 */