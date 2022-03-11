@PatientRegistrant
Feature: Patient Info Changes Api

  @get_patient_data_as_admin
  Scenario: api_get_request_for_patient

    Given user set the necessary path params
#    And user sets the expected data "firstname" "lastname" "email" and "phone"
    Given user send the GET request for getting data
    And user validates the edited data






