Feature: ParaBank Logout

  Scenario: Logout successfully after login
    Given I am logged in with a registered user for logout
    When I click the logout link
    Then I should be returned to the login page