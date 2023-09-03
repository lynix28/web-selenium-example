## web-selenium-example

<a href="https://gitlab.com/lynix28/web-selenium-example/-/pipelines"><img alt="pipeline status" src="https://gitlab.com/lynix28/web-selenium-example/badges/master/pipeline.svg" /></a>

WebUI automation test example project with Selenium.

---

<b>Tools:</b>

- Cucumber-TestNG as test framework and assertion.
- Maven as test builder and runner.
- Selenium as webdriver client.
- Allure as test reporter.

---

<b>How to setup:</b>

- Install `Maven`
- Install `Java SE`
- Clone this repository
- Download the webdriver and save the file inside `webdriver` directory (you need to create the directory inside the root project)
- Make sure the browsers are installed in the local machine. \
This project support to run in `chrome | edge | firefox | safari`. \
For Safari, you need to enable the webdriver by the following command `safaridriver --enable`.


---

<b>How to run the test:</b>

<!-- - For all tests -->

   - `mvn test` | to run the test with default settings (Brower = Chrome - Headless = False).
   - `mvn test -Dbrowser=edge` | to run the test with another web browser.
   - `mvn test -Dheadless=true` | to run the test in HEADLESS mode.
   - `mvn test -Dbrowser=edge -Dheadless=true` | to run the test in another web browser and in HEADLESS mode.
   - `mvn test -Dsuite=SmokeTest` | to run the test only for the specific test suite.
   - `mvn test -Dtest=RunnerLogin` | to run the test only for the specific test runner class / file.

<!-- - For specific feature using tags

   - `` -->

---

<b>Report:</b>

- The file report will be generated and saved to `target` directory
- To open the report run `mvn allure:report allure:serve`
