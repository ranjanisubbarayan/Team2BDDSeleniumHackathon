 @LogIn @MyPatientsPage
 Feature: My Patients Page Validation
 
 Background:
  User is logged into the dietician application
   
   Given User is in dietician application dashboard page
   When User clicks on My Patients button
 
 Scenario: My Patients Title is displayed
  Then Page header "My Patients" should be displayed
   
 
 Scenario: Search bar display
  Then Search bar should be displayed 
   
   
 Scenario: Search Icon display
  Then Search icon should be displayed inside the search bar
   
  
 Scenario: Search placeholder text display
  Then Placeholder text "Search..." should be displayed
   
 
 Scenario: Table column header is displayed
  Then The table header "<header>" should be displayed
 Examples:
   | header          |
   | Patient Id      |
   | Name            |
   | Details         |
   | Last Visit Date |
   | Actions         |
   | Edit/Delete     |

   
   
 Scenario: Patient Id column sorting icon
   Then Up and down arrow icons should be displayed in the Patient Id column header
   
   
 Scenario: Name column sorting icon
   Then Up and down arrow icons should be displayed in the Name column header


 Scenario: Patient List display
   Then Each row in the "<column>" column should have a value
 Examples:
   | column          |
   | Patient Id      |
   | Name            |
   | Details         |
   | Last Visit Date |
   | Actions         |

   
   
 Scenario: Patient Id displayed for each row
   Then Patient Id should be displayed for each patient record
   
   
  Scenario: Patient name displayed for each row 
   Then Patient name should be displayed for each patient record
   
 
   Scenario: Details column displays patient information
    Then Details column should contain "<field>" for each patient record
   Examples:
    | field         |
    | phone number  |
    | email         |
    | date of birth |

     
   Scenario: Details are displayed in multiline format
     Then Phone number, email , date of birth should be displayed on separate lines for each patient record
  
   Scenario: Email format in details column
     Then Email should be displayed in valid email format for each patient record 
     
    
    Scenario: Phone number format in details column       
      Then Phone number displayed in details column should contain valid digits for each patient record
      
    Scenario: DOB format in details column
      Then Date of birth should be displayed in "dd-mm-yyyy" format for each patient record 
  
    
    Scenario: Last visit date displayed for each row 
       Then Last visit date should be displayed for each patient record
      

    Scenario: Last visit date format  
     Then Last visit date should be displayed in 'dd-mm-yyyy" format for each patient record
      
    
    Scenario: 3 button under Actions column for each row
     
      Then "View Previous Test Reports", "View Previous Diet Plans", "Create New Report/plan" should be displayed for each patient record
      
      
   
   Scenario: Edit icon displayed for each row
      Then Edit icon should be displayed for each patient record
      
    
   Scenario: Delete icon displayed for each row
      Then Delete icon should be displayed for each patient record
   
   
   
   
   
     