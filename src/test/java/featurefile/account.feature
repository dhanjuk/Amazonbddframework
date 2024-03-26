#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create new account module

  Scenario Outline: Checking functionality of create new account
    Given Must be on homepage and open create new account page
    When enter <YourName> and <Email> and <Password> and <ReenterPassword>
    And click on continue button
    Then User should be on Enter OTP page

Examples: 
      | YourName | Email              | Password | ReenterPassword |
      | jkaurd    | jkaurd28@gmail.com | aaaaaaa  | aaaaaaa           |
      | Tomm      | tomjs76@gmail.com  | ddddddd  | ddddddd           |
      | Adamk     | adjs76@gmail.com   | dddd123  | dddd123           |

   
