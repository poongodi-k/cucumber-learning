Feature: Login feature

  
  Scenario: Login successful
    Given user go to login page
    Then user enter the username
    And user enter the password
    And click submit button

  Scenario: Login failure
    Given user go to login page
    Then user enter the invalid username
    And user enter the invalid password
    And click submit button

  Scenario Outline: Login with different data
    Given user go to login page
    Then user enter the name "<username>"
    And user enter the pwd "<password>"
    And click submit button

    Examples: 
      | username | password     |
      | poongodi | poongodi1234 |
      

  