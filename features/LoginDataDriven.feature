
Feature: Login Data Driven

  
Scenario Outline: Data Driven Login with valid and Invalid credentials
  Given user launches browser
  And  opens the URL "http://localhost/ocart"
  When user navigates to myAccount menu dropdown
  And clicks on login
  And enters valid email as "<email>" and password as "<password>"
  And clicks on Login button
  Then user navigates to myAccount page 

    Examples: 
      | email                 | password    | 
      | alicebenson1@qa.team  | testing123  | 
      | salice2@qa.team       | test        | 
