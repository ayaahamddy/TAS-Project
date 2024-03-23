Feature: User Login
  I want to check user Login with Invalid credentials

  Scenario Outline: Uer Login with Invalid credentials
    Given the User open the saucedemo website link
    When Read the data from "<sheetName>" and <RowNumber>
    Then the user Assert That from "<sheetName>" and <RowNumber> the Result is displayed
    Examples:
      | sheetName             | RowNumber   |
      |Login                  |0            |
      |Login                  |1            |
      |Login                  |2            |
      |Login                  |3            |




