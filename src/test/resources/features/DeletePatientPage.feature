@DeletePatientPage

Feature: Delete Patient Page Pop Up Validation

#Dialogbox validation

Rule: Delete pop up info validation

Background: 
Given User is in my patient page after logged in
When User clicks the Delete icon for a particular patient in the patient table

Scenario: Verify Delete patient – alert title verification
Then Alert title should be "Confirm"

Scenario: Verify Delete patient – alert text verification
Then Alert text should be "Are you sure to delete [Patient Name]?"

Scenario: Verify Delete patient – Yes button verification
Then Alert should display a Yes button

Scenario: Verify Delete patient – No button verification
Then Alert should display a No button

#Funtional Validation of the delete popup

 Rule: Below scenario covers funtional Validation of the delete popup

Background: Delete pop up page functional validation
Given User is in my patient page after logged in
When User clicks the Delete icon for a particular patient in the patient table

Scenario: Verify Delete patient – confirm deletion- Navigation check
When User accepts the alert
Then User should be navigated back to main page

Scenario: Verify Delete patient after confirm deletion
When User accepts the alert
Then Patient should be removed from the table and a success message displayed

Scenario: Verify Delete patient – cancel deletion Navigation check
When User dismiss the alert
Then User should be navigated back to main page

Scenario: Verify Delete patient after cancel deletion
When User dismiss the alert
Then Alert should close and the patient should remain in the table