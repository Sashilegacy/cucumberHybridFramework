Feature: Search Functionality

Scenario: User search for a valid product
Given User open the application
When User enters valid product "HP" in search box field
And User clicks on Search button
Then User should get valid Product displayed in search results
 
 
 Scenario: User search for a invalid product
 Given User open the application
 When User enters invalid product "Honda" in search box field
 And User clicks on Search button
 Then User should get a message about no product matching
 
 
 Scenario: user searches without any product
 Given User open the application
 When User dont enter any product name into search box field
 And User clicks on Search button
 Then User should get a message about no product matching