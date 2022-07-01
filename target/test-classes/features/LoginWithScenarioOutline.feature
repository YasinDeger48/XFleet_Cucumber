Feature: Login Function
  User Story:
  As a user, I should be able to log in

  Background: Users are on the login page
    Given Users are on the xfleet login page

  @a1
  Scenario Outline: Login as users
    When user is login as a "<users>"
    Then user is on the "<pages>"

    Examples:
      | users         | pages           |
      | Truck Driver  | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |

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


  @a3
  Scenario: Login without credentials
    When user enters credential as "user1" and "" without password
    And user should be see "Please fill out this field." for password
    And user enters credential as "" and "UserUser123" without username
    Then user should be see "Please fill out this field." for username


