@dashboardFeature @Login
Feature: Dashboard functionality 

Background:
Given the logged in user has navigated to the dashboard page

Scenario: Verify navigation bar has exactly four links
Then Navigation bar should display exactly the following links
| My Patients |
| New Patient | 
| Login       |
| Logout      |

Scenario: Verify My Patients navigation link is clickable
When User clicks the "My Patients" link in the navigation bar
Then User should be redirected to the My Patients page

Scenario: Verify New Patient navigation link is clickable
When User clicks the "New Patient" link in the navigation bar
Then User should be redirected to the New Patient page 

Scenario: Verify Logout navigation link is clickable
When User clicks the "Logout" link in the navigation bar
Then User should be logged out of the application

Scenario: Verify Home icon is clickable
When User clicks the Home icon on the navigation bar
Then User should be navigated to the dashboard page