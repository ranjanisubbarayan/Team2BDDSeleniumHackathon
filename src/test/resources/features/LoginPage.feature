@loginFeature
Feature: Login functionality 

Background: 
Given User is on the browser
When User enters app url

Scenario: Verify navigation bar text visibility
Then User should see the text "Dietician Project" on left side of Navigation bar

Scenario: Verify Navigation bar icon visibility
Then User should see the home icon on left side of navigation bar

Scenario: Verify navigation bar background color 
Then Navigation bar background should have a blue-purple color

Scenario: Verify page title visibility
Then User should see the heading "Dietician Application" inside the login card

Scenario: Validate labels text in Login page 
Then User should see the labels with text in Login page
 	| username	|
 	| password	|

Scenario:  Verify input field presence 
Then The input fields should be visible
    | username |
    | password |

Scenario: Verify Login button presence 
Then Login button should be visible

Scenario: Verify Login button color and styling 
Then Login button should be displayed with a blue-purple background and white text

Scenario: Verify Input field label alignment 
Then Username and Password labels should be left-aligned above their respective input fields

Scenario: Verify total number of input fields 
Then User should see exactly two input field 

Scenario: Verify Login button enabled state
Then User should see login button enabled

@nagativeTc_Login
Scenario Outline: Invalid login attempts for "<testCaseType>"

	When the user enters "<inputType>" and clicks the Login button
	Then the appropriate error message "<expectedMessage>" should be displayed 
	
	Examples:
	|	inputType				 |	expectedMessage					|
	| 	non existing user 		 |	Invalid username or password	|
	|	spl character in username|	Invalid username or password	|
	|	few charaters of username|	Invalid username or password	|
	|	wrong password			 |  Invalid username or password	|
	|	spl character in password|	Invalid username or password	|
	|	empty username			 |	Username is Required			|
	|	empty password			 |	Password is Required			|

 
@positiveTC_Login
Scenario: Successful login from Excel 
When User "Submits the login form" with "valid_login"
Then User should be redirected to the dashboard page
