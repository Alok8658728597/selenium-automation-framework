/*
 * ✅ Cross-Browser Testing with TestNG – Execution Flow & Theory
 *
 * 🔁 Parallel Execution Flow (parallel="tests" in testng.xml):
 *
 * 1️⃣ TestNG reads testng.xml and finds three <test> blocks:
 *     - ChromeTest → browser = "chrome"
 *     - FirefoxTest → browser = "firefox"
 *     - EdgeTest → browser = "edge"
 *
 * 2️⃣ All three tests run simultaneously in separate threads.
 *     - Each test has its own instance of the test class and WebDriver.
 *
 * 3️⃣ For each test:
 *     - @BeforeMethod runs → setup(browserName)
 *     - @Test runs → verifyTitle()
 *     - @AfterMethod runs → tearDown()
 *
 * ✅ Improves speed but requires thread-safe code and proper resource handling.
 *
 * 🔁 Non-Parallel (Sequential) Execution Flow (no parallel attribute):
 *
 * 1️⃣ TestNG reads testng.xml and executes <test> blocks one by one in order.
 *     - ChromeTest runs first → setup → test → teardown
 *     - FirefoxTest runs next → setup → test → teardown
 *     - EdgeTest runs last → setup → test → teardown
 *
 * ✅ Easier to debug and avoids thread-related issues.
 * ❌ Slower than parallel execution.
 *
 * 🧠 Theory Points:
 *
 * - Cross-browser testing ensures your app works across Chrome, Firefox, Edge, etc.
 * - @Parameters("browser") fetches the browser name from testng.xml.
 * - @BeforeMethod is used to initialize the browser before each test method.
 * - WebDriverManager handles driver setup automatically.
 * - @AfterMethod ensures the browser is closed after each test.
 * - Use @Optional("chrome") to provide a default browser when running test class directly.
 * - parallel="tests" enables simultaneous execution of test blocks.
 * - Each test block in testng.xml can pass a different browser parameter.
 * - If a browser is not installed (e.g., Firefox), that test will fail or be skipped.
 */

package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.CrossBrowserBaseTest;

public class CrossBrowserDemoTest extends CrossBrowserBaseTest{
	@Test
	public void validateTitle() {
		driver.get("https://www.google.com");
		String title=driver.getTitle();
		System.out.println("Title of the page:" +title);
		Assert.assertTrue(title.contains("Google"),"Title does not contain Google");
	}
}