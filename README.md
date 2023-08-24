## web-selenium-example

WebUI automation test example project with Selenium

---

<b>Tools:</b>

- Cucumber-TestNG as test framework and assertion
- Maven as test builder and runner
- Selenium as webdriver client
- Allure as test reporter

---

<b>How to setup:</b>

- Install `Maven`
- Install `Java SE`
- Clone this repository
- Make sure the browsers are installed in the local machine. \
This project support to run in `chrome | edge | firefox | safari`. \
For Safari, you need to enable the webdriver by the following command `safaridriver --enable`.


---

<b>How to run:</b>

<!-- - For all tests -->

   - execute `mvn test`

<!-- - For specific feature using tags

   - `` -->

---

<b>Report:</b>

- The file report will be generated and saved to `target` directory
- To open the report run `mvn allure:report allure:serve`
