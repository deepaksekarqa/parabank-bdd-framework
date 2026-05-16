Feature: ParaBank User Registration

  Scenario: Register a new user successfully
    Given I am on the ParaBank home page
    When I click on the Register link
    And I fill in the registration form
    And I click the Register button
    Then I should see the registration success message