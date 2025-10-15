
# CI/CD with Jenkins – A Guide for Automation Engineers

## What is CI/CD?
CI/CD stands for:
- **Continuous Integration (CI)**: Developers frequently integrate code into a shared repository. Each integration is verified by automated builds and tests.
- **Continuous Delivery (CD)**: Ensures that code changes are automatically prepared for a release to production.
- **Continuous Deployment**: Every change that passes automated tests is automatically deployed to production.

## Why CI/CD is Important for Test Automation
- Automates test execution on every code change.
- Detects bugs early in the development cycle.
- Reduces manual effort and human error.
- Enables faster and more reliable releases.

## Real-World CI/CD Pipeline Example (Selenium + RestAssured)

1. **Trigger**: Code is merged into the `main` branch on GitHub.
2. **Checkout**: Jenkins pulls the latest code using the Git plugin.
3. **Build**: Jenkins runs `mvn clean install` to compile the code.
4. **Test Execution**:
   - UI Tests: Selenium tests run via `testng.xml`.
   - API Tests: RestAssured tests run using Maven profiles or groups.
5. **Reporting**:
   - Generate Allure or ExtentReports.
   - Publish reports using Jenkins plugins.
6. **Post Actions**:
   - Send email or Slack notifications.
   - Archive artifacts and logs.

## Jenkinsfile (Declarative Pipeline Example)
```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            mail to: 'team@example.com', subject: "Build ${currentBuild.fullDisplayName}", body: "Build completed. Check Jenkins for details."
        }
    }
}
```

## Essential Jenkins Plugins
- **Git Plugin** – For GitHub integration.
- **Maven Integration Plugin** – To run Maven builds.
- **Allure Jenkins Plugin** – For test reporting.
- **HTML Publisher Plugin** – To publish ExtentReports.
- **Email Extension Plugin** – For notifications.

---

# Top CI/CD Interview Questions with Answers

### 1. What is CI/CD and how does it benefit test automation?
CI/CD automates the process of integrating, testing, and delivering code. It ensures faster feedback, early bug detection, and consistent deployments, which are crucial for reliable test automation.

### 2. How do you integrate Selenium and RestAssured tests into a Jenkins pipeline?
I use a Maven project with `testng.xml` and configure Jenkins to pull code from GitHub, build using `mvn clean test`, and publish reports using plugins like Allure or HTML Publisher.

### 3. What is the difference between CI, CD (Delivery), and CD (Deployment)?
- **CI**: Code is built and tested automatically.
- **CD (Delivery)**: Code is ready for deployment but requires manual approval.
- **CD (Deployment)**: Code is automatically deployed to production.

### 4. What is a Jenkinsfile?
A Jenkinsfile is a script that defines the CI/CD pipeline stages using Groovy. It allows version control of the pipeline and supports both declarative and scripted syntax.

### 5. How do you trigger a Jenkins job when code is pushed to GitHub?
By configuring a GitHub webhook and enabling the "GitHub hook trigger for GITScm polling" option in Jenkins.

### 6. What are the key stages in your Jenkins pipeline for automation testing?
- Checkout
- Build
- Test Execution
- Report Generation
- Notifications

### 7. How do you handle test failures in Jenkins?
I analyze the console output and test reports, use retry logic for flaky tests, and configure alerts for failures.

### 8. What plugins have you used in Jenkins?
Git Plugin, Maven Integration Plugin, Allure Plugin, HTML Publisher Plugin, Email Extension Plugin.

### 9. How do you manage test reports in Jenkins?
I generate reports using Allure or ExtentReports and publish them using the respective Jenkins plugins.

### 10. Can you explain a real-world CI/CD pipeline you’ve worked on?
Yes. I set up a Jenkins pipeline for a GitHub-based Selenium + RestAssured project. It triggered on `main` branch merges, built the project with Maven, ran tests, generated Allure reports, and sent email notifications. This helped ensure high-quality releases with minimal manual effort.
