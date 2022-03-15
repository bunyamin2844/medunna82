
@Admin_US_20
Feature: Admin delete users

  Scenario Outline:  Admin delete user test

    Given admin goes to medunna page
    And admin type the username "<username>"
    And admin type the password "<password>"
    And admin cliks sign in buttonn
    And admin clicks administration button
    When admin cliks user manegement button
    And admin clicks the delete buttonn

    Examples:
    |username|password|
    |MedunnaAdmin|1@qweASD|


