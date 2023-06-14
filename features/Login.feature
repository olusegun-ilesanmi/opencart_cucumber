Feature: Login with valid credentials 

@Sanity
Scenario: Successful login with valid credentials 
  Given user launches browser
  And  opens the URL "http://localhost/ocart"
  When user navigates to myAccount menu dropdown
  And clicks on login
  And enters valid email as "alicebenson1@qa.team" and password as "testing123"
  And clicks on Login button
  Then user navigates to myAccount page