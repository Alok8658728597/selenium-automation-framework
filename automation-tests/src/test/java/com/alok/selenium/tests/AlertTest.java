package com.alok.selenium.tests;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.AlertPage;
import com.alok.selenium.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertTest extends BaseTest {
	@Test(enabled = true)
	public void test_simple_alert() {
		AlertPage alert = new AlertPage(driver).open();
		alert.triggerAlert();
		String actualAlertText = alert.getAlertText();
		String expectedAlertText = "I am a JS Confirm";
		Assert.assertEquals(actualAlertText, expectedAlertText, "Alert text does not match");

	}

	@Test(enabled = true)
	public void test_fillAlert_accept() {
		AlertPage alert = new AlertPage(driver).open();
		alert.triggerAlert_filldetials_clickOk();

		alert.acceptAlert();

	}
}