Feature: Login Test

  Scenario Outline: Login Test scenario

    Given User opens Amazon page
   # When User clicks on signin
    Then User enters "<email>" and "<password>"
    Then User clicks sign in button
    And User is on Home page

    Examples:
      | email             | password      |
      |  |  |

