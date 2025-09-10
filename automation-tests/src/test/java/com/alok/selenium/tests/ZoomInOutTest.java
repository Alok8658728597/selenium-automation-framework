package com.alok.selenium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.ZoomInAndOutPage;

public class ZoomInOutTest extends BaseTest {
	String url = "https://practice.expandtesting.com/tooltips";
	

	@Test(groups={"regression"})
	public void performAllZoomOut() {
		ZoomInAndOutPage page = new ZoomInAndOutPage(driver, url);
		page.open();
		page.setZoomOut();
		page.resetToOriginal();
	}

	@Test(groups={"smoke"})
	public void performAllZoomIn() {
		ZoomInAndOutPage page = new ZoomInAndOutPage(driver, url);
		page.open();
		page.setZoomIn();
		page.resetToOriginal();
	}

}