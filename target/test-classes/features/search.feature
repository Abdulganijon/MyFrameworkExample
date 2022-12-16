Feature: Amazon Search
  @wip
  Scenario: User searches for PS5
    Given User go to home page
    When user search PS5
    And user sorts to High to low
    And user scrolls down to first
    Then user validates the correct price
    Then api status code should be 200



