Feature: Appointment api test

  @Demo
  @ApiAppointmentPost
  Scenario Outline: appointment test
    Given user sets the path parameters
    And user sets the expected data "<firstName>","<lastName>","<ssn>","<email>","<phone>" and "<startDate>"
    And user sends the POST request and receives the response
    When user saves the api records to the correspondent files
    Then user validates the api records

    Examples:  test data
      | firstName | lastName | ssn         | email               | phone        | startDate  |
      | haluk     | bicer    | 233-98-7156 | balik1234@gmail.com | 116-321-8272 | 2022-05-12 |

  @ApiAppointmentGet
  Scenario: api get request for appointment
    Given user sends the get request for appointments data
    And user saves the users data to correspondent files for appointments