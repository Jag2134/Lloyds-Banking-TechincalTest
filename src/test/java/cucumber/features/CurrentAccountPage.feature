Feature: Current page features

  Background: Navigate to Current Accounts product page
    Given user is on home page
    And user selects product and service link and clicks on current accounts product link

  Scenario: Navigate to Banking Home page
    When user is on current account page
    Then validate expected current accounts displayed on page
    And verify platinum account fee value should be £21