Feature: ParaBank Transfer Funds

  Scenario: Transfer funds between accounts after login
    Given I am logged in with a registered user for transfer
    When I navigate to the Transfer Funds page
    And I enter transfer amount and select accounts
    Then I should see the transfer complete success message