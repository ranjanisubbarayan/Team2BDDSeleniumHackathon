package stepdefinition;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;

public class AddPatientStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(AddPatientStepDefinition.class);

	public AddPatientStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}
	
	 @Given("User is on the Home page")
	 public void user_is_on_the_home_page(){
		 
	 }
	 
	    @When("User clicks on {string} option from the header")
	    public void user_clicks_on_option_from_the_header(String string) {
	    	
	    }
	
	    @Then("User should see {string} dialog box")
	    public void user_should_see_dialog_box(String dialogTitle) {
	    String formHeading = pom.getAddPatient().getformHeading();
	    System.out.println("Form Heading: " + formHeading);
	    	
	    }

	    @Then("User should see {int} {string} in the dialog")
	    public void user_should_see_in_dialog(int count, String element) {
	       
	    	int actualCount = 0;
	    	switch (element) {
	    	case "InputFields":
	    	actualCount = pom.getAddPatient().getinputFieldsCount();
	    	break;
	    	case "Dropdowns":
    		actualCount = pom.getAddPatient().getDropDownCount();
    		break;
	    	case "ChooseFiles":
	    		actualCount = pom.getAddPatient().getuploadFile();
	    	break;	
	    	}
	    	Assert.assertEquals(actualCount, count, "Expected " + count + " " + element + " but found " + actualCount);
	    }

	    @Then("User should see {string} button")
	    public void user_should_see_button(String buttonName) {
	        Assert.assertTrue(pom.getAddPatient().isButtonVisible(buttonName), 
	        		           buttonName +"button is not visible" );
	    }

	    @Then("User should see {string} button is {string}")
	    public void user_should_see_button_is_state(String buttonName, String state) {
	       boolean isEnabled = pom.getAddPatient().isButtonEnabled(buttonName);
	       if(state.equalsIgnoreCase("enabled")) {
	    	   Assert.assertTrue(isEnabled,buttonName + "button is not enabled but is diabled");
	       }
	       if(state.equalsIgnoreCase("diabled")) {
		    	   Assert.assertFalse(isEnabled,buttonName + "button is not diabled but is enabled");
	       }
	    }

	  	    @Then("User should see date picker for {string}")
	    public void user_should_see_date_picker_for() {
	      pom.getAddPatient().isDatePickerVisible();
	       
	    }

	    @Then("Date format should be {string}")
	    public void date_format_should_be(String expectedFormat) {
	    	pom.getAddPatient().selectDatePicker();
		    pom.getAddPatient().validateDateFormat("2026","March","20");
		    String actualDate = pom.getAddPatient().getSelectedDate();
		    
		    if(expectedFormat.equals("MM/DD/YYYY)")) {
		    	Assert.assertTrue(actualDate.matches("\\d{2}/\\d{2}/\\d{4}"),
		    			"Date foormat is Incorrect: " + actualDate);
		    }
		    }

	   
	    @Then("User should see placeholder {string} for mandatory field")
	    public void user_should_see_placeholder_for_mandatory_field(String field) {
	        Assert.assertTrue(pom.getAddPatient().isMandatoryFieldsVisible(field),
	        		"Manadatory field iss not visible: " + field );
	    }

//	    @Then("User should see mandatory {string} dropdown with default placeholder")
//	    public void user_should_see_mandatory_dropdown_with_default_placeholder(String fieldName) {
//	    
//	    }

	    @Then("User should see optional field {string}")
	    public void user_should_see_optional_field(String fieldName) {
	    	boolean isVisible = pom.getAddPatient().isOptionalFieldsVisible(fieldName);
	        Assert.assertTrue(isVisible, "Optional field not visible: " + fieldName);
	    }
	    
	    @When("User clicks on Submit without entering {string}")
	    public void user_clicks_submit_without_entering_field(String field) {
	       pom.getAddPatient().clickSubmitButton();
	    }

	    @Then("User should see error message {string}")
	    public void user_should_see_error_message(String expectedErrorMessage, String fieldName) {
	     String actualErrorMessage = pom.getAddPatient().getErrorMessage(fieldName);
	     Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
	             "Error message mismatch for field: " + fieldName);
	    }
	    
	    
	    @When("User clicks Submit with {string}")
	    public void user_clicks_submit_with(String field ) {
	       
	    }

	    @Then("User should see validation message {string}")
	    public void user_should_see_validation_message(String message) {
	        
	    }
	    
	    @When("User fills incomplete add patient form")
	    public void user_fills_incomplete_add_patient_form() {
	       
	    }

	    @When("User enters valid data in all mandatory fields")
	    public void user_enters_valid_data_in_all_mandatory_fields() {
	        
	    }

	    @When("User clicks on {string} button")
	    public void user_clicks_on_button(String buttonName) {
	        
	    }

	    @Then("Add Patient dialog should be closed")
	    public void add_patient_dialog_should_be_closed() {
	      
	    }

	}
	

