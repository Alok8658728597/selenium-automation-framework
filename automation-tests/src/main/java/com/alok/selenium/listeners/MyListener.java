package com.alok.selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.utils.ScreenshotUtil;

public class MyListener implements ITestListener {

    // Called when a test method starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🔵 Test Started: " + result.getName());
    }

    // Called when a test method passes successfully
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("🟢 Test Passed: " + result.getName());
    }

    // Called when a test method is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("🟡 Test Skipped: " + result.getName());
    }

    // Called when a test method fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("🔴 Test Failed: " + result.getName());
        //The listener is not tied to a specific test class, so it must handle any test class dynamically
        // Get the actual test class object that was executed
        Object testClass = result.getInstance();

        // Cast the object to BaseTest to access WebDriver
        // This works because your test class extends BaseTest
        WebDriver driver = ((BaseTest) testClass).getDriver(); // or alokName()

        // Capture screenshot using your reusable ScreenshotUtil class
        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }
}
//result.getInstance() → gives you the object of the test class that ran.
//Casting to BaseTest → allows access to getDriver() because your test class extends BaseTest.
//Screenshot logic → placed inside onTestFailure() to capture browser state when a test fails.