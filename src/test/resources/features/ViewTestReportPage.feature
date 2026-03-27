@viewTestReport @MyPatient @Login
Feature: View Patient Test Reports

  Background:
    Given User is logged in and navigated to the My Patients page

  Rule: Patient Information Section
  Background: 
   When User clicks previous test reports for a specific record
   
    Scenario: Verify correct report opens for selected record
      Then Corresponding report for that record should be opened

    Scenario: Verify title is displayed
      Then Title "View Patient Test Reports" should be displayed

    Scenario Outline: Verify patient information fields are displayed
  	Then <Field> for the selected record should be displayed

  	Examples:
    | Field             	 |
    | Patient ID        	 |
    | Patient name      	 |
    | Patient email          |	
    | Patient contact number |


    Scenario: Verify close icon is displayed
      Then Close icon "X" should be displayed


  Rule: Reports Table Structure  
  	Background:
  		When User clicks View Previous Test Reports button for a specific record
  		
    Scenario: Verify Reports table is displayed
      Then Reports table should be displayed

    Scenario: Verify table headers are displayed
      Then Table headers should be:
        | Record Number 				|
        | File 							|
        | Uploaded Time 				|
        | File/Report Name 				|
        | Vitals 						|
        | Identified Health Conditions 	|

   Scenario: Verify table headers are displayed in correct order
  	Then The table headers should be displayed in the following order:
    | Record Number               	|
    | File                        	|
    | Uploaded Time               	|
    | File/Report Name            	|
    | Vitals                      	|
    | Identified Health Conditions 	|
    
   Scenario: Verify pagination controls are displayed
  	Then Pagination controls should be displayed as:
    | First    |
    | Previous |
    | Next     |
    | Last     |
    

   Rule: Reports Table Data   
   
    Scenario: Verify record number is displayed
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display a record number

    Scenario: Verify view PDF button is displayed
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display a View PDF button

    Scenario: Verify uploaded time is displayed
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display uploaded time

    Scenario: Verify file name is displayed
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display file or report name
      
    Scenario: Verify vitals information is displayed
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display vitals information
        | Weight 	  |
        | Height 	  |
        | Temperature |
        | SP  		  |
        | DP 		  |

    Scenario: Verify vitals information is displayed in correct order
      When User clicks View Previous Test Reports button for a specific record
      Then Vitals should be displayed in the order:
        | Weight 	  |
        | Height 	  |
        | Temperature |
        | SP  		  |
        | DP 		  |

    Scenario: Verify vitals displayed in multiline format
      When User clicks View Previous Test Reports button for a specific record
      Then Vitals should be displayed in multiple lines
      
    Scenario: Verify Health conditions display
      When User clicks View Previous Test Reports button for a specific record
      Then Each report should display identified health conditions

    Scenario: Verify health conditions displayed in multiline format
      When User clicks View Previous Test Reports button for a specific record
      Then Identified health conditions should be displayed in multiple lines


  Rule: View PDF information  
  Background: 
    Given User is in View Plan Test Reports page
    
    Scenario: Corresponding PDF opens for a record
      When User clicks View PDF button for a particular record
      Then Corresponding PDF report should be opened


  Rule: Pagination management with multiple Records  
  	Background: 
  		Given User is in View Patient Test Reports page with multiple pages of patient records exist
  		
    Scenario: Verify navigate to the next page using pagination
      When User clicks the next page arrow(>)
      Then Next set of patient records should be displayed

    Scenario: Verify navigate to the previous page using pagination
      When User clicks the previous page arrow(<)
      Then Previous set of patient records should be displayed

    Scenario: Verify navigate to first page using pagination
      When User clicks the first page arrow(>>)
      Then First page of patient records should be displayed

    Scenario: Verify navigate to the last page using pagination
      When User clicks the last page arrow(<<)
      Then Last page of patient records should be displayed
      
    Scenario: Verify pagination count is updated correctly
      When User clicks any pagination arrow
      Then Pagination text should display correct range and total count
      
    Scenario: Pagination is displayed when patient records exceed one page
      When User navigates to any page
      Then Pagination controls should be displayed
      
    Scenario Outline: Verify button states on the First Page
      When User navigates to the first page of patient records
      Then The "<Button>" arrow should be <State>

      Examples:
      
        | button   | State    |
        | Previous | disabled |
        | First    | disabled |
        | Next     | enabled  |
        | Last     | enabled  |
        
    Scenario Outline: Verify button states on Middle Pages
      When User navigates to any page after the first page and not on last page
      Then The "<Button>" arrow should be enabled

      Examples:

        | button   |
        | Previous |
        | First    |
        | Next     |
        | Last     |

        
    Scenario Outline: Verify button states on the Last Page
      When User navigates to the last page of patient records
      Then The "<Button>" arrow should be <State>

      Examples:

        | Button | State    |
        | Next   | disabled |
        | Last   | disabled |
        | First  | enabled  | 


  Rule: Pagination management with only one Record
  	Background:
  		Given Only one patient record exists and user is in My Patients page
  	
  		
    Scenario: All pagination arrows disabled
      When User clicks View Patient Test Reports button
      Then All pagination arrows should be disabled


  Rule: Pagination management when no data exists in the table
  	Background:
		Given No patient records exist and user is in My Patients page
		
    Scenario: Pagination text for no data
      When User clicks View Patient Test Reports button
      Then "Showing 0 to 0 of 0 patients" should be displayed

    Scenario: All pagination arrows disabled when no data exists
      When User clicks View Patient Test Reports button
      Then First, previous, next, last arrows should be disabled
  
  Rule: Pagination management with maximum record in a page
  	Background:
  		Given User is in View Patient Test Reports page with multiple records  		
  		
  	Scenario: Verify each page should display only 2 records
      Then Each page should display only 2 records

