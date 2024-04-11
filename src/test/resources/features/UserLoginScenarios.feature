Feature: User login scenarios

  @Login
  Scenario: User is able to login to SauceDemo using valid credentials
    Given I have navigated to SauceDemo login page
    When I enter valid credentials
    Then I am navigated to the inventory page