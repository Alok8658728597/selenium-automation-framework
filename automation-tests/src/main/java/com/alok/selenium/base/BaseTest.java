/*In TestNG, when you use @BeforeMethod, it runs before each test method. 
 * But if your test method is part of a group and you're using <groups> in testng.xml,
 *  TestNG may skip the @BeforeMethod unless you explicitly tell it to always run, even for grouped tests.*/
package com.alok.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
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

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
