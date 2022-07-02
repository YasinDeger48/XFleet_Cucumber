Feature: Login Function
  User Story:
  As a user, I should be able to log in

  Background: Users are on the login page
    Given Users are on the login page

  #1-All users can log in with valid credentials
  # (We have 3 types of users such as sales manager, store manager, truck driver).
  #- Driver should land on the "Quick Launchpad" page after successful login
  #- Sales Manager/ Store Manager should land on the "Dashboard" page after successful login
  @ac1 @POI
  Scenario: Login as Truck Driver
    When Truck Driver enters username and password, clicks the login button and should see the "Quick Launchpad"

  @ac1 @POI
  Scenario: Login as Sales Manager
    When Sales Managers enters username and password, clicks the login button and should see the "Dashboard"

  @ac1 @POI
  Scenario: Login as Store Manager
    When Store Managers enters username and password, clicks the login button and should see the "Dashboard"