Feature: Add Patient

  Background:
    Given User is on the Home page
    When User clicks on "New Patient" option from the header

  
  Scenario: Verify Add Patient dialog is displayed
    Then User should see "Add Patient Details" dialog box

   Scenario Outline: Verify elements present in Add Patient dialog   
    Then User should see <count> "<element>" in the dialog

    Examples:
      | count | element             |
      | 9     | InputFields        |
      | 3     | Dropdowns     |
      | 1     | ChooseFiles   |

 
  Scenario Outline: Verify button visibility and state
    Then User should see "<button>" button
    Then User should see "<button>" button is "<state>"

    Examples:
      | button | state    |
      | Submit | disabled |
      | Close  | enabled  |

 
  Scenario: Verify Date of Birth field behavior
    Then User should see date picker for "Date of Birth"
    Then Date format should be "MM/DD/YYYY"

    Scenario Outline: mandatory field placeholders are visible
    Then User should see placeholder "<field>" for mandatory field

    Examples:
      | field           |
      | First Name      |
      | Last Name       |
      | Email           |
      | Contact Number  |
      | Date of Birth   |
      | Allergies         |
      | Food Preference   |
      | Cuisine Category  |

    Scenario Outline: Verify optional vitals fields
    Then User should see optional field "<field>"

    Examples:
      | field  |
      | Weight |
      | Height |
      |Temperature |
      | SP     |
      | DP     |
      
  
    Scenario Outline: Verify data and negative and positive scenario from Excel
    When User enters and click Submit with "<scenarioType>"
    Then User should see validation message "<expected_Message>"

    Examples:
    | scenarioType                      |      expected_Message             |
    |first name with numeric data     | Patient first name accepts only alphabets|
    |first name with special character data | Patient first name accepts only alphabets|
    |Mandatory check for firstname field   | Firstname field is required|
    |last name with  numeric data      | Patient last name accepts only alphabets|
    |last name with special character data |Patient last name accepts only alphabets|
    |Mandatory check for lastname          | Lastname field is required|
    |email with  starts with number    | Please enter a valid email address|
    |email without @ symbol            | Please enter a valid email address|
    |email with special characters     | Please enter a valid email address|
    |email without .com                | Please enter a valid email address|
    |Existing email id                     | Email id already exists|
    |Mandatory check for email field | Email field is required|
    |contact no. with alphabets     | Contact number accepts only numeric values|
    |contact no. with special characters | Contact number accepts only numeric values|
    |contact no. with less than ten digits | Please enter a valid contact number|
    |contact no. with greater ten digits | Please enter a valid contact number|
    |Existing contact number             | Contact number already exists|
    |Mandatory field check for contact num | Contact Num is required|
    |Leaving Allergies field empty    | Allergies is required|
    |Leaving Food Preference empty    | Food Preference is required|
    |Leaving Cusine Category field empty| Cuisine Category is required|
    |Leaving DOB field empty            |Date is required|
    |weight with valid data|Patient successfully created|
    |Add weight with special characters|Please enter a valid weight|
    |Add weight with alphabets|Please enter a valid weight|
    |Add height with valid data|Patient successfully created|
    |Add height with special characters|Please enter a valid height|
    |Add height with alphabets|Please enter a valid height|
    |Add temperature with valid data|Patient successfully created|
    |Add temperature with special characters|Please enter a valid temperature|
    |Add temperature with alphabets|Please enter a valid temperature|
    |Add SP,DP with special characters|Please enter a valid SP value|
    |Add SP ,DP with alphabets|Please enter a valid SP value|
    |Add SP,DP with valid data|Patient successfully created|
    |patient created with mandatory fields only|Patient successfully created|
    
     
  Scenario: Verify Submit button remains disabled for incomplete form
    When User fills incomplete add patient form
    Then User should see "Submit" button is disabled

   Scenario Outline: State of Submit button after adding values in all field
    When User enters "valid data" in all fields 
    Then User should see "Submit" button is enabled
    Examples:
     Examples:
    | scenarioType              |   
    |all fields with valid data|

  Scenario: Verify Close button functionality
    When User clicks on "Close" button
    Then Add Patient dialog should be closed

   
  Scenario Outline: Verify each dropdown has the correct number of options
    When User clicks on "<dropdown>" dropdown
    Then User should see <count> options in the dropdown

    Examples:
      | dropdown         | count |
      | Allergies        | 13    |
      | Food Preference  | 5     |
      | Cuisine Category | 36    |
      
  Scenario: Verify Allergy dropdown contains all required allergy options
    When User clicks on the Allergy dropdown
    Then the Allergy dropdown should contain the following values:
      | Egg       |
      | Milk      |
      | Soy       |
      | Almond    |
      | Peanuts   |
      | Walnut    |
      | Pistachio |
      | Sesame    |
      | Hazelnut  |
      | Pecan     |
      | Cashew    |
      | NONE      |
      
  Scenario: Verify Food Preference dropdown contains all required values
  When User clicks on the Food Preference dropdown
  Then the Food Preference dropdown should contain the following values:
    | Vegan       |
    | Vegetarian  |
    | Jain        |
    | Eggitarian  |
    | NonVeg      |        

Scenario: Verify Food Preference dropdown contains all required values
  When User clicks on the cuisine dropdown
  Then the cuisine dropdown should contain the following values:
    |Indian|
    |South Indian|
    |Rajasthani|
    |Punjabi|
    |Bengali|
    |Orissa|
    |Gujarati|
    |Maharashtrian|
    |Andhra|
    |Kerala|
    |Goan|
    |Kashmiri|
    |Himachali|
    |Tamil Nadu|
    |Karnataka|
    |Sindhi|
    |Chhattisgarhi|
    |Madhya Pradesh|
    |Assamese|
    |Manipuri|
    |Tripuri|
    |Sikkimese|
    |Mizo|
    |Arunachali|
    |Uttarakhand|
    |Haryanvi|
    |Awadhi|
    |Bihari|
    |Uttar Pradesh|
    |Delhi|
    |North Indian|
    
  Scenario Outline: Verify user can select a value from each dropdown
    When User clicks on "<dropdown>" dropdown and selects "<value>" 
    Then "<value>" should be selected in the "<dropdown>" field

    Examples:
      | dropdown         | value      |
      | Allergies        | Peanuts    |
      | Food Preference  | Vegan      |
      | Cuisine Category | Punjabi    |

  Scenario: Verify user can select multiple allergies
    When User select "Peanuts" and "Milk" from "Allergies" dropdown
    Then "Peanuts" and "Milk" should both be selected in the "Allergies" field

    Scenario: Verify file upload option
    Then User should see file upload option

    #Scenario: Verify successful patient creation
    #When User clicks "Submit" after entering valid data in all mandatory fields
    #Then User should see Patient successfully created - toast message

   