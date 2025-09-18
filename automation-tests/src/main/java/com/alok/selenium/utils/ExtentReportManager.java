package com.alok.selenium.utils; // Utility package for reusable reporting logic

// -----------------------------
// Extent Reports Theory Notes:
// -----------------------------
// Extent Reports is a powerful reporting library used in Selenium automation to generate visually rich HTML reports.
// It helps track test execution status (PASS/FAIL/INFO) with optional screenshots and logs.
// Key Classes to Remember:
// - ExtentReports: Main class to manage the report lifecycle.
// - ExtentTest: Represents a single test case in the report.
// - ExtentSparkReporter: Used to configure and generate the HTML report.
// Interview Tip: Mention how Extent Reports improves debugging and stakeholder visibility.
// -----------------------------

import com.aventstack.extentreports.*; // Core Extent Reports classes
import com.aventstack.extentreports.reporter.ExtentSparkReporter; // For HTML report generation

public class ExtentReportManager {

    // Interview Tip: ExtentReports object manages the entire report lifecycle.
    private static ExtentReports extent;

    // Interview Tip: ExtentTest object represents a single test case and logs its steps.
    public static ExtentTest test;

    // Initializes the Extent Report and attaches the Spark Reporter
    public static void initReport() {
        // Interview Tip: ExtentSparkReporter defines the output file and report format.
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

        // Create ExtentReports instance and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    // Flushes the report to write all logs to the HTML file
    public static void flushReport() {
        extent.flush(); // Interview Tip: Always flush the report at the end to finalize it.
    }

    // Creates a new test entry in the report
    public static void createTest(String testName) {
        test = extent.createTest(testName); // Interview Tip: Helps identify and group logs under a test name.
    }

    // Logs an informational message in the report
    public static void logInfo(String message) {
        test.log(Status.INFO, message); // Interview Tip: Use INFO for steps like navigation, input, etc.
    }

    // Logs a pass status in the report
    public static void logPass(String message) {
        test.log(Status.PASS, message); // Interview Tip: Use PASS to mark successful validations.
    }

    // Logs a fail status in the report
    public static void logFail(String message) {
        test.log(Status.FAIL, message); // Interview Tip: Use FAIL for assertion failures or exceptions.
    }
}
