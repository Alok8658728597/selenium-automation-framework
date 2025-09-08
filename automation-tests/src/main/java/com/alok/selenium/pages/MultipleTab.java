package com.alok.selenium.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleTab{
	protected WebDriver driver;
	private final String url="https://www.hyrtutorials.com/p/window-handles-practice.html";
	private final By newTabLink=By.id("newTabBtn");
	
	public MultipleTab(WebDriver driver) {
		this.driver=driver;
	}
	public MultipleTab open() {
		driver.get(url);
		return this;
	}
	public void chooseNewTab(){
		String parentTab=driver.getWindowHandle();
		driver.findElement(newTabLink).click();
		// Wait until a new tab is opened (i.e., number of window handles becomes more than 1)
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(driver->driver.getWindowHandles().size()>1);
		Set<String> allTabs=driver.getWindowHandles();
		for(String tab:allTabs) {
			if(!tab.equals(parentTab)) {
				driver.switchTo().window(tab);
				
				System.out.println("Get title of new tab"+driver.getTitle());
			}
		}
		
		driver.switchTo().window(parentTab);
		
	}
}