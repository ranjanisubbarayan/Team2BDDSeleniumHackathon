@Login @MyPatient @DeletePatientPage

Feature: Delete Patient Page Pop Up Validation

#Dialogbox validation

Rule: Delete pop up info validation

Background: 
Given User is in my patient page after logged in


Scenario Outline: Verify Delete patient popup elements
When User clicks the Delete icon for a "<patientname>" in the patient table
Then Alert should display "<elementtype>" "<Expectedresults>" in the delete popup section

Examples:
|patientname|elementtype | Expectedresults|
|Ram|title| Confirm|
|Rama|text| Are you sure to delete [Patient Name]?|
|Pragyan|yesbutton| displayed|
|Misty|nobutton | displayed|


#Funtional Validation of the delete popup

 Rule: Below scenario covers funtional Validation of the delete popup

Background: Delete pop up page functional validation
Given User is in my patient page after logged in
When User clicks the Delete icon for a particular patient in the patient table

Scenario Outline: Verify delete patient popup action results
When User "<action>" the alert in the delete popup
Then User should "<expectedresult>" in the dietician application

Examples:
|action| expectedresult|
|accepts| navigated back to main page|
|accepts| patient removed from the table and success message displayed |
|dismiss| navigated back to main page|
|dismiss| alert closed and patient remains in the table|