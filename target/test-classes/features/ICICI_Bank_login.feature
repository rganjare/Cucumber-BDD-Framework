@Login
Feature: ICICI Bank Login feature (Functionality)
  
  Backgroud: 
  Given user navigated to the ICICI Bank url
    Then User validated the title of the page

  Scenario Outline: Login to ICICI Bank
    When User entered username as "<username>"
    And user entered password as "<password>"
    And user clicked on login button
    Then user verified the login status

    Examples: 
      | username      | password            |
      | BYMAT         | pwd@1234            |
      | BYMAT-inValid | pwd@1234            |
      | BYMAT         | pwd@12343-inValid43 |
      | BYMAT-inValid | pwd@12343-inValid43 |

  @datatable1
  Scenario: Verify the fund transfer
    When User logged in
    And user did fund transfer
    Then user verified the fund transfer status
    And user validated the transfer amount and currency
      | currency | amount |
      | INR      |  20000 |
      | GBP      |    200 |
      | USD      |   3000 |
