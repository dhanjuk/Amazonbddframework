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
Feature: Sign in feature

  
  Scenario: Checking functionality of Sign in module
    Given User must be on homepage by clicking on url "https://www.amazon.com/"
    
    When Use mouse houver on Accounts and list option
    And click on sign in button
    And after entering email or mobile number 
    And click on countinue
    And enter Password and click on remember me and Sign in button
    Then User must be navigate to his or her account

  