 @MyPatientsPage @Login
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
      
     Given User is in My Patients page 
     
   Scenario: Patient Id ascending sorting
      When User clicks up arrow in Patient Id column
      Then Patient records should be sorted in ascending order by patient id
    
   Scenario: Patient Id descending sorting
     When User clicks down arrow in Patient Id column
     Then Patient records should be sorted in descending order by patient id
    
    Scenario: Name ascending sorting
      When User clicks up arrow in Name column
      Then Patient records should be sorted in ascending order by name
      
    Scenario: Name descending sorting
      When User clicks down arrow in Name column
      Then Patient records should be sorted in descending order by name
      
     Scenario: Search functionality using patient name
       When User searches using patient name
       Then Matching patient details should be displayed
       
     Scenario: Search functionality using patient id
        When User searched using patient id 
        Then Matching patient details should be displayed 
        
     Scenario: Navigation of View Previous Test Reports
        When User clicks View Previous Test Reports under action column
        Then User should be navigated to "View Patient Test Reports" page  
        
      Scenario: Search is cleared
        Given User entered the text in search box in My Patients page
        When User clears the search text
        Then All patient records should be displayed again
        
        
      Scenario: Navigate to the next page using pagination
       Given User is in My Patients page with multiple pages of patient record 
       When User clicks the next page arrow (>)
       Then Next set of  patient records should be displayed
       
      Scenario: Navigate to the previous page using pagination
        Given User is in later page of My Patients page
        When User clicks the previous page arrow (<) 
        Then Previous set of patient records should be displayed 
        
      Scenario: Navigate to the first page using pagination
         Given User is in any page except first page of My Patients page
         When User clicks the first page arrow (<<) 
         Then First page of patient records should be displayed  
    
     Scenario: Navigate to the last page using pagination
         Given User is in any page except last page of My Patients page
         When User clicks the last page arrow (<<)
         Then  Last page of patient records should be displayed
         
      Given User is in My Patients page with multiple pages of patient record 
     
     Scenario: Previous page arrow disabled on first page
        When User navigates to the first page of patient record
        Then Previous arrow (<) should be disabled
        
     Scenario: First page arrow disabled on first page
        When User navigates to the first page of patient record
        Then First page arrow (<<) should be disabled
        
     Scenario: Next page arrow enabled on first page
        When User navigates to the first page of patient record
        Then Next arrow (>) should be enabled
        
     Scenario: Last page arrow enabled on first page
         When User navigates to the first page of patient record
         Then Last page arrow (>>) should be enabled
         
      Scenario: Previous page arrow is enabled on all pages except the first page
         When User navigates to any page after the first page
         Then Previous arrow (<) should be enabled 
         
         
      Scenario: First page arrow is enabled on all pages except the first page
          When User navigates to any page after the first page
          Then First page arrow (<<) should be enabled
          
      Scenario: Last page arrow is enabled on all pages except the last page
          When User navigates to any page except the last page
          Then Last page arrow (>>) should be enabled
          
       Scenario: Next page arrow is enabled on all pages except the last page
           When User navigates to any page except the last page
           Then Next arrow (>) should be enabled
           
           
       Scenario: Next Page arrow is disabled on last page
           When User navigates to the last page of the patient record
           Then Next arrow (>) should be disabled
           
           
       Scenario: Last page arrow is disabled on last page
           When User navigates to the last page of the patient record
           Then Last page arrow (>>) should be  disabled
           
        Scenario: Each page should display only 5 records
           Given User is in dietician application dashboard page
           When User clicks on My Patients button
           Then User should see only 5 records in each page 
           
        Scenario: Newly added record move to the next page when 6th record is added 
            Given User is in My Patients page with table displays maximum of 5 record per page
            When User adds 6th record 
            Then User should see the newly added record in the next page  
           
        Scenario: Pagination when no patient data exists in the My patient table
           Given User is in dietician application dashboard page
           When User clicks on My Patients button
           Then "Showing 0 to 0 of 0 patients" should be displayed
           
        Scenario: All pagination arrows disabled when no data exists
           Given  User is in dietician application dashboard page
           When  User clicks on My Patients button
           Then First, previous, next, last arrows should be disabled
           
         Scenario: My Patient page loads with empty table
           Given User is in dietician application dashboard page
           When User clicks on My Patients button
           Then My Patients page should display with empty table  
             
              
          Scenario: All pagination arrows disabled when only one page exists
          Given User is in dietician application dashboard page
          When User clicks on My Patients button
          Then First, previous, next, last arrows should be disabled   
           
           
         Scenario: Pagination count is updated correctly
           Given User is in any page of My Patients page
           When User clicks any page navigation arrow
           Then Pagination text should display the correct range and total number of patients
           
         Scenario: Pagination is displayed when patient records exceed one page
           Given User is in My Patients page with multiple pages of patient record 
           When User navigates to any page
           Then Pagination controls should be displayed     
           
           
        
           
                                           
   
     