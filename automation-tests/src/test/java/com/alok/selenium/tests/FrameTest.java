package com.alok.selenium.tests;

import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.IFramePage;

public class FrameTest extends BaseTest{
	@Test(enabled=false)
	public void switch_toFrame_selectValueFrom_dropdown() throws InterruptedException {
		String url="https://demo.automationtesting.in/Frames.html";
		IFramePage frame=new IFramePage(driver,url);
		frame.open();
		frame.switchFrameAndPerformAction();	
	}
	@Test
	public void switch_toNestedFrameAndClickOnLink() throws InterruptedException {
		String url="https://www.dezlearn.com/nested-iframes-example/";
		IFramePage frame=new IFramePage(driver,url);
		frame.open();
		frame.switchToNestedFrame();
		
		
	}
}