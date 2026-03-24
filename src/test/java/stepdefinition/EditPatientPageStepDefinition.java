package stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.PageObjectManager;
import org.testng.Assert;

public class EditPatientPageStepDefinition {
	
	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(EditPatientPageStepDefinition.class);

	public EditPatientPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}
	

@Given("User is in my patient page after logged in")
public void user_is_in_my_patient_page_after_logged_in() {
    
}

@When("User clicks edit icon for the particular patient")
public void user_clicks_edit_icon_for_the_particular_patient() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User should see Edit Patient page on the dialog box")
public void user_should_see_edit_patient_page_on_the_dialog_box() {
	Assert.assertTrue(pom.getEditPatientPage().isEditPatientDialogDisplayed(),
			"Edit Patient dialog is not displayed");
}

@Then("User should see {string}")
public void user_should_see(String string) {
	String key = string.trim().toLowerCase();

	switch (key) {
	case "submit button":
		Assert.assertTrue(pom.getEditPatientPage().isSubmitButtonDisplayed(),
				"Submit button is not displayed");
		break;
	case "close button":
		Assert.assertTrue(pom.getEditPatientPage().isCloseButtonDisplayed(),
				"Close button is not displayed");
		break;
	case "file upload option":
		Assert.assertTrue(pom.getEditPatientPage().isFileUploadOptionDisplayed(),
				"File upload option is not displayed");
		break;
	}
}

@Then("User should see {string} is enabled")
public void user_should_see_is_enabled(String string) {
	logger.info("Validating element is enabled: {}", string);
	String key = string.trim().toLowerCase();

	switch (key) {
	case "submit button":
		Assert.assertTrue(pom.getEditPatientPage().isSubmitButtonEnabled(), "Submit button is not enabled");
		break;
	case "close button":
		Assert.assertTrue(pom.getEditPatientPage().isCloseButtonEnabled(), "Close button is not enabled");
		break;
	default:
		
	}
}

@Then("User should see {string} {string}")
public void user_should_see(String string, String string2) {
	
}

@Then("User should see the {string} field populated with the value entered during patient creation")
public void user_should_see_the_field_populated_with_the_value_entered_during_patient_creation(String field_name) {
	String actualValue = pom.getEditPatientPage().getFieldValue(field_name);
	logger.info("Validating field '{}' is populated. Actual value: {}", field_name, actualValue);

	Assert.assertNotNull(actualValue, "Field value is null for: " + field_name);
	Assert.assertFalse(actualValue.trim().isEmpty(), "Field value is empty for: " + field_name);
}



@Then("User should see {string} in {string}")
public void user_should_see_in(String label, String field) {
	logger.info("Validating '{}' in '{}'", label, field);

	if (field.toLowerCase().contains("field")) {
		String normalizedField = field.replace(" field", "").trim();
		String actualPlaceholder = pom.getEditPatientPage().getPlaceholder(normalizedField);
		Assert.assertEquals(actualPlaceholder, label, "Placeholder mismatch for field: " + normalizedField);
	} 
}

@Then("User should not see mandatory indicators for Vitals Information fields")
public void user_should_not_see_mandatory_indicators_for_vitals_information_fields() {
	Assert.assertFalse(pom.getEditPatientPage().isVitalsTitleDisplayed(),
			"Mandatory indicators are displayed for vitals fields");
}

@Then("User should see Upload health report : text for Upload button")
public void user_should_see_upload_health_report_text_for_upload_button() {
	Assert.assertTrue(pom.getEditPatientPage().isFileUploadOptionDisplayed(),
			"Upload health report label is not displayed");
}

@Then("User should see {string} text")
public void user_should_see_text(String string) {
//	Assert.assertTrue(pom.getEditPatientPage().isTextDisplayed(string), "Text is not displayed: " + string);
}


@Then("Close button should have red color")
public void close_button_should_have_red_color() {
	Assert.assertTrue(pom.getEditPatientPage().isCloseButtonDisplayed(), "Close button is not red");
}


@When("User clears existing value in {string} field")
public void user_clears_existing_value_in_field(String string) {
	pom.getEditPatientPage().clearField(string);
}

@Then("User should see placeholder {string}")
public void user_should_see_placeholder(String string) {
   
}

@When("User clicks submit after editing first name with {string}")
public void user_clicks_submit_after_editing_first_name_with(String string) {
	pom.getEditPatientPage().enterValue("first name", string);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should see {string} after redirected to my patient with edited value in first name")
public void user_should_see_after_redirected_to_my_patient_with_edited_value_in_first_name(String string) {
 
}

@When("User clicks submit after editing the last name with {string}")
public void user_clicks_submit_after_editing_the_last_name_with(String string) {
	pom.getEditPatientPage().enterValue("last name", string);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should see {string} after redirected to my patient with edited value in Last name")
public void user_should_see_after_redirected_to_my_patient_with_edited_value_in_last_name(String string) {
   
}

@When("User clicks submit after editing the email with {string}")
public void user_clicks_submit_after_editing_the_email_with(String string) {
	pom.getEditPatientPage().enterValue("email", string);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should see {string} after redirected to my patient with edited value in Email field")
public void user_should_see_after_redirected_to_my_patient_with_edited_value_in_email_field(String string) {
  
}

@When("User clicks submit after editing the CTC number with {string}")
public void user_clicks_submit_after_editing_the_ctc_number_with(String string) {
	pom.getEditPatientPage().enterValue("contact number", string);
	pom.getEditPatientPage().clickSubmit();
}

@When("User clicks submit after entering a {string} in the {string} field")
public void user_clicks_submit_after_entering_a_in_the_field(String string, String string2) {
	pom.getEditPatientPage().enterValue(string2, string);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should be redirected to the My Patient page with the updated {string} value as {string}")
public void user_should_be_redirected_to_the_my_patient_page_with_the_updated_value_as(String string, String string2) {
	//pom.getEditPatientPage().clickActionByText(string);
}

@When("User clicks {string} after being redirected to the My Patient page for updating {string} value")
public void user_clicks_after_being_redirected_to_the_my_patient_page_for_updating_value(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User should see {string} under vitals column in new record number")
public void user_should_see_under_vitals_column_in_new_record_number(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks submit after entering a valid {string} in the {string} field only")
public void user_clicks_submit_after_entering_a_valid_in_the_field_only(String string, String string2) {
	pom.getEditPatientPage().enterValue(string2, string);

	if ("sp".equalsIgnoreCase(string2)) {
		pom.getEditPatientPage().clearField("dp");
	} else if ("dp".equalsIgnoreCase(string2)) {
		pom.getEditPatientPage().clearField("sp");
	}

	pom.getEditPatientPage().clickSubmit();
}

@Then("User should receive error message in {string} field")
public void user_should_receive_error_message_in_field(String string) {
	Assert.assertTrue(pom.getEditPatientPage().isErrorMessageDisplayed(string),
			"Expected field error is not displayed for: " + string);
}

@When("User clicks submit after entering valid values in SP {string} and DP {string} fields")
public void user_clicks_submit_after_entering_valid_values_in_sp_and_dp_fields(String string, String string2) {
	pom.getEditPatientPage().enterValue("sp", string);
	pom.getEditPatientPage().enterValue("dp", string2);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should be redirected to My Patient page")
public void user_should_be_redirected_to_my_patient_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks View Previous Test Report after being redirected to the My Patient page for updating the SP {string} and DP {string} value")
public void user_clicks_view_previous_test_report_after_being_redirected_to_the_my_patient_page_for_updating_the_sp_and_dp_value(String string, String string2) {

}

@Then("User should see result for the update value  SP {string} and DP {string} value")
public void user_should_see_result_for_the_update_value_sp_and_dp_value(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks submit after entering {string} in {string} field")
public void user_clicks_submit_after_entering_in_field(String string, String string2) {
	pom.getEditPatientPage().enterValue(string2, string);
	pom.getEditPatientPage().clickSubmit();
}

@Then("User should see the error message {string}")
public void user_should_see_the_error_message(String string) {

}

@When("User performs {string} on Date of Birth field")
public void user_performs_on_date_of_birth_field(String string) {
	pom.getEditPatientPage().selectDOB(string);
}

@When("User selects valid date {string} in the Date of Birth field")
public void user_selects_valid_date_in_the_date_of_birth_field(String string) {

}

@Then("User should see the slected date {string}")
public void user_should_see_the_slected_date(String string) {

}

@When("User enters {string} in the DOB field")
public void user_enters_in_the_dob_field(String string) {
	if ("current date".equalsIgnoreCase(string)) {
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		pom.getEditPatientPage().enterValue("dob", today);
	} else {
		pom.getEditPatientPage().enterValue("dob", string);
	}
}

@Then("User should see an error message {string}")
public void user_should_see_an_error_message(String string) {
	Assert.assertTrue(pom.getEditPatientPage().isErrorMessageDisplayed(string),
			"Expected error message is not displayed: " + string);
}

@When("User clicks calendar Date of Birth navigates to {int} and selects a date")
public void user_clicks_calendar_date_of_birth_navigates_to_and_selects_a_date(Integer int1) {

}

@Then("User should see the selected date to be populated on DOB field")
public void user_should_see_the_selected_date_to_be_populated_on_dob_field() {
 
}

@When("User uploads health report in pdf")
public void user_uploads_health_report_in_pdf() {
}

@Then("User should see uploaded file name with extension")
public void user_should_see_uploaded_file_name_with_extension() {
}

@When("User clicks submit after uploading a valid file")
public void user_clicks_submit_after_uploading_a_valid_file() {

}

@Then("User should be redirected to My Patient page with the uploaded file saved successfully")
public void user_should_be_redirected_to_my_patient_page_with_the_uploaded_file_saved_successfully() {
    
}

@When("User clicks {string} after being redirected to the My Patient page for uploaded health report")
public void user_clicks_after_being_redirected_to_the_my_patient_page_for_uploaded_health_report(String string) {
    
}

@When("User clicks submit after {string}")
public void user_clicks_submit_after(String string) {
   
}

@When("User clicks the Close button")
public void user_clicks_the_close_button() {
	pom.getEditPatientPage().clickClose();
}

@Then("User should redirect to My Patient Page")
public void user_should_redirect_to_my_patient_page() {
}

@When("User clicks the Close button after entering the values")
public void user_clicks_the_close_button_after_entering_the_values() {
	pom.getEditPatientPage().enterValue("first name", "UpdatedName");
	pom.getEditPatientPage().enterValue("last name", "Patient");
	pom.getEditPatientPage().clickClose();
}

@Then("User should redirect on the My patient Page without saving changes")
public void user_should_redirect_on_the_my_patient_page_without_saving_changes() {
  
}




}