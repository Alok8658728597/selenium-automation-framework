/*Use a Mnemonic:
G-F-L-U-C-H

Get the page
Find all <a> tags
Loop through them
Use getAttribute("href")
Connect using HttpURLConnection with OpenConnwction
Handle errors and print broken links*/
package com.alok.selenium.tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.alok.selenium.base.BaseTest;

public class ValidateTheBrokenLinks extends BaseTest {
	@Test
	public void validateLinks() {
		driver.get("https://www.dezlearn.com/nested-iframes-example/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				try {
					HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod("HEAD");
					conn.connect();
					int responseCode = conn.getResponseCode();
					if (responseCode >= 400) {
						System.out.println("Broken link: " + url + " → " + responseCode);
					}
				} catch (Exception e) {
					System.out.println("Error checking link:" + url);
				}
			}
		}

	}
}