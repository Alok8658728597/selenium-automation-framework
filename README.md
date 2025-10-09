
# 🚀 Selenium Automation Framework

This repository contains a real-time Selenium Automation Framework built using **Java**, **TestNG**, and **Maven**, designed for scalable and maintainable UI test automation.

## 📁 Project Structure

```
selenium-automation-framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.alok.selenium/
│   │           ├── base/                     # Base classes (e.g., BaseTest, DriverFactory)
│   │           ├── pages/                    # Page Object classes
│   │           ├── utils/                    # Utility classes (e.g., ExcelUtils, ConfigReader)
│   │           └── listeners/                # TestNG Listeners (e.g., ITestListener implementations)
│   └── test/
│       └── java/
│           └── com.alok.selenium.tests/      # Test classes
├── testng.xml                                # TestNG suite configuration
├── pom.xml                                   # Maven dependencies
└── README.md
```

## ✅ Features

- Page Object Model (POM) design pattern
- TestNG for test execution and assertions
- Maven for build and dependency management
- Git integration for version control
- Covers:
✅Alert Handling – Accept, dismiss, and validate JavaScript alerts
✅File Upload/Download – Automate file selection dialogs and verify downloads
✅ Drag and Drop – Test HTML5 and JavaScript-based drag-and-drop functionality
✅ Mouse Hover – Validate hover-triggered menus or tooltips
✅ Dropdowns – Handle static and dynamic dropdowns (single/multi-select)
✅ Tooltip Validation – Verify tooltip text on hover
✅ Broken Link Detection – Identify and report dead links on a page
✅ Zoom In/Out Functionality – Validate zoom behavior using keyboard/mouse actions
✅ Frame and iFrame Handling – Switch between frames and interact with elements inside
✅ Window Handling – Manage multiple browser windows or tabs
✅ Screenshot Capture on Failure – Automatically capture screenshots for failed tests
✅ Data-Driven Testing – Use Excel or config files to run tests with multiple data sets
✅ Cross-Browser Testing – Run tests on Chrome, Firefox, Edge, etc. (if implemented)
✅ Parallel Test Execution – Execute tests concurrently using TestNG (if implemented)
✅ Custom TestNG Listeners – Log test events, capture screenshots, and generate reports

## 🧪 Sample Test Classes(Example)

- `AlertPageTest.java`
- `DragAndDropTest.java`
- `FileUploadTest.java`
- `ToolTipTest.java`
- `ValidateTheBrokenLinks.java`
- `ZoomInOutTest.java`

## 🔧 Tools & Technologies

- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Git**
- **Eclipse IDE**

## 📸 Development Environment

Developed and maintained in **Eclipse IDE** with Git integration. Active development is visible through staged and committed test files.

## 👤 Author

**Alok Swain**  
📧 Linkdin: www.linkedin.com/in/alokswain3  
🔗 clone: https://github.com/Alok8658728597/selenium-automation-framework.git

