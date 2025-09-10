package com.alok.selenium.pages;

/*What is the use of getWindowHandle() and getWindowHandles()?
How do you switch between parent and child windows in Selenium?
Why do we store the parent window handle before opening a new window?
How do you identify and switch to a specific window among multiple ones?
What is the purpose of driver.switchTo().window(windowHandle)?
What happens if you don’t switch back to the parent window after working in a child window?
How do you handle multiple windows opened by clicking the same button repeatedly?
What is the difference between By.id, By.linkText, and other locator strategies?*/
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindows {
	private WebDriver driver;
	private final String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";
	private final By clickLink = By.id("newWindowBtn"); // Corrected ID

	public MultipleWindows(WebDriver driver) {
		this.driver = driver;
	}

	public MultipleWindows open() {
		driver.get(url);
		return this;
	}

	public String switchWindow() throws InterruptedException {
		// Step 1: Store parent window
		String parentWindow = driver.getWindowHandle();

		// Step 2: Click to open new window
		driver.findElement(clickLink).click();

		// Step 3: Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Step 4: Switch to child window and perform action
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				Thread.sleep(1500);
				driver.switchTo().window(window);
				System.out.println("Child window title: " + driver.getTitle());
				driver.findElement(By.linkText("Tech News")).click(); // Example action
				break;
			}
		}

		// ✅ Step 5: Switch back to parent window
		driver.switchTo().window(parentWindow);
		return driver.getTitle();
	}

	public void selectSpecificWindow() {
		String parentWindow = driver.getWindowHandle();
		for (int i = 0; i <= 4; i++) {
			driver.findElement(clickLink).click();
		}
		Set<String> getAllWindow = driver.getWindowHandles();
		int count = 0;
		for (String window : getAllWindow) {
			count++;
			if (count == 3) {
				driver.switchTo().window(window);
				System.out.println("Swithced to 3rd window: " + driver.getTitle());
				driver.findElement(By.linkText("Tech News")).click();
				break;

			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println("Get back to parent window:" + driver.getTitle());
	}
}
