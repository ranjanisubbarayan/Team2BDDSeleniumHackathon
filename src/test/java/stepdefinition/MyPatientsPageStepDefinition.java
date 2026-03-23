package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;

public class MyPatientsPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(MyPatientsPageStepDefinition.class);

	public MyPatientsPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

		
		@Given("User is in dietician application dashboard page")
		public void user_is_in_dietician_application_dashboard_page() {
			
		    		}

		@When("User clicks on My Patients button")
		public void user_clicks_on_my_patients_button() {
			pom.getMyPatientsPage().clickMyPatientsButton();
		    
		}

		@Then("Page header {string} should be displayed")
		public void page_header_should_be_displayed(String expectedHeader) {
		   Assert.assertEquals(expectedHeader, pom.getMyPatientsPage().getPageHeader());
		}
		
		@Then("Search bar should be displayed")
		public void search_bar_should_be_displayed() {
		   Assert.assertTrue(pom.getMyPatientsPage().isSearchBarDisplayed());
		}
		@Then("Search icon should be displayed inside the search bar")
		public void search_icon_should_be_displayed_inside_the_search_bar() {
		   Assert.assertTrue(pom.getMyPatientsPage().isSearchIconDisplayed());
		}

		@Then("Placeholder text {string} should be displayed")
		public void placeholder_text_should_be_displayed(String expectedText) {
		   Assert.assertTrue(pom.getMyPatientsPage().isPlaceholderDisplayed(expectedText));
		}

		@Then("The table header {string} should be displayed")
		public void the_table_header_should_be_displayed(String header) {
			Assert.assertTrue(pom.getMyPatientsPage().isHeaderDisplayed(header));
		   
		}


		@Then("Up and down arrow icons should be displayed in the Patient Id column header")
		public void up_and_down_arrow_icons_should_be_displayed_in_the_patient_id_column_header() {
		    Assert.assertTrue(pom.getMyPatientsPage().isUpArrowPatientIdDisplayed());
		    Assert.assertTrue(pom.getMyPatientsPage().isDownArrowPatientIdDisplayed());
		}

		@Then("Up and down arrow icons should be displayed in the Name column header")
		public void up_and_down_arrow_icons_should_be_displayed_in_the_name_column_header() {
			 Assert.assertTrue(pom.getMyPatientsPage().isUpArrowNameDisplayed());
			 Assert.assertTrue(pom.getMyPatientsPage().isDownArrowNameDisplayed());
		}

		@Then("Each row in the {string} column should have a value")
		public void each_row_in_the_column_should_have_a_value(String column) {
		    Assert.assertTrue(pom.getMyPatientsPage().doesColumnHaveValues(column));
		}

		@Then("Patient Id should be displayed for each patient record")
		public void patient_id_should_be_displayed_for_each_patient_record() {
		    Assert.assertTrue(pom.getMyPatientsPage().isPatientIdDisplayedForAllRows());
		}

		@Then("Patient name should be displayed for each patient record")
		public void patient_name_should_be_displayed_for_each_patient_record() {
			Assert.assertTrue(pom.getMyPatientsPage().isPatientNameDisplayedForAllRows());
		}

		@Then("Details column should contain {string} for each patient record")
		public void details_column_should_contain_for_each_patient_record(String fieldName) {
		   Assert.assertTrue(pom.getMyPatientsPage().doesDetailsColumnContainField(fieldName));
		}


		@Then("Phone number, email , date of birth should be displayed on separate lines for each patient record")
		public void phone_number_email_date_of_birth_should_be_displayed_on_separate_lines_for_each_patient_record() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Email should be displayed in valid email format for each patient record")
		public void email_should_be_displayed_in_valid_email_format_for_each_patient_record() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Phone number displayed in details column should contain valid digits for each patient record")
		public void phone_number_displayed_in_details_column_should_contain_valid_digits_for_each_patient_record() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Date of birth should be displayed in {string} format for each patient record")
		public void date_of_birth_should_be_displayed_in_format_for_each_patient_record(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Last visit date should be displayed for each patient record")
		public void last_visit_date_should_be_displayed_for_each_patient_record() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Last visit date should be displayed in 'dd-mm-yyyy\" format for each patient record")
		public void last_visit_date_should_be_displayed_in_dd_mm_yyyy_format_for_each_patient_record() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("{string}, {string}, {string} should be displayed for each patient record")
		public void should_be_displayed_for_each_patient_record(String string, String string2, String string3) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("Edit icon should be displayed for each patient record")
		public void edit_icon_should_be_displayed_for_each_patient_record() {
		   Assert.assertTrue(pom.getMyPatientsPage().areAllEditIconsDisplayed());
		}

		@Then("Delete icon should be displayed for each patient record")
		public void delete_icon_should_be_displayed_for_each_patient_record() {
			Assert.assertTrue(pom.getMyPatientsPage().areAllDeleteIconsDisplayed());   
		}


	}


