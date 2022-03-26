
@Demo

Feature: Registration_success_test

  Scenario Outline: US02TC01_Choose_a_username_that_can_contain_any_chars_but_it_cannot_be_blank

    Given user is on the registration page
    And user sends data for the SSN "<SSN>"
    And user sends data for the FirstName "<FirstName>"
    And user sends data for the LastName "<LastName>"
    And user sends data for the Username "<Username>"
    And user sends data for the Email "<Email>"
    And user provides the password "<password>"
    Then user clicks on the register button and see the success message as "<success message>"
    Then user takes screenshot of successful login
    Then user creates the records to a correspondent file

    Examples:
      | SSN         | FirstName | LastName | Username        | Email                       | password  |  | success message    |
      | 223-93-9192 | ali       | bayram   | gglddfggbayramx | tffeasdfggm2a9test@gmail.com | Team82822 |  | Registration Saved |



  Scenario Outline: US02TC03_email_id_cannot_be_created_without_"@"_sign_and_".com"_extension

    Given user is on the registration page
    And user sends data for the SSN "<SSN>"
    And user sends data for the FirstName "<FirstName>"
    And user sends data for the LastName "<LastName>"
    And user sends data for the Username "<Username>"
    And user sends data for the Email without @ sign and .com extension "<Email>"
    And user provides the password "<password>"
    Then user clicks on the register
    Then user takes screenshot of unsuccessful login due to failed email
    Then user creates the records to a correspondent file

    Examples:
      | SSN         | FirstName | LastName | Username   | Email       | password  |
      | 373-93-9822 | ali       | bayram   | alibayramx | team29gmail | Team82822 |


  @email2
  Scenario Outline: US02TC04_email_cannot_be_left_blank

    Given user is on the registration page
    And user sends data for the SSN "<SSN>"
    And user sends data for the FirstName "<FirstName>"
    And user sends data for the LastName "<LastName>"
    And user sends data for the Username "<Username>"
    And user sends data for the blank Email "<Email>"
    And user provides the password "<password>"
    Then user clicks on the register
    Then user takes screenshot of unsuccessful login due to failed email
    Then user creates the records to a correspondent file


    Examples:
      | SSN         | FirstName | LastName | Username   | Email | password  |
      | 373-93-9822 | ali       | bayram   | alibayramx |       | Team82822 |


     #MR.Necip


@test0101
  Scenario: US01_TC01 valid ssn test
    Given user is on the registration page
    Then user provides ssn id "<SSN>"
    Then verify the SSN number is valid

  Scenario: US01_TC02 ssn blank test
    Given user is on the registration page
    And leave the SSN box blank
    Then verify SSN required message is displayed

  Scenario: US01_TC03 ssn without "-" test

    Given user is on the registration page
    And enter nine digit SSN without - ssn "123457896"
    Then verify the SSN invalid message is displayed

  Scenario Outline: US01_TC04 8 digit ssn test

    Given user is on the registration page
    And enter eight digit SSN "<ssn>"
    Then verify the SSN invalid message is displayed
    Examples:
      |   ssn     |
      | 45823698  |
      |342-25-968 |

  Scenario Outline: US01_TC05 10 digit ssn test

    Given user is on the registration page
    And enter ten digit SSN "<ssn>"
    Then verify the SSN invalid message is displayed
    Examples:
      | ssn         |
      |4582369810   |
      |342-25-96825 |

  Scenario Outline: US01_TC06 valid firstname test
  user is on the registration page
    And enter valid firstname "<firstName>"
    Then verify first name is valid
    Examples:
      | firstName   |
      |mahmut       |
      |1234567      |
      |Can123       |
      |/*.,Can12    |


  Scenario: US01_TC07 blank firstname test

    Given user is on the registration page
    And leave first name box blank
    Then verify first name required message is displayed

  Scenario Outline: US01_TC08 valid lastname test

    Given user is on the registration page
    And enter valid lastname "<lastName>"
    Then verify lastname is valid
    Examples:
      |lastName     |
      |Can          |
      |1234567      |
      |Can123       |
      |/*.,Can12    |

  Scenario: US01_TC09 blank lastname test
    Given user is on the registration page
    And leave last name blank
    Then verify last name required message is displayed

    #Mrs.Zehra



  @PasswordStrength
  Scenario Outline: test password strength "<password>"
    Given user is on the registration page
    Given users provides the password "<password>"
    Then user valides the password strength "<rgb>"
    Examples: test data
      | password | rgb                |
      #testing full strength

      #testing at least one small case letter
      | ZEHRA.1  | rgb(221, 221, 221) |
            #testing at least one capital case letter
      | zehra.1  | rgb(221, 221, 221) |
      | Zehra..  | rgb(221, 221, 221) |
      | Zehra11  | rgb(221, 221, 221) |
      | Zehr.1   | rgb(255, 0, 0)     |





    #MR.Edward

  Scenario Outline: user_verifies_that_with_at_least_1_lowercase_char_for_stronger_password

    Given user is on the registration page
    And  user sends data for the SSN "<SSN>"
    And user sends data for the FirstName "<firstname>"
    And user sends data for the LastName "<lastname>"
    And user sends data for the Username "<Username>"
    And user sends data for the Email "<email>"
    And user sends data for the New Password "<newpassword>"
    And user sends data for the New password confirmation "<new password confirmation>"
    Then user clicks on the registration button and see the message registration saved  as "<registration saved>"

    Examples: test_data
      | SSN         | firstname | lastname | Username | email                  | newpassword       | new password confirmation |
      | 385-24-6841 | kelvin    | peter    | friends  | peterfriends@gmail.com | HAPPINESSISJOy84  | HAPPINESSISJOy84          |
      | 841-22-6342 | epp       | man      | save     | wade54@gmail.com       | HAPPINESSISKEy84  | HAPPINESSISKEy84          |
      | 841-22-6343 | epps      | mans     | saves    | waded54@gmail.com      | HAPPINESSISPEACE1 | HAPPINESSISPEACE1         |
      | 841-22-6344 | eppss     | manss    | savess   | wadeds54@gmail.com     | HAPPINESSISLOVE@  | HAPPINESSISLOVE@          |
      | 841-22-6345 | epsss     | mansss   | savesss  | wadedss54@gmail.com    | REALITY           | R                         |
