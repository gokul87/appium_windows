Feature: steps.CalculatorTest
    As a User
    I want to use calculator desktop app
    So that I can do my Mathematical calculations

    Scenario: Addition of 2 numbers
      Given I am on the calculator app
      When I add 'one' and 'seven' numbers
      Then I should get 8 displayed in screen
