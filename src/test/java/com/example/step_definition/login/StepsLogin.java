package com.example.step_definition.login;

import org.openqa.selenium.WebDriver;

import com.example.helper.Variable;
import com.example.helper.WebdriverManager;
import com.example.helper.pages.login_page.LoginPage;
import com.example.helper.pages.product_page.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class StepsLogin {
    private WebDriver driver = WebdriverManager.getDriver(Variable.BROWSER);
    private String URL = Variable.BASE_URL;
    private LoginPage loginPage = new LoginPage(driver);
    private ProductPage productPage = new ProductPage(driver);

    @Given("Login Page")
    public void accessLoginPage() throws InterruptedException {
        driver.get(URL);
    }

    @When("^I enter \"([^\"]*)?\" as my username$")
    public void enterUsername(String username) throws InterruptedException {
        loginPage.enterUsername(username);
    }

    @When("^I enter \"([^\"]*)?\" as my password$")
    public void enterPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void clickLogin() throws InterruptedException {
        loginPage.clickLogin();
    }

    @Then("I success to access the website")
    public void checkLogin() throws InterruptedException {
        Boolean result = productPage.checkTitleIsDisplayed();
        String text = productPage.checkTextTitle();

        assertEquals(result, true);
        assertEquals(text, "Products");
    }
}
