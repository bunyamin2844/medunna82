@Demo
@room_page
Feature: login feature
  Scenario Outline: login_with_username_and_password
    Given admin on the Login Medunna Page
    And admin enters username "<username>"
    And admin enters password  "<password>"
    And admin clicks sign in button
    Examples:
      |username   |password |
      |gulbahce|Gulbahce123.|


    Scenario Outline: entry room page
      When admin on the room click room button
      And admin create a new room
      And admin give a room number "<roomNumber>"
      And admin give a room type "<roomType>"
      And admin give status
      And admin give a price "<price>"
      And admin give a description "<description>"
      And admin create date "<date>"
      Then close driver

      Examples:
        |roomNumber|roomType|price|description|date|
        |24 |PREMIUM_DELUXE |1.500|hastamiz ozel bakilmali|05/12/2022T03:35 PM|



