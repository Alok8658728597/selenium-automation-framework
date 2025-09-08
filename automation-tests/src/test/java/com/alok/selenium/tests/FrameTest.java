package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.IFramePage;

public class FrameTest extends BaseTest{
	@Test
	public void switch_toFrame_selectValueFrom_dropdown() throws InterruptedException {
		IFramePage frame=new IFramePage(driver);
		frame.open();
		frame.switchFrameAndPerformAction();
		
		
	}
}