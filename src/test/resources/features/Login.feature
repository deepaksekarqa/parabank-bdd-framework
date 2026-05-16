Feature: ParaBank User Login

  Scenario: Login with newly registered user
    Given I have registered a new ParaBank user
    When I navigate to the login page
    And I login with valid credentials
    Then I should see the Accounts Overview page