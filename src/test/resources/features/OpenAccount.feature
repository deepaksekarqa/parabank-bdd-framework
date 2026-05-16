Feature: ParaBank Open New Account

  Scenario: Open a new savings account after login
    Given I am logged in as a registered user
    When I navigate to Open New Account page
    And I select account type as SAVINGS and submit
    Then I should see the account created success message