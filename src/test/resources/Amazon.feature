@tag
Feature: Test Amazon HomePage

  Background: This is the background for all of the tests
    Given User opens the browser

  @amazon
  Scenario: Test Amazon Title,Cart,Address,Descrpition links and nav links exist
    Given User opens Amazon
    And User verifies Amazon title exists
    And User verifies Cart link exists
    And User verifies Address link exists
    And User verifies Description link exists
    And User verifies viewable nav links exists
    Then User prints all above links
    
    Scenario Outline: Verify nav elements
    Given I am on the Amazon home page
    Then I verify the status with <status>
    
    	Examples:
    		|Lists |Action     |Result |
    		|L1,L2 |L1==L2	   |Success|
    		|L1,L2 |L1!=L2	   |Fail   |
