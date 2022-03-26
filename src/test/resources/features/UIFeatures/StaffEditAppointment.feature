@staffEditAppointment
@Demo
  Feature: Staff edit appointment

    Background:
      Given go to login page "https://medunna.com/login"
      And sign in as doctor: username "CaliskanAdnan", password "Adnan20."
      And navigate to search patient page
      And enters patient's SSN to SSN box "433-42-3434"


    Scenario: US21_TC01 Staff updates appointment
      And find patient and click edit button, patient id:"17193"
      And edit the patient appointment date
      And click save button
      Then verify the appointment updated message
      Then close driver


    Scenario: US21_TC02 Status can be selected PENDING, UNAPPROVED or CANCELLED by staff
      And find patient and click edit button, patient id:"17193"
      Then verify that status can only be set as "UNAPPROVED", "PENDING" or "CANCELLED"
      Then close driver

    Scenario: US21_TC03 Staff should not need to provide Anamnesis, Treatment or Diagnosis as required fields
      And find patient and click edit button, patient id:"17193"
      And leave the Anamnesis, Treatment and Diagnosis fields blank
      And click save button
      Then verify the appointment updated message
      Then close driver


    Scenario: US21_TC04 Staff should be able to select the current doctor for the patient
      And find patient and click edit button, patient id:"17193"
      And select any current doctor from physician dropdown
      And click save button
      Then verify the appointment updated message
      Then close driver


    Scenario:US21_TC05 Staff should be able to view the patients test results
      And find the patient and click show test button
      And navigate to Test Results page
      Then verify test results page
      Then close driver


