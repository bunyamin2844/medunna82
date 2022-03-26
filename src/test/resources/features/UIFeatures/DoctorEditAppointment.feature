@Demo
Feature: Doctor edit appointment
  Background:
    Given go to login page "https://medunna.com/login"
    And sign in as doctor: username "senoler", password "senol123"
    And navigate to my appointments page
    And find the patient and click edit button, patient id:"38936"



  Scenario Outline: US11_TC01 Doctor edit an existing appointment test

    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And verify the appointment updated message
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      | headache  | medicine  | sinus     | paracetemol  | patient    |


  Scenario Outline: US11_TC02 After editing the appointment doctor should see updated appointment
    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And navigate back to my appointments page
    And verify the edited information of the patient appointment, patient id "38936"
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      | headache  | medicine  | sinus     | paracetemol  | patient     |


  @Demo
  Scenario Outline: US11_TC03 Doctor should not be able to edit appointment without typing in Anamnesis field
    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And verify appoitment can't be saved
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      |           | medicine  | sinus     | paracetemol  | patient     |



  Scenario Outline: US11_TC04 Doctor should not be able to edit appointment without typing in Treatment field
    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And verify appoitment can't be saved
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      | headache  |           | sinus     | paracetemol  | patient     |


  Scenario Outline: US11_TC05 Doctor should not be able to edit appointment without typing in Diagnosis field
    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And verify appoitment can't be saved
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      | headache  | medicine  |           | paracetemol  | patient     |

  @test
  Scenario Outline: US11_TC06 Doctor should be able to edit appointment without editing prescription and description fields
    And edit the appointment information: "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
    And click save button
    And verify the appointment updated message
    Then close driver
    Examples:
      | Anamnesis | Treatment | Diagnosis | Prescription | Description |
      | headache  | medicine  |   sinus   |              |             |


  @test
  Scenario: US11_07 User verifies that can only be set as PENDING, COMPLETED or CANCELLED
      #Diger adimlar background'dan
    # Deneme
    Then verify that status can only be set as "PENDING", "COMPLETED" or "CANCELLED"
    Then close driver


