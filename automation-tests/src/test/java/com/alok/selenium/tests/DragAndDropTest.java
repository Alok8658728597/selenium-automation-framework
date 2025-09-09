package com.alok.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

	@Test
	public void verify_the_dropAndDragnature() {
		DragAndDropPage dragdrop = new DragAndDropPage(driver);
		dragdrop.perform_DragAndDrop();
		WebElement droppedItem = driver.findElement(By.xpath("//p[@id='msg']/following-sibling::img"));
		Assert.assertTrue(droppedItem.isDisplayed());

	}

	// ✅ How do you perform drag and drop using the Actions class?
	// ✅ What is the difference between dragAndDrop() and clickAndHold +
	// moveToElement + release?
	// ✅ What are common reasons dragAndDrop() might fail?
	// ✅ How do you verify that drag and drop was successful?
	// ✅ Can you perform drag and drop on HTML5 elements using Selenium?
	// ✅ What if the drop target doesn’t show any message — how else can you confirm
	// success?

}