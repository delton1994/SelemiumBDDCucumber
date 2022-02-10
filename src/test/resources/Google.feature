@tag
Feature: Test Google HomePage
Background: This is the background for all of the tests 
Given User opens the browser


  @GoogleTest
  Scenario: Test Gmail, Images, About and Store links
    Given User opens Google
    And User verifies Gmail link exists
    And User verifies Images link exists
    And User verifies About link exists
    And User verifies Store link exists
    Then User prints all the above link values

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I want to verify the status with <status>

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
      
      
      
  