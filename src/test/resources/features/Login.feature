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
@LoginTest @Test1
Feature: Google Login feature
  I want to use this template for my feature file
  
  Background: Navigating to a URL
  Given I navigate to Heroku app URL

  Scenario: Google Navigation test
    Given I navigate to Google URL
    #And I close browser
    
  #Background: Navigating to Cypress URL
  #Given I navigate to Cypress URL
    
  Scenario: Ultimate QA Navigation test
    Given I navigate to Ultimate URL
    #And I close browser
    
  Scenario: Webdriver URL Navigation test
    Given I navigate to Webdriver URL
    #And I close browser