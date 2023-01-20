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
@SmokeTest
Feature: Smoke Tests
  I want to use this template for my sanity tests file

  Scenario: Smoke Test - Swag Labs Navigation test
    Given I navigate to SwagLabs URL
    And I verify title "Swag Labs" is displayed
    Given I navigate to Ultimate URL
    And I verify title "Automation Practice - Ultimate QA" is displayed
    Given I navigate to Ultimate URL
    Given I navigate to Webdriver URL

  #Scenario: Smoke Test - Ultimate QA Navigation test
    #Given I navigate to Ultimate URL
    #And I verify title "Automation Practice - Ultimate QA" is displayed