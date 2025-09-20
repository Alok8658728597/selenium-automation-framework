package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.LocatorsPage;

public class LocatorTest extends BaseTest{
	
	@Test
	public void test_linkText() {
		LocatorsPage lpg=new LocatorsPage(driver);
		lpg.open();
		lpg.clickOnLink();
		
		Assert.assertTrue(lpg.isContactPageDisplayed(),"Not dispaly the contact page");
	}
	@Test(enabled=false)
	public void test_partialLinkText() {
		LocatorsPage lpg=new LocatorsPage(driver);
		lpg.open();
		lpg.clickOnLink();
	}
	@Test
	public void test_ByXpath() {
		LocatorsPage lpg=new LocatorsPage(driver);
		lpg.open();
		String textWhereClicked=lpg.clickByXpath();
		Assert.assertTrue(textWhereClicked.contains("API Sandbox"), "text not matched");
	}
	
}