Feature: Home page features

  Background: Navigate to home page
    Given user is on home page

  Scenario: Navigate to Banking Home page
    When user gets the title of the page
    Then page title should be "Lloyds Bank - Personal Banking, Personal Finances & Bank Accounts"


  Scenario: Navigate to Current Accounts product page
    When user selects product and service link and clicks on current accounts product link
    Then current account product page should be displayed

