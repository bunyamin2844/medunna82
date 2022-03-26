
@registration @db_user_email

Feature: Database
  Scenario: US2TC05_read_user_information_email
    Given user connects to the database
    And user gets the "email" from "jhi_user" table
#And user reads all of the "email" column data
    And verify "jhi_user" table "email" column contains "alexxela202@gmail.com" data
    Then close the database connection