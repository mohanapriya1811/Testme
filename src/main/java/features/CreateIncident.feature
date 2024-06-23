Feature: User should be able to Create an Incident Successfully

Scenario: TC001_Verify if the user should be able to Create an Incident with Request Body

Given Set the End Point for the Service Now Application
Given Set the Authentication for the Service Now Application
Given Set the Content Type for the Create Incident Request
Given Set the Accept Type for the Create Incident Response
Given Set the Query Params for the Create Incident Request
Given Set the Request Body for the Create_Incident Request
When Send the Post Request to Create an Incident
Then Validate the Status Code of the Post Request as 200
And Validate the number field starts with INC

#@RunTest
Scenario: TC002_Verify if the user should be able to Create an Incident with Request Body

Given Set the End Point for the Service Now Application
Given Set the Authentication for the Service Now Application
Given Set the Content Type for the Create Incident Request
Given Set the Accept Type for the Create Incident Response
Given Set the Query Params for the Create Incident Request
Given Set the Request Body for the 'Create_Incident.json' Request
When Send the Post Request to Create an Incident
Then Validate the Status Code of the Post Request as 200
And Validate the number field starts with INC
#@RunTest
Scenario: TC003_Verify if the user should be able to Create an Incident with Request Body

Given Set the End Point for the Service Now Application
Given Set the Authentication for the Service Now Application
Given Set the Content Type for the Create Incident Request
Given Set the Accept Type for the Create Incident Response
Given Set the Query Params for the Create Incident Request
Given Set the Request Body for the 'Create_Incident_Software.json' Request
When Send the Post Request to Create an Incident
Then Validate the Status Code of the Post Request as 200
And Validate the number field starts with INC


Scenario Outline: TC004_Verify if the user should be able to Create an Incident with Request Body

Given Set the End Point for the Service Now Application
Given Set the Authentication for the Service Now Application
Given Set the Content Type for the Create Incident Request
Given Set the Accept Type for the Create Incident Response
Given Set the Query Params for the Create Incident Request
Given Set the Request Body for the <filename> Request
When Send the Post Request to Create an Incident
Then Validate the Status Code of the Post Request as 200
And Validate the number field starts with INC

Examples:

|filename|
|'Create_Incident.json'|
|'Create_Incident_Software.json'|


@RunTest
Scenario: Get All the Incidents From Incident of Service Now Application

Given Set the End Point for the Service Now Application
Given Set the Authentication for the Service Now Application
Given Set the Accept Type for the Create Incident Response
Given Set the Query Params for the Create Incident Request
			|sysparm_fields|number, sys_id, category, short_description, description|
			|category				|software|
			|sysparm_limit	|10|
When Send the Get Request to get all Incident
Then Validate the Status Code of the Post Request as 400
And Validate the number field starts with INC 