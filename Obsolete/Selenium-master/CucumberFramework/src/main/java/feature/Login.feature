#@Login
Feature: Login Functionality


#Background: 
#Given Open the Browser
#Given Load the Application
@Login
Scenario: Verify if the user is able to login to the Application with valid username and password


#Given Open the Browser
#Given Load the Application
Given Enter the username as 'DemoCSR'
Given Enter the password as 'crmsfa'
When Click on Login button
Then Homepage should be displayed


@Login
#@LoginNegative
Scenario: Verify if the user is able to login to the Application with valid username and invalid password

#Given Open the Browser
#Given Load the Application
Given Enter the username as 'Demosalesmanager'
Given Enter the password as 'crmsfa123'
When Click on Login button
But User should not be logged in successfully

@Login
#@Datatable
Scenario: Verify if the user is able to login to the Application with valid username and invalid password

#Given Open the Browser
#Given Load the Application
Given Enter the login details as below
			|username|password|
			|Demosalesmanager|crmsfa|
			|DemoCSR2|crmsfa|
When Click on Logout button

#Scenario Outline: Verify if the user is able to Login to the Application


#Given Open the Browser
#Given Load the Application
#Given Enter the username as <username>
#Given Enter the password as <password>
#When Click on Login button
#Then Homepage should be displayed

#Examples:

#|username|password|
#|'Demosalesmanager'|'crmsfa'|
#|'DemoCSR2'|'crmsfa'|
#|'DemoCSR'|'crmsfa'|



