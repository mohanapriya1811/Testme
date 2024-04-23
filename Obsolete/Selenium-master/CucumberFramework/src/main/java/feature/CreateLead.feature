
@CreateLead
Feature: Create Lead functionality of the application


Scenario Outline: Verify if the user is able to create a lead in application

#Given Enter the 'username' as 'Demosalesmanager'
#Given Enter the 'password' as 'crmsfa'
#Given Click on 'Login' button
Given Enter the username as 'DemoCSR'
Given Enter the password as 'crmsfa'
Given Click on Login button
Given Click on CRM/SFA link
When 'My Home' page should be displayed
Given Click on Leads link
When 'Leads' page should be displayed
Given Click on Create Lead link
When 'Create Lead' page should be displayed
Given Enter the companyname as <companyName>
Given Enter the firstname as <firstName>
Given Enter the lastname as <lastName>
When Click on Create Lead button
#Then Lead should be created successfully

Examples:
|companyName|firstName|lastName|
|'TestLeaf'|'Hari'|'Radhakrishnan'|
|'TestLeaf'|'Aravind'|'R'|

