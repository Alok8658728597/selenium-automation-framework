package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.MultipleTab;

public class TabTest extends BaseTest{
	@Test
	public void test_handleOfNewTab()  {
		MultipleTab tb=new MultipleTab(driver);
		tb.open();
		tb.chooseNewTab();
	}
}