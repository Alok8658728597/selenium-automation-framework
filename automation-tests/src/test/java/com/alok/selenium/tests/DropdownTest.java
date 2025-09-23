/*Types of Select Methods: 

i. selectByVisibleText Method
ii. selectByIndex Method
iii. selectByValue Method

Types of DeSelect Methods:
i. deselectByVisibleText Method
ii. deselectByIndex Method
iii. deselectByValue Method
iv. deselectAll Method*/
package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.DropdownPage;

public class DropdownTest extends BaseTest  {
	DropdownPage dp;
	@Test(enabled=false)
	public void testtoGetVisiableText() {
		dp=new DropdownPage(driver);
		dp.open();
		String textSelect=dp.selectOnText();
		Assert.assertEquals(textSelect, "Option 1","Dropdown selection by visible text");
		
	}
	@Test(enabled=false)
	public void testtoGetwithValue() {
		dp=new DropdownPage(driver);
		dp.open();
		String selectedValue=dp.selectOnValue();
		Assert.assertEquals(selectedValue, "10","Dropdwon selection based on value");
	}
	@Test(priority=1)
	public void testMultipleselection() throws InterruptedException  {
		dp=new DropdownPage(driver);
		dp.multiDropdownSelection();
		
	}
}