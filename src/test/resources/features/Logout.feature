Feature: Log out function

  User Story :

  As a user, I should be able to log out

  Background: user is on the xfleet homepage
    Given user is on login page
    And user is on the home page


@ac1x
  Scenario: user can log out successfully
    When user clicks over name
    And user sees the logout "Logout" link
    And user clicks the Logout link
    Then user sees the "Login" page



  @ac2x
  Scenario: user clicks the step back button then can not go back home page
    When user clicks the step back button
    And user sees the "Login" page
    And user clicks the step forward button
    Then user can not see homepage again


    @ac3x
    Scenario: user must be log out after closing the tab or tabs
      When user closes the tabs
      And user enters the homepage link again
      Then user sees the "Login" page




