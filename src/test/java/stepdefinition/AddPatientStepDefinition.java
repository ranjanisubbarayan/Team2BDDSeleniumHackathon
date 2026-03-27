package stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;
import utils.ExcelReader;
import utils.TestContext;

public class AddPatientStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(AddPatientStepDefinition.class);

	public AddPatientStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {

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
		Assert.assertTrue(pom.getAddPatient().isButtonVisible(buttonName), buttonName + "button is not visible");
	}

	@Then("User should see {string} button is {string}")
	public void user_should_see_button_is_state(String buttonName, String state) {
		boolean isEnabled = pom.getAddPatient().isButtonEnabled(buttonName);
		if (state.equalsIgnoreCase("enabled")) {
			Assert.assertTrue(isEnabled, buttonName + "button is not enabled but is diabled");
		}
		if (state.equalsIgnoreCase("diabled")) {
			Assert.assertFalse(isEnabled, buttonName + "button is not diabled but is enabled");
		}
	}

	@Then("User should see date picker for {string}")
	public void user_should_see_date_picker_for() {
		pom.getAddPatient().isDatePickerVisible();

	}

	@Then("Date format should be {string}")
	public void date_format_should_be(String expectedFormat) {
		pom.getAddPatient().selectDatePicker();
		pom.getAddPatient().validateDateFormat("2026", "March", "20");
		String actualDate = pom.getAddPatient().getSelectedDate();

		if (expectedFormat.equals("MM/DD/YYYY)")) {
			Assert.assertTrue(actualDate.matches("\\d{2}/\\d{2}/\\d{4}"), "Date foormat is Incorrect: " + actualDate);
		}
	}

	@Then("User should see placeholder {string} for mandatory field")
	public void user_should_see_placeholder_for_mandatory_field(String field) {
		Assert.assertTrue(pom.getAddPatient().isMandatoryFieldsVisible(field),
				"Manadatory field iss not visible: " + field);
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
	    
	    @When("User clicks on Submit without entering mandatory {string}")
	    public void user_clicks_submit_without_entering_field(String invalidData) {
	    	pom.getAddPatient().clickSubmitButton();
	    }

	    @Then("User should see error message {string}")
	    public void user_should_see_error_message(String expectedErrorMessage, String fieldName) {
	     String actualErrorMessage = pom.getAddPatient().getErrorMessage(fieldName);
	     Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
	             "Error message mismatch for field: " + fieldName);
	    }
	    
	    
	    @When("User enters and click Submit with {string}")
	    public void user_enters_and_click_submit_with(String invalidData ) {
	    	 TestContext.testData = ExcelReader.getTestData(invalidData);
             pom.getAddPatient().fillForm(TestContext.testData);
             pom.getAddPatient().clickSubmitButton();
	    }

	    @Then("User should see validation message {string}")
	    public void user_should_see_validation_message(String expectedMessage) {
	    	String actualMessage = pom.getAddPatient().getErrorMessageFromUI(expectedMessage);
	        
	    	Assert.assertEquals(actualMessage, expectedMessage, 
	            "Validation message mismatch for scenario: " + TestContext.testData.get("scenarioType "));
	    }
	    
	    
	    @When("User fills incomplete add patient form")
	    public void user_fills_incomplete_add_patient_form() {
	       
	    }
	    
	    @Then("User should see {string} button is disabled")
	    public void user_should_see_button_is_disabled(String btnName) {
	    	 pom.getAddPatient().isButtonEnabled(btnName);
	    }

	    @When("User enters {string} in all fields")
	    public void user_enters_valid_data_in_all(String validData) {
	        TestContext.testData = ExcelReader.getTestData(validData);
            pom.getAddPatient().fillForm(TestContext.testData);
           	       
	    }
	    
	    @Then("User should see {string} button is enabled")
	    public void user_should_see_button_is_enabled(String btnName) {
	    	 pom.getAddPatient().isButtonEnabled(btnName);
	    }
	    
	    @When("User clicks on {string} button")
	    public void user_clicks_on_button(String buttonName) {
	        
	    }

	    @Then("Add Patient dialog should be closed")
	    public void add_patient_dialog_should_be_closed() {
	      
	    }
	    
	    @When("User clicks on {string} dropdown to select {string}")
	    public void user_clicks_on_dropdown_to_select_and(String dropdownName) {
	        pom.getAddPatient().clickDropdown(dropdownName);
	    }

	    @When("User clicks on {string} dropdown")
	    public void user_clicks_on_dropdown(String dropDownName) {
	    	pom.getAddPatient().clickDropdown(dropDownName);
	    }
	    
	    @Then("User should see {int} options in the dropdown")
	    public void user_should_see_count_options_in_dropdown(int expectedCount) {
	       
	    }

	    @When("User clicks on the Allergy dropdown")
	    public void user_clicks_on_allergy_dropdown() {
	        pom.getAddPatient().clickDropdown("Allergies");
	    }

	    @Then("the Allergy dropdown should contain the following values:")
	    public void allergy_dropdown_should_contain_values(List<String> expected) {
	    	List<String> actual = pom.getAddPatient().getDropdownOptions("allergies");
	        Assert.assertTrue(actual.containsAll(expected), "Allergy dropdown values mismatch!");
	    }	  

	    @When("User clicks on the Food Preference dropdown")
	    public void user_clicks_on_food_preference_dropdown() {
	        pom.getAddPatient().clickDropdown("Food Preference");
	    }

	    @Then("the Food Preference dropdown should contain the following values:")
	    public void food_preference_dropdown_should_contain_values(List<String> expected) {
	    	 List<String> actual = pom.getAddPatient().getDropdownOptions("food preference");
	    	    Assert.assertTrue(actual.containsAll(expected), "Food Preference dropdown values mismatch!");
	    	}
	    
	    @When("User clicks on the cuisine dropdown")
	    public void user_clicks_on_cuisine_dropdown(List<String> expected) {
	        pom.getAddPatient().clickDropdown("cuisine");
	    }
	   
	    @Then("the cuisine dropdown should contain the following values:")
	    public void verifyCuisineDropdownValues(List<String> expected) {
	    List<String> actual = pom.getAddPatient().getDropdownOptions("cuisine category");
	    Assert.assertTrue(actual.containsAll(expected), "Cuisine dropdown values mismatch!");
	}
	   
	    @When("User clicks on {string} dropdown and selects {string}")
	    public void user_clicks_on_dropdown_and_select(String dropdown, String value) {
	        pom.getAddPatient().selectDropdownValue(dropdown,value);
	    }

	    @Then("{string} should be selected in the {string} field")
	    public void value_should_be_selected_in_field(String value, String dropdown) {
	        List<String> selectedValue = pom.getAddPatient().getDropdownOptions(dropdown);
	        Assert.assertTrue(selectedValue.contains(value),
	                value + " is not present in " + dropdown);
	    }

	    @When ("User select {string} and {string} from {string} dropdown")
	    public void user_selecet_and_from_dropdown(String value1, String value2, String dropdown) {
	    	pom.getAddPatient().selectDropdownValue(dropdown, value1);
	    	pom.getAddPatient().selectDropdownValue(dropdown, value2);
	    }
	    
	    
	    
	    @Then("{string} and {string} should both be selected in the {string} field")
	    public void multiple_values_selected_in_field(String value1, String value2, String dropdown) {
	    	List<String> selectedOptions = pom.getAddPatient().getDropdownOptions(dropdown);
	        Assert.assertTrue(selectedOptions.contains(value1));
	        Assert.assertTrue(selectedOptions.contains(value2));
	    }

	 
	    @Then("User should see file upload option")
	    public void user_should_see_file_upload_option() {
	    	Assert.assertTrue(pom.getAddPatient().isfileUploadVisible(),
	    	        "Upload file field is not visible!");
	    }

	    @When("User uploads a valid file")
	    public void user_uploads_a_valid_file() {
	        
	    }

	    @Then("File should be uploaded successfully")
	    public void file_should_be_uploaded_successfully() {
	      
	               
	    }

	    @When("User uploads an invalid file")
	    public void user_uploads_an_invalid_file() {
	        
	    }

	    @Then("User should see file upload error message")
	    public void user_should_see_file_upload_error_message() {
	       
	    }

	   
//
//	    @When("User clicks {string} after entering valid data in all mandatory fields")
//	    public void user_clicks_submit_after_entering_valid_data(String button) {
//	        pom.getAddPatient().fillAllMandatoryFields();
//	        pom.getAddPatient().clickSubmit(button);
//	    }
//
//	    @Then("User should see Patient successfully created - toast message")
//	    public void user_should_see_patient_created_toast() {
//	        Assert.assertTrue(
//	                pom.getAddPatient().isSuccessToastDisplayed(),
//	                "Success toast message is not displayed");
//	    }


}
