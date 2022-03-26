
Feature: Staff

  @Staff

  Scenario:Staff_login
    Given user goes the login page
    When staff types the username "username"
    When staff types the password "password"
    And user clicks sign in button
    And staff goes to search patient page
    And staff search a patient
    And staff clicks show appointments button
    Then staff clicks payment button
    And staff clicks show invoice button


