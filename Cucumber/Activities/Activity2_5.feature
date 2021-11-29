
@activity2_5
Feature: Title of your feature

  @SmokeTest
  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the Browser

    Examples: 
      | Username | Password | 
      |  admin   |password  | 
      |adminUser |password  | 
