Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And Clicks on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User clicks logout
	Then Page Title should be "Your store. Login"
	And close browser
	
Scenario Outline: Login Data Driven
		Given User launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/"
	And User enters Email as "<email>" and password as "<password>"
	And Clicks on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User clicks logout
	Then Page Title should be "Your store. Login"
	And close browser
	
	Examples:
	 		| email | password |
	 		| admin@yourstore.com | admin |
	 		| admin1@yourstore.com | admin123 |