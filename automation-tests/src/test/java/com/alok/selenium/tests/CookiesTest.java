/*
 * 🍪 1. What Are Cookies?
 * 
 * Small pieces of data stored in your browser by websites. Used to remember
 * login sessions, preferences, and user activity.
 * 
 * 
 * 🌐 2. Who Creates Cookies?
 * 
 * Websites create cookies using server responses (Set-Cookie) or JavaScript
 * (document.cookie). Browsers store and send cookies automatically when you
 * revisit the site.
 * 
 * 
 * 🔍 3. How to View Cookies (Real Life)
 * 
 * Use Chrome DevTools → Application tab → Cookies You can see:
 * 
 * Cookie name (session_id, PREF, etc.) Value (unique to you) Expiry, Secure,
 * HttpOnly flags
 *  
 * 🧹 4. What Happens If You Delete a Cookie?
 * 
 * You may get logged out Your preferences reset Your cart may empty Tracking
 * may stop temporarily
 * 
 * 
 * 🧪 5. What Selenium Can Do with Cookies
 * 
 * Read cookies: driver.manage().getCookies() 
 * Add cookies:driver.manage().addCookie(...) 
 * Delete cookies:driver.manage().deleteCookieNamed(...) Useful for:
 * 
 * Skipping login Testing logout/session expiry Security testing
 */
package com.alok.selenium.tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.CookiesPage;

public class CookiesTest extends BaseTest {
	String url = "https://the-internet.herokuapp.com/login";
	String cookieName = "rack.session";
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	CookiesPage cook;
	@Test(enabled=false)
	public void verifyLogin() {
	    // Test login functionality
		cook=new CookiesPage(driver,url);
		cook.login(username, password);
	}
	@Test(priority=1)
	public void verifyFetchingAllCookies() {
	    // Test fetching all cookies
		cook=new CookiesPage(driver,url);
		cook.login(username, password);
		cook.getAllCookies();
	}
	@Test(priority=2)
	public void verifyFetchingSingleCookie() {
	    // Test fetching a specific cookie
		cook=new CookiesPage(driver,url);
		cook.login(username, password);
		cook.getSpecficCookieByName(cookieName);
	}
	@Test(priority=3)
	public void loginUsingCookie() throws InterruptedException {
	    // Test login using cookie without credentials
		cook=new CookiesPage(driver,url);
		cook.login(username, password);
		Cookie sessionCookie=cook.getSpecficCookieByName(cookieName);
		driver.manage().deleteAllCookies();
		cook.loginWithCookieValue(sessionCookie);
		Thread.sleep(1500);
		//driver.get("https://the-internet.herokuapp.com/secure"); remeber at end shoudl append secure
		cook.open();
		
	}


}