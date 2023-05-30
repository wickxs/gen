@genReg
Feature: Avast products tests

  Scenario Outline: Compare catalogue prices with checkout
    Given I open avast products webpage
    And I choose "<product>" product
    And I set number of devices to "<number>" and years to "<years>"
    When I click on subscribe now button
    Then Quantity and prices match
    Examples:
      | product   | number | years   |
      | Essential | 2      | 2 years |