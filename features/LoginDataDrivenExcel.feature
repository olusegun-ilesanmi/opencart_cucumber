Feature: Login Data Driven with Excel

  
Scenario Outline: Data Driven Login with valid and Invalid credentials from excel sheet
  Given user launches browser
  And  opens the URL "http://localhost/ocart"
  When user navigates to myAccount menu dropdown
  And clicks on login
  Then user navigates to myAccount page by passing Email and Password with excel row "<row_index>"

    Examples: 
      | row_index  | 
      | 1 |    
      | 2 |  
      | 3 | 
      | 4 | 
