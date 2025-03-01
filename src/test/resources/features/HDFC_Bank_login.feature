@uat @regression
Feature: HDFC Bank Login feature (Functionality)
  
  Backgroud: 
  Given user navigated to the HDFC Bank url
    Then User validated the title of the page

  Scenario Outline: Login to HDFC Bank ## 4 times
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

  @datatable
  Scenario: Verify the fund transfer - HDFC bank
    When User logged in
    And user did fund transfer in different currencies
      | Currency | Amount |
      | INR      |   2000 |
      | USD      |    200 |
      | GBP      |    245 |
    Then user verified the fund transfer status
