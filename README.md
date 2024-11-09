# Naukri Profile Automation

This project is an automation framework built to streamline the process of updating the resume headline on a Naukri profile. The automation navigates through the login and profile sections, reaching the resume headline section to update the content.

## Project Overview

- **Goal**: Automate the process of updating the resume headline on the Naukri profile.
- **Tech Stack**: Selenium, Java, TestNG
- **Framework**: Hybrid framework, using the Page Object Model (POM) and utility functions for reusability
- **Continuous Integration**: Planned integration with Jenkins for CI

## Features

1. **Login Automation**: Automatically logs into the Naukri profile.
2. **Profile Navigation**: Navigates to the profile section post-login.
3. **Resume Headline Update**: Accesses the resume headline section and updates it with the desired information.
4. **Reusable Utilities**: Utilizes test utility functions to enhance reusability and maintainability of the code.
5. **Hybrid Framework**: Combines multiple design principles for flexibility and maintainability.

## Prerequisites

To run this project, you will need:

- **Java Development Kit (JDK)** (version 8 or higher)
- **Maven** for dependency management
- **Selenium WebDriver** for browser automation
- **TestNG** for test execution and reporting

### Project Structure

The project is organized as follows:

- **src/main/java**
  - **base**: Contains the base setup and driver initialization classes.
  - **pages**: Includes the Page Object Model (POM) classes representing each page of the application.
  - **utils**: Houses utility functions for common actions to ensure code reusability.
  - **configuration file**: Stores configuration settings like login credentials and URLs.
  
- **src/test/java**: Contains TestNG test cases.

### Execution

To execute the tests:

1. Clone the repository to your local machine.
    ```bash
   git clone https://github.com/yourusername/naukri_profile_automation.git
3. Run `mvn clean install` to build the project.
4. Run `testng.xml` to execute the test suite from the IDE, or use the following command from the terminal:

   ```bash
   mvn test
