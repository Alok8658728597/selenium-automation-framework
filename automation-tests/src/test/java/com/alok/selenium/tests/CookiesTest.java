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
 * Read cookies: driver.manage().getCookies() Add cookies:
 * driver.manage().addCookie(...) Delete cookies:
 * driver.manage().deleteCookieNamed(...) Useful for:
 * 
 * Skipping login Testing logout/session expiry Security testing
 */