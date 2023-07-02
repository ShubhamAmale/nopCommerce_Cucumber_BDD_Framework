Feature: Customers

	Background: Below are the common steps for each scenario
		Given User launch Chrome Browser
		When User opens URL "https://admin-demo.nopcommerce.com/"
		And User enters Email as "admin@yourstore.com" and password as "admin"
		And Clicks on Login
		Then User can view Dashboard

Scenario: Add a new Customer
	
	When User clicks on Customer Menu
	And clicks on Customer Menu Item
	And Clicks on Add new button
	Then User can view add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
	
Scenario: Search Customer by EmailId
	When User clicks on Customer Menu
	And clicks on Customer Menu Item
	And Enter cutomer EmailId
	When Click on Searh button
	Then User should found email in the searched table
	And close browser 
	
Scenario: Search Customer by Name
	When User clicks on Customer Menu
	And clicks on Customer Menu Item
	And Enter cutomer FirstName
	And Enter cutomer LastName
	When Click on Searh button
	Then User should found Name in the searched table
	And close browser 