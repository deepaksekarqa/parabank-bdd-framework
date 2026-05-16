Feature: ParaBank Bill Payment

  Scenario: Pay a bill successfully after login
    Given I am logged in with a registered user for bill pay
    When I navigate to the Bill Pay page
    And I enter the payee details and submit payment
    Then I should see the bill payment complete message