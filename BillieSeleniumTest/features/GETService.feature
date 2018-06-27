
@GETService
Feature: GET the rest service response
		
@GET_REST_Service
Scenario: Hit the rest service for GET
Given I hit the get service
	And I get the response
Then I validate the response
	And validation is successful
