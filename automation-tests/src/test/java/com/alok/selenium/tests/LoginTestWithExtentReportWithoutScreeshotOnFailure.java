package com.alok.selenium.tests; // Package declaration for organizing test classes

import org.testng.annotations.*; // Importing TestNG annotations for test lifecycle management
import org.openqa.selenium.By; // Importing Selenium By class for locating web elements

import com.alok.selenium.base.BaseTest; // Importing base test class for WebDriver setup/teardown
import com.alok.selenium.utils.ExtentReportManager; // Importing custom utility for Extent Reports
/**
 * Test class to validate login functionality using Extent Reports.
 * This version does not capture screenshots on failure.
 */
public class LoginTestWithExtentReportWithoutScreeshotOnFailure extends BaseTest {

    // Interview Tip: Use @BeforeClass to initialize resources like reports before tests run.
    @BeforeClass
    public void startReport() {
        ExtentReportManager.initReport(); // Initialize Extent Report
    }

    // Interview Tip: Keep test methods focused and descriptive. Use logging for traceability.
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
            // Interview Tip: Always catch exceptions to prevent test crashes and log them properly.
            ExtentReportManager.logFail("Exception occurred: " + e.getMessage()); // Log exception
        }
    }

    // Interview Tip: Use @AfterClass to clean up resources like reports after tests finish.
    @AfterClass
    public void endReport() {
        ExtentReportManager.flushReport(); // Flush the report to write all logs to file
    }
}
