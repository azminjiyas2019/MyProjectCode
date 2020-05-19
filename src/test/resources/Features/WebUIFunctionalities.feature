#Feature file to validate  test cases for web UI
@Functional
Feature:HomePage Navigation
  Scenario:Verify Product Listing
    Given User navigate to application URL
    When User navigate to HomePage
    Then HomePage is Displayed


  Scenario Outline:Verify Product Listing
    Given User navigate to application URL
    When User navigate to HomePage
    When User select "<Item>"
    Then Productdetails Page is Displayed"<Item>" and "<Products>"
    Examples:
      |Item   |Products|
      | ||
      | |  |
      ||  |

