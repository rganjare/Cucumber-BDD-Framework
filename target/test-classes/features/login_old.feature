@Login
Feature: Login to Instagram feature (Functionality)
  I want to use this template for my feature file

	@smoke
  Scenario Outline: Login to Instagram feature
    Given user navigated to the instagram url as "<AppURL>"
    Then User validated the title of the page
    When User entered username as "<username>"
    And user entered password as "<password>"
    And user clicked on login button
    Then user should logged in
    
    Examples:
    |AppURL 	|username|password|
    |https://instagram.com |BYMAT |pwd@1234 |
    |https://instagram.com |BYMAT-inValid |pwd@1234 |
    |https://instagram.com |BYMAT |pwd@12343-inValid43 |
    |https://instagram.com |BYMAT-inValid |pwd@12343-inValid43 |
    
 