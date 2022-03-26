@Smoke
@patient_info_changes
Feature:patient_info

  @patient_view_as_admin
  Scenario:TC01-Patient_info_view_as_an_admin

    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
    And user goes to patient page
    And user validates patients
    And user clicks view icon
    And user validates patient view page

  @patient_edit_and_delete_as_admin
  Scenario:TC02-Patient_info_edit_as_an_admin

    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
    And user goes to patient page
    And user clicks the edit button
    And user edit information
    And user clicks the save button
    And admin validates the edit is successful
    And admin clicks the delete button
    Then verifies the deleting is successful
#    admin cannot search for the new applicant

  @searchbox_is_enable_for_admin
    Scenario:TC03-Searcbox_is_enable_for_admin
    Given user goes the login page
    When admin types the username "username"
    When admin types the password "password"
    And user clicks sign in button
    And user goes to patient page
    Then user verify the search box is enable


  @patient_view_as_staff
  Scenario:TC04-Patient_info_view_as_a_staff
    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    And staff clicks view button
    Then staff verify the patient page


  @patient_edit_and_search_as_staff  ##
  Scenario: TC05-Patient_info_edit_as_a_staff

    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    Then verify the patient information are invoked
    And staff clicks the edit button
    And user edit information
    And staff clicks save button
    Then staff search a patient



    @patient_is_enable_to_delete_as_staff

    Scenario: TC06-Verify_The_delete_is_enable_for_staff

    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    Then verify the delete button is enable the displayed












