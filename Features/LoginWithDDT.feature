Feature: Login with valid credentials

@smoke
Scenario Outline: Successful login with valid credentials
Given User Launch browser
And opens URL "http://localhost/opencart/upload/"
When User navigate to MyAccount menu
And click on Login
And User enters Email as "<email>" and Password as "<password>"
And Click on Login button
Then User navigates to MyAccount Page

Examples:

| email                | password |
|pavanol@gmail.com     | test123  |
|sanket2711@gmail.com  |MyPassword|
|sanket2733@gmail.com  |MyPassword|