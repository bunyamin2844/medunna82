@setting_page
Feature: login feature
  Scenario Outline: login_with_username_and_password
    Given user on the Medunna Page
    And user enters username "<username>"
    And user enters password  "<password>"
    And user clicks sign in button
    Examples:
      |username   |password |
      |C.hernandez|123456|


  Scenario Outline: negative
    Given user on settings page
    When user entry firstname "<firstname>"
    When user entry lastname "<lastname>"
    When user entry email "<email>"

    Examples:
      |firstname|lastname|email|
      |Dr a go| |drago123gmail.com|


  Scenario Outline: positive
    When user entry FirstName "<firstname>"
    When user entry LastName "<lastname>"
    When user entry Email "<email>"
    Then user clicks save button

    Examples:
      |firstname|lastname|email|
      |Drago|mixy|drago123@gmail.com|



