package com.alok.selenium.tests;

// ✅ Java Robot Class Notes for Interview Revision

public class RobotClass {

    // 🔹 What is Robot Class?
    // Robot is a Java class used to simulate keyboard and mouse actions at the OS level.
    // It helps automate tasks that Selenium alone cannot handle — like file upload popups or pressing keys.

    // 🧠 Memory Hook:
    // Robot = Real OS Actions
    // Think of it as a virtual hand that presses keys or moves the mouse.

    // ✅ Minimum Required Code Example:
    // The following code presses and releases the ENTER key using Robot class.

    /*
    import java.awt.Robot;
    import java.awt.event.KeyEvent;

    public class RobotExample {
        public static void main(String[] args) throws Exception {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);   // Press ENTER
            robot.keyRelease(KeyEvent.VK_ENTER); // Release ENTER
        }
    }
    */

    // ✅ When to Use Robot Class:
    // - Handling native file upload dialogs
    // - Pressing keys like ENTER, TAB, ESC
    // - Automating tasks outside the browser

    // 🎯 Interview Tip:
    // "Robot Class helps automate native OS-level interactions that Selenium alone can’t handle —
    // like pressing keys or handling file upload popups."
}