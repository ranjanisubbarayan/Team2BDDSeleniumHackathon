@EditPatientPage @Login
Feature: Edit Patient Page Dialog Box Validation 

#Dialogbox validation

 Rule: Below scenario covers Edit page Dialog box validation

Background: User logged into the app and patients already exists

Given User is in my patient page after logged in
    
Scenario: Verify Title of the dialog box
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see Edit Patient page on the dialog box
 
Scenario Outline: Verify presence of UI elements
When User clicks the Delete icon for a "<patientname>" in the patient table
Then User should see "<fieldName>" in the editpage

Examples:
|patientname| fieldName|
|Ram| Submitbutton|
|Rama| Closebutton|
|Pragyan| file upload option |


Scenario Outline: Verify state of buttons
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see "<button>" is enabled

Examples:
|patientname |button|
|Rama| Submitbutton | 
|Pragyan| Closebutton  | 

Scenario Outline: Verify count of UI elements
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see "<count>" "<element>"

Examples:
|patientname| count | element|
|Rama| 9| inputfields   |
|Pragyan| 3| dropdowns|
| Pragyan | 1     | ChooseFiles   |

Scenario Outline: Verify presence of patient details
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see the "<field_name>" field populated with the value entered during patient creation

Examples:
|patientname| field_name|
|Rama| First Name|
|Rama| Last Name|
|Rama| Email|
|Rama| Contact Number|
|Rama| Allergy|
|Rama| Food Preference|
|Rama| Cuisine Category|
|Rama| Date of Birth|


Scenario Outline: Verify presence of vitals fields
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see "<label>" in "<field>"

Examples:
|patientname| label| field|
|Pragyan| vitals title | subtitle|
|Pragyan| SP| SP field|
|Pragyan| DP| DP field|
|Pragyan| Weight| Weight field|
|Pragyan| Height| Height field|
|Pragyan| Temperature| Temperature field |



Scenario Outline: Verify Vitals information fields should not have mandatory indicator
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should not see mandatory indicators for Vitals Information fields

Examples:
| patientname |
| Ram         |
| Rama        |
| Pragyan     |

Scenario Outline: Verify Presence of Label Upload health report
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see Upload health report : text for Upload button
Examples:
| patientname |
| Ram         |
| Rama        |
| Pragyan     |
Scenario Outline: Verify Presence of No File Choosen text when no files uploaded
When User clicks the Edit icon for a "<patientname>" in the patient table
Then User should see "No File Choosen" text
Examples:
| patientname |
| Ram         |
| Rama        |
| Pragyan     |
Scenario Outline: Verify Close button color
When User clicks the Edit icon for a "<patientname>" in the patient table
Then Close button should have red color
Examples:
| patientname |
| Ram         |
| Rama        |
| Pragyan     |

#Funtional Validation of the Edit page dialog box
  
 Rule: Below scenario covers funtional Validation of the Edit page Dialog box 

Background: After navigating to the My Patient page, the logged-in user clicks the edit icon
Given User is in my patient page after logged in
When User clicks edit icon for the particular patient


Scenario Outline: Verify Presence of placeholder in fields
When User clears existing value in "<field>" field
Then User should see placeholder "<placeholdername>"

Examples:
| field| placeholdername|
| first name| First name|
| last name| Last name|
| email| Email|
| contact no| Contact Number|

Scenario Outline: Verify edit first name with different inputs
When User clicks submit after editing first name with "<input_type>"
Then User should see "<result>" after redirected to my patient with edited value in first name

Examples:
| input_type| result|
| Ram| Ram|
| 12345| error message Patient name accepts only alphabets|
| @123| error message Patient name accepts only alphabets|
| @#$| error message Patient name accepts only alphabets|



Scenario Outline: Verify edit last name with different inputs
When User clicks submit after editing the last name with "<input_type>"
Then User should see "<result>" after redirected to my patient with edited value in Last name

Examples:
| input_type| result|
| Kumar| Kumar|
| 12345| error message Patient name accepts only alphabets|
| @123| error message Patient name accepts only alphabets|
| @#$| error message Patient name accepts only alphabets|

Scenario Outline: Verify edit email with different inputs
When User clicks submit after editing the email with "<input_type>"
Then User should see "<result>" after redirected to my patient with edited value in Email field

Examples:
| input_type| result|
| ram.kumar@test.com| ram.kumar@test.com|
| ramkumar.com| Please enter a valid email address |
| ramkumar.test.com | Please enter a valid email address |
| ram@$%.com| Please enter a valid email address |
|| Email field cannot be empty|

Scenario Outline: Verify edit CTC number with different inputs
When User clicks submit after editing the CTC number with "<input_type>"
Then User should see "<result>"

Examples:
| input_type | result|
| 8277117996 | 8277117996|
| abcdef| CTC number accepts only numeric values|
| @#$| CTC number accepts only numeric values |
| 12345| Please enter a valid CTC number|
|| CTC number field cannot be empty|

Scenario Outline: Verify edit "<field>" with valid value
When User clicks submit after entering a "<validvalue>" in the "<field>" field
Then User should be redirected to the My Patient page with the updated "<field>" value as "<validvalue>"
Examples:
  | field       | validvalue |
  | weight      | 70    |
  | height      | 175   |
  | temperature | 98.6  |

Scenario Outline: Verify presence of updated value for "<field>"
When User clicks "View Previous Test Report" after being redirected to the My Patient page for updating "<field>" value
Then User should see "<newvalue>" under vitals column in new record number

Examples:
  | field       | newvalue |
  | weight      | 70    |
  | height      | 175   |
  | temperature | 98.6  |

Scenario Outline: Verify error when only one SP or DP field is entered
When User clicks submit after entering a valid "<value>" in the "<field>" field only
Then User should receive error message in "<other_field>" field


Examples:
  | field | other_field | value |
  | SP| DP| 120|
  | DP| SP| 80|

Scenario: Verify edit SP and DP with valid values
When User clicks submit after entering valid values in SP "<sp>" and DP "<dp>" fields
Then User should be redirected to My Patient page

Examples:
  | sp  | dp  |
  | 120 | 80  |
  | 130 | 85  |
  
  
Scenario Outline: Verify updated SP amd DPrecord details
When User clicks View Previous Test Report after being redirected to the My Patient page for updating the SP "<sp>" and DP "<dp>" value
Then User should see result for the update value  SP "<sp>" and DP "<dp>" value
 
Examples:
  | sp  | dp  |
  | 120 | 80  |
  | 130 | 85  |
  
Scenario Outline: Verify invalid inputs for vitals fields
When User clicks submit after entering "<input_type>" in "<field>" field
Then User should see the error message "<error_message>"


Examples:
| field       | input_type | error_message                    |
| weight      | abc        | Please enter a valid weight      |
| weight      | @#$        | Please enter a valid weight      |
| height      | abc        | Please enter a valid height      |
| height      | @#$        | Please enter a valid height      |
| temperature | abc        | Please enter a valid temperature |
| temperature | @#$        | Please enter a valid temperature |
| SP          | abc        | Please enter a valid SP value    |
| SP          | @#$        | Please enter a valid SP value    |
| DP          | abc        | Please enter a valid DP value    |
| DP          | @#$        | Please enter a valid DP value    |


Scenario Outline: Verify Edit date for DOB field and Prevent selection of future date in DOB field
When User performs "<action>" on Date of Birth field
Then User should see "<result>"

Examples:
| action| result|
| clicks| calender date picker displayed with Month, Day, Year    |
| clicks calendar field   | the future date to be disabled|


Scenario Outline: Verify valid date selection in DOB field
When User selects valid date "<date>" in the Date of Birth field
Then User should see the slected date "<result>"


Examples:
| date       | result|
| 01/12/2000 | 01/12/2000|
| 01/12/2000 | MM/DD/YYYY|
| 02/29/2024 | 02/29/2024|

Scenario Outline: Verify invalid DOB inputs
When User enters "<input>" in the DOB field
Then User should see an error message "<error_message>"

Examples:
| input| error_message|
| current date | Invalid date, Please select valid date |
| 34/20/2022   | Invalid date, Please select valid date |
| ab/cd/efgh   | Invalid date format|
| 12/05        | Invalid date format|
| 02/29/2023   | Please select valid date|


Scenario: Verify Boundary year Navigation
When User clicks calendar Date of Birth navigates to 1980 and selects a date
Then User should see the selected date to be populated on DOB field

Scenario: Verify file name after uploading valid pdf
When User uploads health report in pdf
Then User should see uploaded file name with extension

Scenario Outline: Verify presence of fields after file upload 
When User clicks submit after uploading a valid file
Then User should be redirected to My Patient page with the uploaded file saved successfully
When  User clicks "View Previous Test Report" after being redirected to the My Patient page for uploaded health report
Then User should see "<result>"

Examples:
| result|
| new record number in test report page|
| PDF file in test report|
| upload date info in test report|
| health condition as the values in health report  |

Scenario Outline: Verify invalid file upload scenarios
When User clicks submit after "<action>"
Then User should see the error message "<error_message>"

Examples:
| action| error_message|
| uploading a file with an invalid file type - docx| Invalid file type. Please upload a valid file|
| uploading invalid file type - jpeg| Invalid file type. Please upload a valid file|
| uploading a file larger than allowed size| File size exceeds the allowed limit|
| uploading without any file| Please select a file to upload|


Scenario: Verify Close edit dialog using Close button
When User clicks the Close button
Then User should redirect to My Patient Page

Scenario: Verify Close edit dialog with unsaved changes
When User clicks the Close button after entering the values
Then User should redirect on the My patient Page without saving changes
