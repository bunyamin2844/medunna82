
@Admin_US_20
Feature: Admin delete users

  Scenario Outline: TC_001_Admin delete user test

    Given admin goes to medunna page
    And admin type the username "<username>"
    And admin type the password "<password>"
    And admin cliks sign in buttonn
    And admin navigates to user management page
    And admin clicks the delete buttonn and alert button
    And Admin verifies that user deleted

    Examples:
    |username|password|
    |MedunnaAdmin|1@qweASD|



  Scenario: US_20_TC_002_Admin edit exsisting user and gives new roles


  Scenario: US_20_TC_003_Admin view registered people info
    Given admin goes to medunna page
    And admin type the username "username"
    And admin type the password "password"
    And admin navigates to user management page
    And admin clicks the view button
    And admin verifies all user's info

