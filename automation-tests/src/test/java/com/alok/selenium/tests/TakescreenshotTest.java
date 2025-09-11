package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.ScreenshotSpecificBase;
import com.alok.selenium.pages.LoginPage;


public class TakescreenshotTest extends ScreenshotSpecificBase {

	@Test
	public void test_CaptureScreeshot() {
		LoginPage lp=new LoginPage(driver);
		lp.open();
		String actual=driver.getTitle();
		String expected="NotGoogle";
		Assert.assertEquals(actual, expected,"title mis-match");
		
	}

}