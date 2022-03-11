@patient_info_changes
Feature: patient_info

  @patient_view_as_admin
  Scenario: TC01-Patient_info_view_as_an_admin

    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
    And user goes to patient page
    And user validates patients
    And user clicks view icon
    And user validates patient view page

  @patient_edit_as_admin
  Scenario: TC02-Patient_info_edit_as_an_admin

    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
    And user goes to patient page
    And user clicks the edit button
    And user edit information
    And user clicks the save button
    Then admin validates the edit is successful
#    admin cannot search for the new applicant

  @patient_view_as_staff
  Scenario: TC03-Patient_info_view_as_a_staff
    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    And staff clicks view button
    Then staff verify the patient page


  @patient_edit_as_staff
  Scenario: TC04-Patient_info_edit_as_a_staff

    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    And staff clicks the edit button
    And user edit information
    And staff clicks save button







