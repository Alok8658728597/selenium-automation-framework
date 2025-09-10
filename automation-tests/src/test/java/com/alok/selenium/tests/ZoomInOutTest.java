package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.ZoomInAndOutPage;

public class ZoomInOutTest extends BaseTest {
	String url = "https://www.softwaretestingmaterial.com";

	@Test
	public void performAllZoomActions() {
		ZoomInAndOutPage page = new ZoomInAndOutPage(driver, url);
		page.open();
		page.setZoomOut();
		page.setZoomIn();
		page.resetToOriginal();
	}

}