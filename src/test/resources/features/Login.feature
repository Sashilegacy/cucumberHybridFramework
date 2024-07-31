Feature: Login Functionality

Scenario Outline: Login with Valid Credentials
Given User navigates to Login Page
When User enters valid email address <username> into email address field
And User has entered valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username                |password |
|sashidhar123@gmail.com  |12345    |
|gvn.sashidhar@gmail.com |12345    |
|sashidhar143@gmail.com  |12345    |
 






Scenario: Login with Invalid Credentials
Given User navigates to Login Page
When User enters Invalid email address into email address field
And User has enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch



Scenario: Login with valid email and Invalid Password
Given User navigates to Login Page
When User enters valid email address "gvn.sashidhar@gmail.com" into email address field
And User has enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login with Invalid email and Valid Password
Given User navigates to Login Page
When User enters Invalid email address into email address field
And User has entered valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login without providing any credentials
Given User navigates to Login Page
When User dont enter any email address into email address field
And User dont enter any password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch