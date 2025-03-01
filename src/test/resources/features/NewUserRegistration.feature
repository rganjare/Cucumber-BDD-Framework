@EndToEnd
Feature: New user registration, verification and Delete the user

  @NewUser
  Scenario: New user registration
    Given user navigated to the application url
    And user entered Name and Email Address
      | BYMAT_Automation | bymatAutomation@gmail.com |
    And user clicked on SignUp button
    And User entered the account information
      | Title | password      | DOB         | First_name | Last_name | Company          | Address | Address2 | Country | State       | City | Zipcode | Mobile_Number |
      | Mr    | password@2024 | 10-May-1999 | Rahul      | Ganjare   | BYMAT Automation | Pune    | Pune2    | India   | Maharashtra | Pune |  411047 |    9076104425 |
    Then Verify user account is created

  @Verification
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
      #| bymatAutomation@gmail.com       | password@2024       |
      #| BYMATAutomation@gmail.com       | pwd@12343-inValid43 |
      #| BYMATAutomation342342@gmail.com | pwd@12343-inValid43 |

  @DeleteUser
  Scenario: Delete Existing user
    Given user navigated to the application url
    When user login with his credntials
      | bymatAutomation@gmail.com | password@2024 |
    Then user should be able to delete the account
