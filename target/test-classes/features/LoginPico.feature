Feature: Login

  @pico
  Scenario: login with username and password
    Given I navigate to the login page
    And I enter the following for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the page