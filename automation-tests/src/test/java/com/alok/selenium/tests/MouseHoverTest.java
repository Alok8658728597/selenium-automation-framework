package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.MouseHoverPage;

public class MouseHoverTest extends BaseTest {
	@Test
	public void hover_TotheElement_and_chooseOneContent() {
		MouseHoverPage hover = new MouseHoverPage(driver);
		String actual = hover.mouseHoverToElement();
		String expected = "Agile - Software Testing Material";
		Assert.assertEquals(actual, expected, "Title Mismatch");
		System.out.println("Actual title:" + actual);
	}
}

//✅ How do you perform mouse hover using the Actions class?
//✅ Why do we use moveToElement() in mouse hover actions?
//✅ What challenges do you face when hovering over dynamic elements?
//✅ How do you verify that the submenu or tooltip appears after hover?
//✅ What is the difference between moveToElement() and click()?
