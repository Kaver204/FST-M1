
@activity1_1
Feature:FirstTest 
  I want to use this template for my feature file

  @SmokeTest
  Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Show how many search results were shown
    And Close the browser

