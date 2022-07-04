@login @smoke @regression
Feature: Login Function
  User Story:
  As a user, I should be able to log in

  Background: Users are on the login page
    Given Users are on the xfleet login page

    ## AC-01

  @a1
  Scenario Outline: Login as users
    When user is login as a "<users>"
    Then user is on the "<pages>"

    Examples:
      | users         | pages           |
      | Truck Driver  | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |


    ## AC-02

  @a2
  Scenario Outline: Login with invalid credentials
    When user enters valid "<username>" and invalid "<password>"
    And user should be see "<message>"
    And user enters invalid "<username>" and valid "<password>"
    Then user should be see "<message>"

    Examples:

      | username        | password    | message                        |
      | user1           | Userusr123  | Invalid user name or password. |
      | salesmanager444 | UserUser123 | Invalid user name or password. |


    ## AC-03

  @a3
  Scenario: Login without credentials
    When user enters credential as "user1" and "" without password
    And user should be see "Please fill out this field." for password
    And user enters credential as "" and "UserUser123" without username
    Then user should be see "Please fill out this field." for username


    ## AC-04
  @a4
  Scenario: User land on Forgot Password Page
    When user sees the "Forgot your password?" link
    And user can click the "Forgot your password?" link
    And user should be see "Forgot Password" page

    ## AC-05
  @a5
  Scenario: User see the Remember Me
    When user sees the "Remember me on this computer" link
    And user clicks on checkbox
    And user sees checkbox is checked


    ## AC-06
  @a6
  Scenario: User sees in password box
    When user enters "password" in password box
    Then user sees the password as password sign


## AC-07
  @a7
  Scenario Outline: User login with enter key
    When user enters username "<username>"
    And user enters password "<password>"
    And user press the enter button
    Then user sees "<page>"

    Examples:
      | username        | password    | page            |
      | user5           | UserUser123 | Quick Launchpad |
      | salesmanager140 | UserUser123 | Dashboard       |
      | storemanager90  | UserUser123 | Dashboard       |


## AC-08
  @a8
  Scenario Outline: User can see own name in profile menu
    When user is login with "<username>" and "<password>"
    And user is on the "<pages>"
    Then user sees own name "<showName>" in profile menu

    Examples:
      | username        | password    | pages           | showName |
      | user5           | UserUser123 | Quick Launchpad | John Doe |
      | salesmanager140 | UserUser123 | Dashboard       | John Doe |
      | storemanager90  | UserUser123 | Dashboard       | John Doe |

