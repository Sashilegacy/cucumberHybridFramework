 Feature: Register Functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account Page
When User enter the below fields
|firstName  |Sashi                           |
|lastName   |Gadiyaram                       |
|telephone  |1234567890                      |
|password   |12345                           |
And User selects Privacy Policy
And User clicks on Continue button
Then User should get created successfully 


Scenario: User creates an account with all fields
Given User navigates to Register Account Page
When User enter the below fields
|firstName  |Sashi                           |
|lastName   |Gadiyaram                       |
|telephone  |1234567890                      |
|password   |12345                           |
And  User selects Yes for Newsletter                           
And  User selects Privacy Policy
And  User clicks on Continue button
Then User should get created successfully 



Scenario: User creates a duplicate account
Given User navigates to Register Account Page
When User enter the below fields with duplicate email
|firstName  |Sashi                           |
|lastName   |Gadiyaram                       |
|email      |sashigadiyaram20072024@gmail.com|
|telephone  |1234567890                      |
|password   |12345                           | 
And User selects Yes for Newsletter                           
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email


Scenario: User creates an account without filling any account details
Given User navigates to Register Account Page
When User dont enter any details into the fields
And User clicks on Continue button
Then User should get a proper warning message for every mandatory fields

