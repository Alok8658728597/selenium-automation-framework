/*🔹 1. ExtentReports Class

Responsible for managing the entire report lifecycle.
Used to initialize, attach reporters, and flush the report.
Interview Tip: Mention that flush() must be called at the end of the test suite to write all logs to the final HTML report.

🔹 2. ExtentTest Class

Represents a single test case in the report.
Used to log steps, status, and attach screenshots.
Interview Tip: Helps group logs under meaningful test names for better readability.

🔹 3. ExtentSparkReporter Class

Used to configure and generate HTML reports.
Defines the output file path, theme, and visual layout of the report.

🔹 4. Logging Methods

test.log(Status.INFO, "message") → Logs general steps.
test.pass("message") → Logs successful validations.
test.fail("message") → Logs failures, optionally with screenshots.

🔹 5. Attaching Screenshots

Use MediaEntityBuilder.createScreenCaptureFromPath(path).build() to attach screenshots.
Interview Tip: Say this improves debugging and stakeholder visibility.

🔹 6. Report Lifecycle

initReport() → Initializes the report.
createTest("TestName") → Starts logging for a test.
flushReport() → Finalizes and writes the report to disk.

🔹 7. Integration with Selenium

Can be integrated with Selenium WebDriver to log browser actions.
Often used with @BeforeSuite and @AfterSuite in TestNG for setup and teardown.

🔹 8. Real-Time Use Case

“When a test fails, I capture a screenshot using WebDriver and attach it to the Extent Report using MediaEntityBuilder.
.. This helps in visual debugging and makes the report more informative.”*/
package com.alok.selenium.tests;

import org.testng.annotations.*;
import org.openqa.selenium.By;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.utils.ExtentReportManager;
import com.alok.selenium.utils.ScreenshotUtil;
import com.aventstack.extentreports.MediaEntityBuilder;

/**
 * Test class to validate login functionality with Extent Reports and screenshot capture on failure.
 */
public class LoginTestWithExtentReportWithScreeshotOnFailure extends BaseTest {

    // Interview Tip: Always initialize your reporting framework before test execution begins.
    @BeforeClass
    public void startReport() {
        ExtentReportManager.initReport();
    }

    @Test
    public void loginFunctionality() {
        // Interview Tip: Creating a named test in the report helps in identifying test cases easily.
        ExtentReportManager.createTest("Login Test");

        try {
            // Navigate to login page
            driver.get("https://practicetestautomation.com/practice-test-login/");
            ExtentReportManager.logInfo("Navigated to login page");

            // Enter username
            driver.findElement(By.id("username")).sendKeys("student");
            ExtentReportManager.logInfo("Entered username");

            // Enter password
            driver.findElement(By.id("password")).sendKeys("Password123");
            ExtentReportManager.logInfo("Entered password");

            // Click login button
            driver.findElement(By.id("submit")).click();
            ExtentReportManager.logInfo("Clicked login button");

            // Interview Tip: Always validate the outcome using assertions or URL/content checks.
            boolean loginSuccess = driver.getCurrentUrl().contains("logged-in-successfully");
            if (loginSuccess) {
                ExtentReportManager.logPass("Login successful");
            } else {
                // Interview Tip: Capturing screenshots on failure is a best practice for debugging.
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginTest");
                ExtentReportManager.test.fail("Login failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }

        } catch (Exception e) {
            // Interview Tip: Always handle exceptions gracefully and log them with screenshots.
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginTest_Exception");
            ExtentReportManager.test.fail("Exception occurred: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    // Interview Tip: Flushing the report ensures all logs are written to the final report file.
    @AfterClass
    public void endReport() {
        ExtentReportManager.flushReport();
    }
}
//You can check the report in testoutput folder in source extentreport.html