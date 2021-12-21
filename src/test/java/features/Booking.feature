Feature: Test

  Scenario: Test
    Given I am on booking home page
    When I change language to "Srpski"
    And I add destination "Jahorina"
    And I add start and end date "14 januar 2022" "22 januar 2022"
    And I set two children with "4" and "1" year old
    And I click Submit button
    And I validate Search results "Jahorina" "14. januar 2022" "22. januar 2022"
    And I validate "2" adults and "2" children and "1" room is chosen
    And I choose filter by "Doručak i večera uključeni"
    Then I choose "heritage-krone" hotel
    And validate that "Heritage Hotel Krone" hotel is opened
