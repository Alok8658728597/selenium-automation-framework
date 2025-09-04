package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage{
	private WebDriver driver;
	private String url="https://practice.expandtesting.com/dropdown";
	private final By withvisibleText=By.xpath("//select[@id='dropdown']");
	private final By withValue=By.xpath("//select[@id='elementsPerPageSelect']");
	
	public DropdownPage(WebDriver driver) {
		this.driver=driver;
	}
	public DropdownPage open() {
		driver.get(url);
		return this;
	}
	public String selectOnText() {
		Select select=new Select(driver.findElement(withvisibleText));
		select.selectByVisibleText("Option 1");
		WebElement selectedOption=select.getFirstSelectedOption();
		return selectedOption.getText();
		
	}
     public String selectOnValue() {
    	 Select select=new Select(driver.findElement(withValue));
 		select.selectByValue("10");
 		WebElement selectedValue=select.getFirstSelectedOption();
 		return selectedValue.getAttribute("value");
	}
	
	
}
