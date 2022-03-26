Feature: Doctor login

  @Demo

  Scenario Outline: login_with_username_and_password
    Given user is on the login page
    And user enters username "<username>"
    And user enters password  "<password>"
    Then user clicks sign in button.
    Examples:

      |username   |password   |
      |Dr.lindson|Welcome123* |




    Scenario: doctor clicks on my pages
      Given user is on the login page
      Given doctor clicks on my appointments
      And doctor clicks on patient edit button
      And doctor clicks on request inpatient button



