package com.alok.selenium.tests;

// Importing necessary TestNG and project-specific classes
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.listeners.MyListener;

// Attaching the custom listener to this test class.
// MyListener will listen to test events like success, failure, skip, etc.
@Listeners(MyListener.class)
public class ListenersTest extends BaseTest {

    // This test is intentionally designed to fail.
    // It will trigger the onTestFailure() method in MyListener.
    @Test
    public void loginShouldFail() {
        driver.get("https://example.com");
        Assert.assertTrue(false); // This will fail and invoke listener logic
    }

    // This test is designed to pass.
    // It will trigger the onTestSuccess() method in MyListener.
    @Test
    public void loginShouldPass() {
        driver.get("https://example.com");
        Assert.assertTrue(true); // This will pass and invoke listener logic
    }
}
