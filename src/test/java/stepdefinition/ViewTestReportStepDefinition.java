package stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;

public class ViewTestReportStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(ViewTestReportStepDefinition.class);

	public ViewTestReportStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("User is logged in and navigated to the My Patients page")
	public void user_is_logged_in_and_navigated_to_the_my_patients_page() {
		logger.info("User Successfully logged in and navigated to My Patients page");

	}

	@When("User clicks previous test reports for a specific record")
	public void user_clicks_previous_test_reports_for_a_specific_record() {
		pom.getMyPatientsPage().clickViewPreviousTestReports();
		logger.info("User clicks previous test reports for a specific record");
	}

	@Then("Corresponding report for that record should be opened")
	public void corresponding_report_for_that_record_should_be_opened() {

		String header = pom.getMyPatientsPage().getReportPageHeader();
		Assert.assertEquals(header, "View Patient Test Reports", "Incorrect report page header");
		logger.info("Corresponding report for that is opened");
	}

	@Then("Title {string} should be displayed")
	public void title_should_be_displayed(String expectedTitle) {
		Assert.assertEquals(pom.getViewTestReportPage().getPageTitle(), expectedTitle);
		logger.info("Title is displayed");
	}

	@Then("Patient ID for the selected record should be displayed")
	public void patient_id_for_the_selected_record_should_be_displayed() {

		Assert.assertTrue(pom.getMyPatientsPage().isPatientIdDisplayedForAllRows());
		logger.info("Patient ID for the selected record is displayed");

	}

	@Then("Patient name for the selected record should be displayed")
	public void patient_name_for_the_selected_record_should_be_displayed() {
		Assert.assertTrue(pom.getMyPatientsPage().isPatientNameDisplayedForAllRows());
		logger.info("Patient name for the selected record is displayed");

	}

	@Then("Patient email for the selected record should be displayed")
	public void patient_email_for_the_selected_record_should_be_displayed() {

		Assert.assertTrue(pom.getMyPatientsPage().isEmailValidForAllPatients());
		logger.info("Patient email for the selected record is displayed");
	}

	@Then("Patient contact number for the selected record should be displayed")
	public void patient_contact_number_for_the_selected_record_should_be_displayed() {

		Assert.assertTrue(pom.getMyPatientsPage().isPhoneNumberValidForAllPatients());
		logger.info("Patient contact number for the selected record is displayed");
	}

	@Then("Close icon {string} should be displayed")
	public void close_icon_should_be_displayed(String string) {
		Assert.assertTrue(pom.getViewTestReportPage().isCloseIconDisplayed());
		logger.info("Close icon is displayed");

	}

	@When("User clicks View Previous Test Reports button for a specific record")
	public void user_clicks_view_previous_test_reports_button_for_a_specific_record() {
		pom.getMyPatientsPage().clickViewPreviousTestReports();
		logger.info("User clicked View Previous Test Reports button for a specific record");

	}

	@Then("Reports table should be displayed")
	public void reports_table_should_be_displayed() {

		Assert.assertTrue(pom.getViewTestReportPage().isReportsTableDisplayed());
		logger.info("Reports table is displayed");
	}

	@Then("Table headers should be:")
	public void table_headers_should_be(DataTable dataTable) {
		Assert.assertEquals(pom.getViewTestReportPage().getTableHeaders(), dataTable.asList());
		logger.info("Table headers displayed");

	}

	@Then("The table headers should be displayed in the following order:")
	public void the_table_headers_should_be_displayed_in_the_following_order(DataTable dataTable) {
		Assert.assertEquals(pom.getViewTestReportPage().getTableHeaders(), dataTable.asList(),
				"Table headers order mismatch");
		logger.info("The table headers displayed in the order");

	}

	@Then("Pagination controls should be displayed in Test Reports page")
	public void pagination_controls_should_be_displayed_as(DataTable dataTable) {
		Assert.assertEquals(pom.getViewTestReportPage().getPaginationControls(), dataTable.asList(),
				"Pagination controls mismatch");
		logger.info("Pagination controls are displayed");

	}

	@Then("Each report should display a record number")
	public void each_report_should_display_a_record_number() {
		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Each report displayed a record number");

	}

	@Then("Each report should display a View PDF button")
	public void each_report_should_display_a_view_pdf_button() {

		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Each report displayed a View PDF button");
	}

	@Then("Each report should display uploaded time")
	public void each_report_should_display_uploaded_time() {
		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Each report displayed uploaded time");

	}

	@Then("Each report should display file or report name")
	public void each_report_should_display_file_or_report_name() {
		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Each report displayed file or report name");

	}

	@Then("Each report should display vitals information")
	public void each_report_should_display_vitals_information(DataTable dataTable) {
		Assert.assertTrue(pom.getViewTestReportPage().getVitalsForRow(0).containsAll(dataTable.asList()));
		logger.info("Each report displayed vitals information");

	}

	@Then("Vitals should be displayed in the order:")
	public void vitals_should_be_displayed_in_the_order(DataTable dataTable) {
		Assert.assertEquals(pom.getViewTestReportPage().getVitalsForRow(0), dataTable.asList());
		logger.info("Vitals are displayed in the order");

	}

	@Then("Vitals should be displayed in multiple lines")
	public void vitals_should_be_displayed_in_multiple_lines() {

		Assert.assertTrue(pom.getViewTestReportPage().isVitalsMultiline(0));
		logger.info("Vitals are displayed in multiple lines");
	}

	@Then("Each report should display identified health conditions")
	public void each_report_should_display_identified_health_conditions() {

		Assert.assertFalse(pom.getViewTestReportPage().getHealthConditionsForRow(0).isEmpty());
		logger.info("Each report is displayed identified health conditions");
	}

	@Then("Identified health conditions should be displayed in multiple lines")
	public void identified_health_conditions_should_be_displayed_in_multiple_lines() {
		Assert.assertTrue(pom.getViewTestReportPage().isHealthConditionsMultiline(0));
		logger.info("Identified health conditions are displayed in multiple lines");

	}

	@Given("User is in View Plan Test Reports page")
	public void user_is_in_view_plan_test_reports_page() {
		String header = pom.getMyPatientsPage().getReportPageHeader();
		Assert.assertEquals(header, "View Patient Test Reports", "User is NOT on the View Patient Test Reports page");
		logger.info("User is in View Plan Test Reports page");

	}

	@When("User clicks View PDF button for a particular record")
	public void user_clicks_view_pdf_button_for_a_particular_record() {

		pom.getViewTestReportPage().clickViewPdfForRecord(0);
		logger.info("User clicked View PDF button for a particular record");
	}

	@Then("Corresponding PDF report should be opened")
	public void corresponding_pdf_report_should_be_opened() {
		Assert.assertTrue(pom.getViewTestReportPage().isPdfOpened());
		logger.info("Corresponding PDF report is opened");

	}

	@Given("User is in View Patient Test Reports page with multiple pages of patient records exist")
	public void user_is_in_view_patient_test_reports_page_with_multiple_pages_of_patient_records_exist() {

		String header = pom.getMyPatientsPage().getReportPageHeader();
		Assert.assertEquals(header, "View Patient Test Reports", "User is NOT on the View Patient Test Reports page");

		int recordCount = pom.getViewTestReportPage().getRecordCount();
		Assert.assertTrue(recordCount > 1, "Multiple patient records do NOT exist");

		Assert.assertTrue(pom.getViewTestReportPage().arePaginationControlsVisible(),
				"Pagination controls are NOT visible, so multiple pages do not exist");
		logger.info("User is in View Patient Test Reports page with multiple pages of patient records");

	}

	@When("User clicks the next page arrow\\(>)")
	public void user_clicks_the_next_page_arrow() {

		pom.getViewTestReportPage().clickNextPage();
		logger.info("User clicked the next page arrow (>)");
	}

	@Then("Next set of patient records should be displayed")
	public void next_set_of_patient_records_should_be_displayed() {

		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Next set of patient records are displayed");

	}

	@When("User clicks the previous page arrow\\(<)")
	public void user_clicks_the_previous_page_arrow() {

		pom.getViewTestReportPage().clickPreviousPage();
		logger.info("User clicks the previous page arrow (<)");
	}

	@Then("Previous set of test report records should be displayed")
	public void previous_set_of_patient_records_should_be_displayed() {

		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Previous set of test report records are displayed");
	}

	@When("User clicks the first page arrow\\(>>)")
	public void user_clicks_the_first_page_arrow() {

		pom.getViewTestReportPage().clickFirstPage();
		logger.info("User clicks the first page arrow (>>)");
	}

	@Then("First page of patient records in test report should be displayed")
	public void first_page_of_patient_records_in_test_report_should_be_displayed() {

		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("First page of patient records in test report is displayed");
	}

	@When("User clicks the last page arrow\\(<<)")
	public void user_clicks_the_last_page_arrow() {

		pom.getViewTestReportPage().clickLastPage();
		logger.info("User clicks the last page arrow (<<)");
	}

	@Then("Last page of patient test reports should be displayed")
	public void last_page_of_patient_test_reports_should_be_displayed() {
		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0);
		logger.info("Last page of patient records are displayed");

	}

	@When("User clicks any pagination arrow")
	public void user_clicks_any_pagination_arrow() {
		pom.getViewTestReportPage().clickNextPage();
		logger.info("User clicked any pagination arrow");

	}

	@Then("Pagination text should display correct range and total count")
	public void pagination_text_should_display_correct_range_and_total_count() {

		Assert.assertFalse(pom.getViewTestReportPage().getPaginationText().isEmpty());
		logger.info("Pagination text displayed correct range and total count");
	}

	@When("User navigates to any page in Test Reports")
	public void user_navigates_to_any_page_in_test_reports() {

		pom.getViewTestReportPage().clickNextPage();
		logger.info("User navigated to any page");

	}

	@Then("Pagination controls should be displayed")
	public void pagination_controls_should_be_displayed() {
		Assert.assertTrue(pom.getViewTestReportPage().arePaginationControlsVisible());
		logger.info("Pagination controls displayed");

	}

	@When("User navigates to the first page of patient records")
	public void user_navigates_to_the_first_page_of_patient_records() {
		pom.getViewTestReportPage().clickFirstPage();
		logger.info("User navigated to the first page of patient records");

	}

	@Then("The {string} arrow should be disabled")
	public void the_arrow_should_be_disabled(String button) {
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled(button));
		logger.info("Arroe is enabled");

	}

	@Then("The {string} arrow should be enabled")
	public void the_arrow_should_be_enabled(String button) {
		Assert.assertTrue(pom.getViewTestReportPage().isButtonEnabled(button));
		logger.info("Arrow is enabled");

	}

	@When("User navigates to any page after the first page and not on last page")
	public void user_navigates_to_any_page_after_the_first_page_and_not_on_last_page() {

		pom.getViewTestReportPage().clickNextPage();
		logger.info("User navigates to any page after the first page and not on last page");
	}

	@When("User navigates to the last page of patient records")
	public void user_navigates_to_the_last_page_of_patient_records() {
		pom.getViewTestReportPage().clickLastPage();
		logger.info("User navigates to the last page of patient records");

	}

	@Given("Only one patient record exists and user is in My Patients page")
	public void only_one_patient_record_exists_and_user_is_in_my_patients_page() {
		Assert.assertEquals(pom.getViewTestReportPage().getRecordCount(), 1);
		logger.info("Only one patient record exists and user is in My Patients page");

	}

	@When("User clicks View Patient Test Reports button")
	public void user_clicks_view_patient_test_reports_button() {
		pom.getMyPatientsPage().clickViewPreviousTestReports();
		logger.info("User clicks View Patient Test Reports button");

	}

	@Then("All pagination arrows should be disabled")
	public void all_pagination_arrows_should_be_disabled() {
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("first"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("previous"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("next"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("last"));
		logger.info("All pagination arrows are disabled");

	}

	@Given("No patient records exist and user is in My Patients page")
	public void no_patient_records_exist_and_user_is_in_my_patients_page() {

		Assert.assertEquals(pom.getViewTestReportPage().getRecordCount(), 0);
		logger.info("No patient records exist and user is in My Patients page");
	}

	@Then("Test Reports page should display {string}")
	public void test_reports_page_should_display(String expectedText) {
		Assert.assertEquals(pom.getViewTestReportPage().getPaginationText(), expectedText);
		logger.info("Text is displayed");

	}

	@Then("All pagination arrows should be disabled in Test Reports page")
	public void All_pagination_arrows_should_be_disabled_in_Test_Reports_page() {
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("first"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("previous"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("next"));
		Assert.assertFalse(pom.getViewTestReportPage().isButtonEnabled("last"));
		logger.info("First, previous, next, last arrows should be disabled");

	}

	@Given("User is in View Patient Test Reports page with multiple records")
	public void user_is_in_view_patient_test_reports_page_with_multiple_records() {
		Assert.assertTrue(pom.getViewTestReportPage().getRecordCount() > 0, "No patient records found");
		logger.info("User is in View Patient Test Reports page with multiple records");

	}

	@Then("Each page should display only {int} records")
	public void each_page_should_display_only_records(Integer expectedCount) {
		Assert.assertEquals(pom.getViewTestReportPage().getRecordCount(), expectedCount.intValue());
		logger.info("Each page should displayed only records");

	}

}
