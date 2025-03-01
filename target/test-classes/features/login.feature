@AE_Login
Feature: Login feature (Functionality)

  @smoke
  Scenario Outline: Login to Automationexercise application
    Given user navigated to the application url
    Then User validated the title of the page
    When User entered "<username>" and "<password>"
    And user clicked on login button
    Then user should logged in

    Examples: 
      | username                        | password            |
      | BYMATAutomation@gmail.com       | pwd@1234            |
      | rahultest1234@gmail.com         | password@123        |
      | BYMATAutomation1@gmail.com      | pwd@1234            |
      | BYMATAutomation@gmail.com       | pwd@12343-inValid43 |
      | BYMATAutomation342342@gmail.com | pwd@12343-inValid43 |
