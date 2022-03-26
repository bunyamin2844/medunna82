

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
|384-37-3827|Team82|UKTEAM|ukteam|uk@gmail.com|uk123.|


  @Demo
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





