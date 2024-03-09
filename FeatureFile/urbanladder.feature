Feature: Display Bookshelves

  @smoke @regression
  Scenario: Display Bookshelves as per the user requirements
    Given user opens urbanladder website
    When user searches for Bookshelves
    And select the price range below fifteen thousand
    And chooses the category Kid Bookshelves
    And exclude out of stock
    And sorts by price High to Low
    Then fetch the top three items & print all details in console output

  @regression
  Scenario: Get sub menu items under living module
    Given user opens urbanladder website
    When user clicks on the living menu
    Then retrieve all items under Living Storage sub-menu and print the same on the console

  @smoke @regression
  Scenario: select the gift card
    Given user opens urbanladder website
    When user clicks on gift cards
    And chooses Birthday or Anniversary
    And enters the valid amount, month and date
    And clicks on the next button
    And fills To & From details
    Then validate the email id
    When the id is not valid and user gives correct email id
    Then confirm the details in Confirm Details section
    And close the browser
