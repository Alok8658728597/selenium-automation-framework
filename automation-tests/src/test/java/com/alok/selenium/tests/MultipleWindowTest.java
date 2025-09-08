
/*How do you handle multiple browser windows in Selenium?
What is the difference between getWindowHandle() and getWindowHandles()?
How do you switch to a specific window and perform actions there?
How do you switch back to the parent window after working in a child window?
How do you validate the window title using TestNG assertions?
Why do you use @BeforeMethod in TestNG and how does it help reduce code duplication?*/
package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.MultipleWindows;

public class MultipleWindowTest extends BaseTest {

	private MultipleWindows mlw;

	@BeforeMethod
	public void setupWindowPage() {
		mlw = new MultipleWindows(driver);
		mlw.open();
	}

	@Test(priority=1)
	public void testWidnowsHandlesMultiple() throws InterruptedException {
		String actual=mlw.switchWindow();
		String expectedTitle="Window Handles Practice - H Y R Tutorials";
		Assert.assertEquals(actual,expectedTitle,"title mismatch");

	}

	@Test(priority=2)
	public void testSelectASpecificWindowFromMultipleWindow() {
		mlw.selectSpecificWindow();
	}
}