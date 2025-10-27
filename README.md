# Selenium WebDriver with Java Practice Project - TAU Course

## 📚 Overview

This project is a **practical implementation** of **Selenium WebDriver with Java**, built while following the **Test Automation University Selenium WebDriver Java Course**.  
It demonstrates my hands-on skills in **test automation**, **Java**, **TestNG**, and **web UI automation** best practices.

---

## 🚀 Project Purpose

The goal of this project is to showcase:
- **Automated UI tests** for various web scenarios
- Use of **Java + Selenium + TestNG** as a robust test automation stack
- Solid application of **Page Object Model (POM)** design pattern
- Clean, maintainable, and reusable test code
- **Separation of concerns**, **OOP principles**, **DRY**, and clear **naming conventions**
- Test configuration and lifecycle management with **TestNG**

---

## ⚙️ Technologies Used

| Technology             | Version                        |
|------------------------|--------------------------------|
| **Java**               | 23.0.1 (2024-10-15)            |
| **Selenium WebDriver** | 4.33.0                         |
| **TestNG**             | 7.11.0                         |
| **Maven**              | [Managed by `pom.xml`]         |
| **ChromeDriver**       | 137.0.7151.103                 |
| **Google Chrome**      | Version 137.0.7151.68 (64-bit) |

---

## 🗂️ Project Structure Highlights

#### Framework Layer **`src/main/java`**
- **`pages/`** — All Page Objects following POM pattern (**My implementation**)
- **`utils/`** — Utility classes: event listeners, window/tab managers, cookie managers
- **`instructorPages/`** — Some Page Objects that differs from mine, for comparison (**Instructor's implementation**)
 
#### Test Layer **`src/test/java`**
- **`base/`** — Base test setup: driver config, timeouts, hooks
- **`tests/`** — TestNG test classes for all automated scenarios
- **`quiz/`** — Additional TestNG test classes for quiz practice scenarios (**My implementation**)
- **`instructorSolution/`** — TestNG test classes for and Base Test setup for some automated scenarios that differs from mine, for comparison (**Instructor's solution**)

#### Resources **`resources`**
- **`screenshots/`** — Screenshots of failed test methods, named after the failing test method
- **`chromedriver`** — ChromeDriver executable file

#### Naming Conventions
- **`<pageName>Page.java`** -> Page Object classes containing all Selenium WebDriver interactions for that page
- **`<pageName>Tests.java`** -> TestNG test classes containing test methods for each page
- **`<pageName>TestData.java`** -> TestNG Data Provider classes supplying test data for related tests

#### ✅ Key Notes
>- This structure supports _separation of concerns_ between **framework**, **tests**, and shared **resources**.
>- The _instructorPages_ and _instructorSolution_ packages for comparing my custom implementation with the official course instructor's version.
>- Using clear _naming conventions_ throughout the project to make it easy to read, navigate, and extend.

---

## 📝 Pages & Functionalities Tested

Tests were written for multiple scenarios and pages on [**The Internet**](https://the-internet.herokuapp.com/), including but not limited to:

- **Context Menu Page**
- **Dropdown Page**
- **Dynamic Loading Page**
- **Email Sent Page**
- **File Upload Page**
- **Forgot Password Page**
- **Frames Page**
- **Helper Methods Page**
- **Home Page**
- **Horizontal Slider Page**
- **Hovers Page**
- **IFrame Page**
- **Infinite Scroll Page**
- **JavaScript Alerts Page**
- **Key Presses Page**
- **Large & Deep DOM Page**
- **Login Page**
- **Multiple Windows Page**
- **Nested Frames Page**
- **Secure Area Page**

---

## ✅ Concepts & Skills Applied

This practice project demonstrates:

- **Page Object Model (POM)** for clean page interaction abstraction
- **Reusable Base Test** for driver setup, timeouts, event listeners
- **Window & Tab Management**, **Cookie Management**
- **Implicit, Explicit, and Fluent Waits**
- **JavaScript Executor** for scrolling and custom actions
- **Advanced Actions API** for complex user interactions (keyboard + mouse)
- **Screenshots on Failure**
- **TestNG** test configuration, annotations, soft/hard assertions
- Code style: **DRY**, clear naming, separation of concerns, OOP best practices

---

## ✅ Practiced Concepts & Skills

This project demonstrates:

- **POM (Page Object Model)** for clean separation between test logic & page actions
- **Reusable BaseTest setup** for driver, configuration, timeouts, and event listeners
- **Window, Tab, and Cookie Management**
- **Dynamic waits:** implicit, explicit, fluent waits
- **Advanced user interactions** using Actions API
- **JavaScript execution** for advanced scenarios (e.g., scrolling)
- **Screenshots on failure**
- **Multi-tab handling and switching**
- **TestNG** features: test configuration, annotations, soft/hard assertions
- **Good practices:** DRY, clean code, meaningful naming, code readability

---

## 📑 Notes

- This project is for **practice purposes only**.
- It aligns with the structure taught by **Test Automation University**’s Selenium WebDriver Java course.
- Aims to demonstrate readiness for **real-world UI test automation** with a strong foundation in best practices.

---

## 🔗 Tested URL

> **Site under test:** [https://the-internet.herokuapp.com/](https://the-internet.herokuapp.com/)

A reliable practice playground for web UI automation learners.

---

## ✅ How to Run

1. Clone this repository.
2. Install ChromeDriver version **137.0.7151.103** and ensure it matches your Chrome browser.
3. Run the tests via **Maven** or your preferred **IDE** using **TestNG**.

---

## 📬 Contact

For any feedback or suggestions, feel free to reach out or submit an issue.  
Thank you for reviewing my automation practice project!

---

