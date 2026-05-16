# 🏦 ParaBank – Online Banking Application Testing

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-green?style=flat-square&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-7.15.0-brightgreen?style=flat-square&logo=cucumber)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=flat-square&logo=apachemaven)
![Jenkins](https://img.shields.io/badge/Jenkins-2.555.2-orange?style=flat-square&logo=jenkins)
![Status](https://img.shields.io/badge/Tests-6%2F6%20Passed-brightgreen?style=flat-square)

---

## 📌 Project Overview

End-to-end **BDD Cucumber automation framework** for the ParaBank online banking demo application.  
This project covers the complete banking workflow — from user registration to logout — using **Gherkin feature files**, **Step Definitions**, and a **Jenkins CI/CD pipeline**.

**Application Under Test:** https://parabank.parasoft.com/

---

## 🎯 Test Scenarios Covered

| # | Scenario | Feature File | Result |
|---|----------|-------------|--------|
| 1 | Register new user | Register.feature | ✅ PASSED |
| 2 | Login with registered user | Login.feature | ✅ PASSED |
| 3 | Open new savings account | OpenAccount.feature | ✅ PASSED |
| 4 | Transfer funds between accounts | TransferFunds.feature | ✅ PASSED |
| 5 | Bill payment | BillPay.feature | ✅ PASSED |
| 6 | Logout | Logout.feature | ✅ PASSED |

**Total: 6/6 Passed — 0 Failures — 0 Skips**

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Programming language |
| Selenium WebDriver | 4.18.1 | Browser automation |
| BDD Cucumber | 7.15.0 | BDD framework — Gherkin scenarios |
| TestNG | 7.11.0 | Test runner (AbstractTestNGCucumberTests) |
| Maven | 3.x | Build tool and dependency management |
| WebDriverManager | 5.7.0 | Automatic ChromeDriver management |
| Jenkins | 2.555.2 | CI/CD pipeline — automated test execution |

---

## 📁 Project Structure

```
ParaBankBDD/
├── pom.xml                              Maven build & dependency configuration
├── testng.xml                           TestNG suite — points to TestRunner
└── src/
    ├── main/
    │   └── java/
    │       ├── base/
    │       │   └── BaseClass.java       WebDriver setup, teardown, shared variables
    │       └── pages/
    │           ├── HomePage.java        Register link
    │           ├── RegisterPage.java    Registration form
    │           ├── LoginPage.java       Login form
    │           ├── AccountOverviewPage  Accounts overview validation
    │           ├── OpenNewAccountPage   Open savings account
    │           ├── TransferFundsPage    Fund transfer
    │           ├── BillPayPage          Bill payment
    │           └── LogoutPage           Logout
    └── test/
        ├── java/
        │   ├── stepDefinitions/
        │   │   ├── Hooks.java           @Before + @After (all scenarios)
        │   │   ├── RegisterSteps.java   Register scenario steps
        │   │   ├── LoginSteps.java      Login scenario steps
        │   │   ├── OpenAccountSteps     Open account steps
        │   │   ├── TransferFundsSteps   Transfer funds steps
        │   │   ├── BillPaySteps         Bill pay steps
        │   │   └── LogoutSteps          Logout steps
        │   ├── runner/
        │   │   └── TestRunner.java      Cucumber + TestNG runner class
        │   └── utils/
        │       └── DBUtils.java         SQL/JDBC backend validation pattern
        └── resources/
            └── features/
                ├── Register.feature
                ├── Login.feature
                ├── OpenAccount.feature
                ├── TransferFunds.feature
                ├── BillPay.feature
                └── Logout.feature
```

---

## ⚙️ Prerequisites

- Java 17 or higher installed
- Maven 3.x installed
- Google Chrome browser installed
- Jenkins 2.555.2+ (for CI/CD — optional for local run)

---

## 🚀 How to Run

### Option 1 — Run from Eclipse IDE

1. Clone this repository
   ```bash
   git clone https://github.com/deepaksekarqa/parabank-bdd-framework
   ```
2. Open Eclipse → **File → Import → Maven → Existing Maven Project**
3. Right click `testng.xml` → **Run As → TestNG Suite**

### Option 2 — Run from Command Line (Maven)

```bash
# Clone the repo
git clone https://github.com/deepaksekarqa/parabank-bdd-framework

# Navigate into project
cd parabank-bdd-framework

# Run tests
mvn test
```

### Option 3 — Run via Jenkins

1. Create a **Freestyle Project** in Jenkins
2. Under **Build** → Add build step → **Invoke top-level Maven targets**
3. Set Goals: `test`
4. Set POM path: `pom.xml`
5. Click **Build Now**

---

## 📊 Test Results

```
===============================================
ParaBank BDD Test Suite
Total tests run: 6, Passes: 6, Failures: 0, Skips: 0
===============================================
```

---

## 🔑 Key Implementation Highlights

- **BDD Gherkin** — Feature files written in plain English — readable by non-technical stakeholders
- **Hooks.java** — Centralised `@Before` / `@After` using `io.cucumber.java` — NOT TestNG annotations
- **AbstractTestNGCucumberTests** — Integrates Cucumber with TestNG runner seamlessly
- **SQL Pattern** — `DBUtils.java` with parameterised queries to validate data at the database level
- **Jenkins CI/CD** — `mvn test` triggered on demand — BUILD SUCCESS across multiple builds
- **Auto-navigation** — ParaBank auto-logs in after registration; test navigates to `logout.htm` before login step to handle session correctly

---

## ⚠️ Important Notes

- No credentials are hardcoded — test data is generated dynamically during the Register scenario
- The registered user credentials flow from Register → Login automatically via shared test context
- Jenkins requires **Java 21 minimum** (Jenkins 2.555.2 does not support Java 17)
- SLF4J and CDP warnings in console are harmless and do not affect test execution

---

## 👨‍💻 Author

**Deepak S** — QA Engineer (Automation & Manual Testing)  
📍 Chennai, India  
🔗 [LinkedIn](https://www.linkedin.com/in/deepaksekar7/) | [GitHub](https://github.com/deepaksekarqa)

---

