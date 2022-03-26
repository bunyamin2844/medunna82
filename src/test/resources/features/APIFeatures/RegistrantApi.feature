
@Demo
Feature: Registrant api test



  Scenario Outline: registrant test
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" and "<lan>"
    And user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records

    Examples: api test data
      |firstname|lastname|SSN|email|username|password|lan|
      |Team82 |UKTEAM  |384-37-3827|b001@gmail.com|ukteam|uk123.|en|



