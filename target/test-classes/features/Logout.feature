Feature: Log out function

  User Story :

  As a user, I should be able to log out

  Background: user is on the xfleet homepage
    Given user is on login page
    And user is on the home page


  @FLTAPS-1869  @logout  @TC009
  Scenario: user can log out successfully
    When user clicks over name
    And user sees the logout "Logout" link
    And user clicks the Logout link
    Then user sees the "Login" page



  @FLTAPS-1870  @logout  @TC010
  Scenario: user clicks the step back button then can not go back home page after logout
    When user clicks over name
    And user clicks the Logout link
    And user clicks the step forward button
    Then user can not see homepage again


    @FLTAPS-1871  @logout  @TC011
    Scenario: user must be log out after closing the tab or tabs
      When user close the all xfleet site tabs
      And user enter xfleet site
      And user can see the "Quick Launchpad" site
      Then user is logout the xfleet site





