package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.ToolTipPage;

public class ToolTiptest extends BaseTest {
	String url = "https://practice.expandtesting.com/tooltips";

	@Test
	public void getToolTip() {
		ToolTipPage tpage = new ToolTipPage(driver, url);
		// tpage.getToolTipUsingTitleAttribute();
		tpage.getToolTipUsingActionClass();
	}
}