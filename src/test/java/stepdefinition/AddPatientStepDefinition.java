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
	        
	    }

	    @Then("User should see {string} button is {string}")
	    public void user_should_see_button_is_state(String buttonName, String state) {
	       
	    }

	  	    @Then("User should see date picker for {string}")
	    public void user_should_see_date_picker_for(String fieldName) {
	       
	    }

	    @Then("Date format should be {string}")
	    public void date_format_should_be(String expectedFormat) {
	      
	    	
	    }

	   
	    @Then("User should see placeholder {string} for mandatory field")
	    public void user_should_see_placeholder_for_mandatory_field(String fieldName) {
	        
	    }

	    @Then("User should see mandatory {string} dropdown with default placeholder")
	    public void user_should_see_mandatory_dropdown_with_default_placeholder(String fieldName) {
	    
	    }

	    @Then("User should see optional field {string}")
	    public void user_should_see_optional_field(String fieldName) {
	    	
	    }
	    
	    @When("User clicks on {string} without entering {string}")
	    public void user_clicks_submit_without_entering_field(String button, String field) {
	       
	    }

	    @Then("User should see error message {string}")
	    public void user_should_see_error_message(String errorMessage) {
	     
	    }
	    
	    
	    @When("User enters {string} in {string}")
	    public void user_enters_value_in_field(String value, String field) {
	       
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
	

