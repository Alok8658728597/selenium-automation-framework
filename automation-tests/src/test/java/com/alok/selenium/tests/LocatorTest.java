package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.LocatorsPage;

public class LocatorTest extends BaseTest{
	
	@Test
	public void test_linkText() {
		LocatorsPage lpg=new LocatorsPage(driver);
		lpg.open();
		lpg.clickOnLink();
		
	}
	@Test(enabled=false)
	public void test_partialLinkText() {
		LocatorsPage lpg=new LocatorsPage(driver);
		lpg.open();
		lpg.clickOnLink();
	}
	
}