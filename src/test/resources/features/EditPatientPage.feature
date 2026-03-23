Feature: Edit Patient Page Dialog Box Validation 

#Dialogbox validation

 Rule: Below scenario covers Edit page Dialog box validation

Background: User logged into the app and patients already exists

Given User is in my patient page after logged in
When User clicks edit icon for the particular patient
    
Scenario: Verify Title of the dialog box
Then User should see Edit Patient page on the dialog box
 
Scenario: Verify Presence of Submit button
Then User should see submit button

Scenario: Verify State of submit button
Then User should see submit button in enable mode

Scenario: Verify Presence of Close button
Then User should see close button

Scenario: Verify State of close button
Then User should see close button in enable mode

Scenario: Verify Presence of 9 Input field
Then User should see 9 input field

Scenario: Verify Presence of 3 drop down
Then User should see 3 drop down

Scenario: Verify Presence of file upload option
Then User should see exactly 1 file upload option

Scenario: Verify Presence of first name of the patient
Then User should see the "First Name" field populated with the value entered during patient creation.

Scenario: Verify Presence of last name of the patient
Then User should see the "Last Name" field populated with the value entered during patient creation

Scenario: Verify Presence of Email of the patient
Then User should see the "Email" field populated with the value entered during patient creation

Scenario: Verify Presence of Contact Number of the patient
Then User should see the "Contact Number" field populated with the value entered during patient creation

Scenario: Verify Presence of allergy info of the patient
Then User should see the "Allergy" field populated with the value entered during patient creation

Scenario: Verify Presence of patients food preference
Then User should see the "Food Preference" field populated with the value entered during patient creation

Scenario: Verify Presence of patients cuisine preference
Then User should see the "Cuisine Category" field populated with the value entered during patient creation

Scenario: Verify Presence of patients DOB info
Then User should see the "Date of Birth" field populated with the value entered during patient creation

Scenario: Verify Presence of sub title Vitals
Then User should see vitals title after DOB field

Scenario: Verify Presence of SP field
Then User should see SP place holder in SP field

Scenario: Verify Presence of DP field
Then User should see DP place holder in DP field

Scenario: Verify Presence of Weight field
Then User should see Weight place holder in Weight field

Scenario: Verify Presence of Height field
Then User should see Height place holder in Height field

Scenario: Verify Presence of Tempature field
Then User should see tempature place holder in tempature field

Scenario: Verify Vitals information fields should not have mandatory indicator
Then User should not see mandatory indicators for Vitals Information fields

Scenario: Verify Presence of Label Upload health report
Then User should see Upload health report : text for Upload button

Scenario: Verify Presence of No File Choosen text when no files uploaded
Then User should see "No File Choosen" text

Scenario: Verify Close button color
Then Close button should have red color

#Funtional Validation of the Edit page dialog box
  
 Rule: Below scenario covers funtional Validation of the Edit page Dialog box 

Background: After navigating to the My Patient page, the logged-in user clicks the edit icon
Given User is in my patient page after logged in
When User clicks edit icon for the particular patient


Scenario: Verify Presence of place holder in First Name
When User clear exisiting value in first name field
Then User should see placeholder "First name"

Scenario: Verify Presence of place holder in last name
When User clear exisiting value in last name field
Then User should see placeholder "Last name"

Scenario: Verify Presence of place holder in email
When User clear exisiting value in email name field
Then User should see placeholder "Email"

Scenario: Verify Presence of place holder in contact no
When User clear exisiting value in contact no field
Then User should see placeholder "Contact Number"

Scenario: Verify Edit first name with valid data
When User clicks submit after editing first name with valid data
Then User should redirected to my patient with edited value in first name

Scenario: Verify Edit first name with numeric data
When User clicks submit after editing first name with numeric data
Then User should see error message in Patient name accepts only alphabets

Scenario: VerifyEdit first name with spl charac & numeric data
When User clicks submit after editing first name with spl numeric data
Then User should see error message in Patient name accepts only alphabets

Scenario: Verify Edit first name with spl charc data
When User clicks submit after editing first name with spl charc data
Then User should see error message in Patient name accepts only alphabets

Scenario: Verify Edit last name with valid data
When User clicks submit after editing the last name with valid data
Then User should be redirected to My Patient page with the edited value in the last name

Scenario: Verify Edit last name with numeric data
When User clicks submit after editing the last name with numeric data
Then User should see the error message "Patient name accepts only alphabets"

Scenario: Verify Edit last name with special characters & numeric data
When User clicks submit after editing the last name with special characters and numeric data
Then User should see the error message "Patient name accepts only alphabets"

Scenario: Verify Edit last name with special characters data
When User clicks submit after editing the last name with special characters
Then User should see the error message "Patient name accepts only alphabets"

Scenario: Verify Edit email with valid data
When User clicks submit after editing the email with valid data
Then User should be redirected to My Patient page with the edited value in the email field

Scenario: Verify Edit email with invalid format
When User clicks submit after editing the email with invalid format
Then User should see the error message "Please enter a valid email address"

Scenario: Verify Edit email without @ symbol
When User clicks submit after editing the email without @ symbol
Then User should see the error message "Please enter a valid email address"

Scenario: Verify Edit email with special characters
When User clicks submit after editing the email with invalid special characters
Then User should see the error message "Please enter a valid email address"

Scenario: Verify Edit email by removing existing value
When User clicks submit after removes the existing email value
Then User should see the error message "Email field cannot be empty"

Scenario: Verify Edit CTC number with valid data
When User clicks submit after editing the CTC number with valid data
Then User should be redirected to My Patient page with the edited value in the CTC number field

Scenario: Verify Edit CTC number with alphabets
When User clicks submit after editing the CTC number with alphabetic data
Then User should see the error message "CTC number accepts only numeric values"

Scenario: Verify Edit CTC number with special characters
When User clicks submit after editing the CTC number with special characters
Then User should see the error message "CTC number accepts only numeric values"

Scenario: Verify Edit CTC number with less than required digits
When User clicks submit after entering a CTC number with fewer digits
Then User should see the error message "Please enter a valid CTC number"

Scenario: Verify Edit CTC number by removing existing value
When User clicks submit after removing the existing ctc value
Then User should see the error message "CTC number field cannot be empty"

Scenario: Verify Edit weight with valid value
When User clicks submit after entering a valid value in the weight field
Then User should be redirected to the My Patient page with the updated weight value

Scenario: Verify Presence of updated value for weight
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating weight value
Then User should see new value under vitals column in new record number

Scenario: Verify Edit height with valid value
When User clicks submit after entering a valid value in the height field
Then User should be redirected to the My Patient page with the updated height value

Scenario: Verify Presence of updated value for height
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating height value
Then User should see new value under vitals column in new record number

Scenario: Verify Edit temperature with valid value
When User clicks submit after entering a valid value in the temperature field
Then User should be redirected to the My Patient page with the updated temperature value

Scenario: Verify Presence of updated value for temperature
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating temperature value
Then User should see new value under vitals column in new record number

Scenario: Verify Edit only SP (Systolic Pressure) with valid value
When User clicks submit after entering a valid value in the SP field only
Then User should recieve error message in DP field

Scenario: Verify Edit SP and DP with valid value
When User clicks submit after entering a valid value in SP & DP field
Then User should be redirected to My Patient page

Scenario: Verify Presence of record number for updated value in SP & DP
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating the SP & DP value
Then User should see new record number

Scenario: Verify Presence of updated value for SP & DP in record number
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating the SP & DP value
Then User should see new value under vitals column in new record number

Scenario: Verify Edit only DP (Diastolic Pressure) with valid value
When User clicks submit after entering a valid value in the DP field
Then User should recieve error message in SP field

Scenario: Verify Edit weight with alphabets
When User clicks submit after entering with alphabets
Then User should see the error message "Please enter a valid weight"

Scenario: Verify Edit weight with special characters
When User clicks submit after entering with special characters
Then User should see the error message "Please enter a valid weight"

Scenario: Verify Edit height with alphabets
When User clicks submit after entering with alphabets
Then User should see the error message "Please enter a valid height"

Scenario: Verify Edit height with special characters
When User clicks submit after entering with special characters
Then User should see the error message "Please enter a valid height"

Scenario: Verify Edit temperature with alphabets
When User clicks submit after entering with alphabets
Then User should see the error message "Please enter a valid temperature"

Scenario: Verify Edit temperature with special characters
When User clicks submit after entering with special characters
Then User should see the error message "Please enter a valid temperature"

Scenario: Verify Edit SP with alphabets
When User clicks submit after entering with alphabets
Then User should see the error message "Please enter a valid SP value"

Scenario: Verify Edit SP with special characters
When User clicks submit after entering with special characters
Then User should see the error message "Please enter a valid SP value"

Scenario: Verify Edit DP with alphabets
When User clicks submit after entering with alphabets
Then User should see the error message "Please enter a valid DP value"

Scenario: Verify Edit DP with special characters
When User clicks submit after entering with special characters
Then User should see the error message "Please enter a valid DP value"

Scenario: Verify Edit date for DOB field
When User clicks Date of Birth field
Then User should see calender date picker displayed with Month,Day,Year

Scenario: Verify Edit valid date in DOB field
When User clicks Date of Birth field after selects valid date 01/12/2000
Then User should see the selected date 01/12/2000

Scenario: Verify selected date is displayed in MM/DD/YYYY format
When User clicks Date of Birth field after selects valid date 01/12/2000
Then User should see the selected date in MM/DD/YYYY format

Scenario: Verify Prevent selection of future date in DOB field
When User clicks calendar Date of Birth field
Then User should see the future date to be disabled

Scenario: Verify Selecting current date as DOB
When User selects current date as DOB
Then User should see an error message "Invalid date ,Please select valid date"

Scenario: Verify Selecting Invalid date
When User enters invalid date (34/20/2022)
Then User should see an error message "Invalid date ,Please select valid date"

Scenario: Verify User enters non-numeric value in DOB field
When User enters "ab/cd/efgh" in the DOB field
Then User should see an error message "Invalid date format"

Scenario: Verify Selecting partial date in DOB field
When User enters "12/05" in the DOB field
Then User should see an error message "Invalid date format"

Scenario: Verify Boundary year Navigation
When User clicks calendar Date of Birth navigates to 1980 and selects a date
Then User should see the selected date to be populated on DOB field

Scenario: Verify Leap year validation
When User clicks calendar Date of Birth and selects Feb 29 2024
Then User should see the selected date Feb 29 2024

Scenario: Verify Non Leap year validation
When User enter Feb 29 2023
Then User should see an error message "Please select valid date"

Scenario: Verify File name after Upload valid file - pdf
When User uploads health report in pdf
Then User should see uploaded file name with extension

Scenario: Verify Upload valid file - pdf
When User clicks submit after uploading a valid file
Then User should be redirected to My Patient page with the uploaded file saved successfully

Scenario: Verify Presence of record number after file upload
When User clicks "View Previous Test Report" after being redirected to the My Patient page for uploaded health report
Then User should see new record number in test report page

Scenario: Verify Presence of PDF file in test report after file upload
When User clicks "View Previous Test Report" after being redirected to the My Patient page for uploaded health report
Then User should see PDF file in test report

Scenario: Verify Presence of upload date info
When User clicks "View Previous Test Report" after being redirected to the My Patient page for uploaded health report
Then User should see upload date info in test report

Scenario: Verify Presence of health info detected from the health report
When User clicks "View Previous Test Report" after being redirected to the My Patient page for uploaded health report
Then User should see health condition as the values in health report

Scenario: Verify Upload invalid file type - docx
When User clicks submit after uploading a file with an invalid file type - docx
Then User should see the error message "Invalid file type. Please upload a valid file"

Scenario: Verify Upload file exceeding size limit
When User clicks submit after uploading a file larger than allowed size
Then User should see the error message "File size exceeds the allowed limit"

Scenario: Verify Upload invalid file type - jpeg
When User clicks submit after uploading invalid file type - docx
Then User should see the error message "Invalid file type. Please upload a valid file"

Scenario: Verify Upload without selecting file
When User clicks submit without uploading any file
Then User should see the error message "Please select a file to upload"

Scenario: Verify Close edit dialog using Close button
When User clicks the Close button
Then User should redirect to My Patient Page

Scenario: Verify Close edit dialog with unsaved changes
When User clicks the Close button after entering the values
Then User should redirect on the My patient Page without saving changes
