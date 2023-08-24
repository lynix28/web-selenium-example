@Login @SmokeTest @RegressionTest
Feature: Login

    As a User,
    I should be able to access SauceDemo website
    and access my account.

    Background:
        Given Login Page

    Scenario: Login with valid credential
        When I enter "standard_user" as my username
        And I enter "secret_sauce" as my password
        And I click login button
        Then I success to access the website