Feature: Bestbuy CRUD operation check
  I should be able to check CRUD operation on the website

  Scenario Outline:Verify CRUD operation on Bestbuy application
    Given The application is running
    When  I create a new user providing name "<name>", type "<type>", price <price>, upc "<upc>",shippping <shipping>, description "<description>", manufacturer "<manufacturer>", model "<model>", url"<url>"
    Then  I verify that the user is created
    And   I update the user with updatedname "<updatedname>" updatedtype "<updatedtype>", updatedprice <updatedprice>, upc "<upc>",shippping <shipping>, description "<description>", manufacturer "<manufacturer>", model "<model>", url"<url>"
    Then  I verify that the user with updated name "<name1>" is updated successfully
    When  I delete the user with same id
    Then  I verify that the user same id is deleted successfully
    Examples:
      | name                                          |type         |price   |upc     |shipping |description           |manufacturer|model     |url                                                       |updatedname                 |updatedtype        |updatedprice   |
      | Energizer - MAX Batteries AA (4-Pack)7c4zuon  |Battery19491 |10.99   |012345  |10       |Long-lasting battery  |Energizer   |z5x8jt3   |http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack |Energizer - new batteries   |Battery            |12.99          |