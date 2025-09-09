package com.alok.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.RightAndDoubleClickPage;

public class RightClickDoubleClickTest extends BaseTest {
	@Test(enabled = false)
	public void verify_the_RightClickPerformSuccessfully() {
		RightAndDoubleClickPage rightClick = new RightAndDoubleClickPage(driver);
		String actualText = rightClick.performRightClick();
		String expectedText = "Rate Us";
		Assert.assertEquals(actualText, expectedText, "Text Wrong");

	}

	@Test
	public void verify_The_DoubleClick() {
		RightAndDoubleClickPage doubleClick = new RightAndDoubleClickPage(driver);
		doubleClick.performDoubleClick();
		WebElement successMessage = driver.findElement(By.xpath("//div[text()='Congrats, you double clicked!']"));
		String actualSuccessMessage = successMessage.getText();
		Assert.assertEquals(actualSuccessMessage, "Congrats, you double clicked!", "mismatch");

	}

}

//✅ How do you perform a right-click using the Actions class?
//✅ How do you handle custom context menus triggered by right-click?
//✅ What if the context menu is built using JavaScript — how do you interact with it?
//✅ How do you verify that the right-click action was successful?
//✅ Can you handle browser-native context menus using Selenium?

//✅ How do you perform a double-click using the Actions class?
//✅ What kind of elements respond to double-click actions?
//✅ How do you verify that the double-click action was successful?
//✅ What is the difference between click() and doubleClick()?
//✅ Can you handle alerts or popups triggered by double-click?
