@APITestItemcreation

  Feature: test Item creation

    Scenario Outline: Test Item creation

      Given Given user sets the necessary path params
      And user sets the expected data "<name>" "<description>" "<defaultValMin>" "<defaultValMax>" "<createdDate>"
      And user sends the POST request and gets the response for test items
      Then user validates api records  for test items

      Examples: api test data

        | name       | description     | defaultValMin | defaultValMax | createdDate              |
        | Mrmachine3 | very importantt | 1000          | 5000          | 2022-04-25T06:57:15.614Z |

