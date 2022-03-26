@Demo

  Feature: To_creatae_test_item

    Scenario Outline: to_create_a_test_item

      Given users is on the login page
      And user enters in "<username>" "<password>" and clicks save button
      And user clicks on ItemsTitles
      And user clicks on Test Item
      And user clicks on Create a New Test Item button
      And user enter name "<name>"
      And user enters description "<description>"
      And user enters price "<price>"
      And user enters Default Min. Value "<Default Min. Value>"
      And user enters Default Max. Value "<Default Max. Value>"
      And user enters the day and time "<day and time>"
      Then user clicks on save button
      Then user validates that creation a test item is succesful



      Examples:

        | username | password   | name      | description    | price | Default Min. Value | Default Max. Value | day and time        |
        | alexxela | Karaca5506 | steteskop | very important | 2500  | 3000               | 5000               | 03/22/2022 12.00 AM |