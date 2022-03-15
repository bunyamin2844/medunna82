@Demo
@UIRegistration
Feature: Demo
Scenario Outline: test registration
Given user provides ssn id "<SSN>"
And  user provides firstname and lastname "<firstname>" and "<lastname>"
Then user creates username "<username>"
And user provides also email "<email>"
And user generates the password "<password>"
And user registers and validates
Then user creates the records to a correspondent file
Examples: test data
|SSN|firstname|lastname|username|email|password|
|384-37-3827|Irfan|Pishkin|irfanpish|irfan@gmail.com|asdfA123.|

  Scenario Outline: test appointments
    Given user clicks on make an appointment
    And user provides the appoinment name "<firstname>"
    And user provides the appointment lastname "<lastname>"
    And user provides ssn and email "<SSN>" and "<email>"
    When user provides the phone number "<phoneNumber>"
    And user provides the date "<date>"
    Then user requests appointment and verifies the success message
    Examples: test data
    #*****
      |firstname|lastname|SSN|email|phoneNumber|date|
      |Bunyamin  |bektas  |203-40-2837|b001@gmail.com|253-283-2837|03-30-2022|

  Scenario Outline: appointment test
    Given user sets the path parameters
    And user sets the expected data "<firstName>","<lastName>","<ssn>","<email>","<phone>" and "<startDate>"
    And user sends the POST request and receives the response
    When user saves the api records to the correspondent files
    Then user validates the api records

    Examples:  test data
      | firstName | lastName | ssn         | email               | phone        | startDate  |
      | haluk     | bicer    | 233-98-7156 | balik1234@gmail.com | 116-321-8272 | 2022-05-12 |

