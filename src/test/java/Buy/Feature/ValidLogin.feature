Feature: User Login
  I want to check buying from website

  Scenario Outline: Uer Login with valid credentials and buying
    Given the User open the saucedemo website link
    When Read the data from "<sheetName>" and <RowNumberLogin>
    And the user Assert That the HomePage is displayed
    And Buy The Item
    And Navigate to cart
    And Check out your order
    And Fill the form "<sheetData>" and <RowNumberData>
    And Check the Calculations
    And Done
    Examples:
      | sheetName             | RowNumberLogin   | sheetData | RowNumberData|
      |Login                  |4                 |FormData   | 0            |





