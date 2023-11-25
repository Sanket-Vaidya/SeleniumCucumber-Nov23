Feature: Login with valid credentials

@smoke
Scenario Outline: Successful login with valid credentials
Given User Launch browser
And opens URL "http://localhost/opencart/upload/"
When User navigate to MyAccount menu
And click on Login
Then User navigates to MyAccount Page by passing email and password with excel row "<row_index>"

Examples:

| row_index | 
|1 | 
|2 |
|3 |