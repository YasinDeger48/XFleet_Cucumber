Feature: Login Function
  User Story:
  As a user, I should be able to log in

  Background: Users are on the login page
    Given Users are on the login page

@oracle
    Scenario: User login xfleet site
      When User enters username
      And User enters password
      And User clicks login button
      Then User should see xfleet homepage