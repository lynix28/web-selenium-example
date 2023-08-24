@Login @RegressionTest @SanityTest
Feature: Login

    As a User,
    I should be able to access SauceDemo website
    and access my account.

    Background:
        Given Login Page

    @Positive @SmokeTest
    Scenario: Login with valid credential
        When I enter "standard_user" as my username
        And I enter "secret_sauce" as my password
        And I click login button
        Then I success to access the website

    @Negative
    Scenario Outline: Login with invalid credential
        When I enter "<username>" as my username
        And I enter "<password>" as my password
        And I click login button
        Then I see an error message about invalid credential

        Examples:
            | username | password |
            | abc      | def      |
            | 123      | 456      |
            | %^&      | &*^&     |

    @Negative
    Scenario: Login with blocked credential
        When I enter "locked_out_user" as my username
        And I enter "secret_sauce" as my password
        And I click login button
        Then I see an error message about blocked credential