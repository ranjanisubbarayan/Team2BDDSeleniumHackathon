package stepdefinition;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;
import utils.ElementUtil;

public class MyPatientsPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(MyPatientsPageStepDefinition.class);
	int originalRowCount;
	List<String> beforePaginationIds;
	String searchText;
	String name;
	String id;

	public MyPatientsPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("User is in dietician application dashboard page")
	public void user_is_in_dietician_application_dashboard_page() {
		String currentUrl = ElementUtil.getURL();
		logger.info("Navigated to Dashboard Page URL: {}", currentUrl);
	}

	@When("User clicks on My Patients button")
	public void user_clicks_on_my_patients_button() {
		// pom.getDashboardPage().clickMyPatientsButton();

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
		Assert.assertTrue(pom.getMyPatientsPage().isDetailsInSeparateLines());
	}

	@Then("Email should be displayed in valid email format for each patient record")
	public void email_should_be_displayed_in_valid_email_format_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().isEmailValidForAllPatients());
	}

	@Then("Phone number displayed in details column should contain valid digits for each patient record")
	public void phone_number_displayed_in_details_column_should_contain_valid_digits_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().isPhoneNumberValidForAllPatients());
	}

	@Then("Date of birth should be displayed in {string} format for each patient record")
	public void date_of_birth_should_be_displayed_in_format_for_each_patient_record(String string) {
		Assert.assertTrue(pom.getMyPatientsPage().isDOBFormatValid());
	}

	@Then("Last visit date should be displayed for each patient record")
	public void last_visit_date_should_be_displayed_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().isLastVisitDateDisplayedForAllRows());
	}

	@Then("Last visit date should be displayed in 'dd-mm-yyyy\" format for each patient record")
	public void last_visit_date_should_be_displayed_in_dd_mm_yyyy_format_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().isLastVisitDateDisplayedForAllRows());
	}

	@Then("{string}, {string}, {string} should be displayed for each patient record")
	public void should_be_displayed_for_each_patient_record(String string, String string2, String string3) {
		Assert.assertTrue(pom.getMyPatientsPage().areActionButtonsDisplayed());
	}

	@Then("Edit icon should be displayed for each patient record")
	public void edit_icon_should_be_displayed_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().areAllEditIconsDisplayed());
	}

	@Then("Delete icon should be displayed for each patient record")
	public void delete_icon_should_be_displayed_for_each_patient_record() {
		Assert.assertTrue(pom.getMyPatientsPage().areAllDeleteIconsDisplayed());
	}

	@Given("User is in My Patients page")
	public void user_is_in_my_patients_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("User clicks up arrow in Patient Id column")
	public void user_clicks_up_arrow_in_patient_id_column() {
		pom.getMyPatientsPage().clickUpArrowPatientId();
	}

	@Then("Patient records should be sorted in ascending order by patient id")
	public void patient_records_should_be_sorted_in_ascending_order_by_patient_id() {
		List<Integer> ids = pom.getMyPatientsPage().getPatientIds();

		boolean sorted = pom.getMyPatientsPage().isSortedAscendingId(ids);
		Assert.assertTrue(sorted, "Patient Ids are not sorted in ascending order");
	}

	@When("User clicks down arrow in Patient Id column")
	public void user_clicks_down_arrow_in_patient_id_column() {
		pom.getMyPatientsPage().clickDownArrowPatientId();
	}

	@Then("Patient records should be sorted in descending order by patient id")
	public void patient_records_should_be_sorted_in_descending_order_by_patient_id() {
		List<Integer> ids = pom.getMyPatientsPage().getPatientIds();

		boolean sorted = pom.getMyPatientsPage().isSortedDescendingId(ids);
		Assert.assertTrue(sorted, "Patient Ids are not sorted in descending order");
	}

	@When("User clicks up arrow in Name column")
	public void user_clicks_up_arrow_in_name_column() {
		pom.getMyPatientsPage().clickUpArrowPatientName();
	}

	@Then("Patient records should be sorted in ascending order by name")
	public void patient_records_should_be_sorted_in_ascending_order_by_name() {
		List<String> names = pom.getMyPatientsPage().getPatientNames();

		boolean sorted = pom.getMyPatientsPage().isSortedAscendingName(names);
		Assert.assertTrue(sorted, "Patient names are not sorted in ascending order");
	}

	@When("User clicks down arrow in Name column")
	public void user_clicks_down_arrow_in_name_column() {
		pom.getMyPatientsPage().clickDownArrowPatientName();
	}

	@Then("Patient records should be sorted in descending order by name")
	public void patient_records_should_be_sorted_in_descending_order_by_name() {
		List<String> names = pom.getMyPatientsPage().getPatientNames();

		boolean sorted = pom.getMyPatientsPage().isSortedDescendingName(names);
		Assert.assertTrue(sorted, "Patient names are not sorted in descending order");
	}

	@When("User searches using patient name")
	public void user_searches_using_patient_name() {
		pom.getMyPatientsPage().searchByPatientName(name);
	}

	@Then("Matching patient details should be displayed")
	public void matching_patient_details_should_be_displayed() {
		logger.info("Validating search results for: " + searchText);
		pom.getMyPatientsPage().isMatchingPatientDetailsDisplayed(searchText);
	}

	@When("User searched using patient id")
	public void user_searched_using_patient_id() {
		pom.getMyPatientsPage().searchByPatientId(id);
	}

	@When("User clicks View Previous Test Reports under action column")
	public void user_clicks_view_previous_test_reports_under_action_column() {
		pom.getMyPatientsPage().clickViewPreviousTestReports();
	}

	@Then("User should be navigated to {string} page")
	public void user_should_be_navigated_to_page(String expectedReportHeader) {
		Assert.assertEquals(expectedReportHeader, pom.getMyPatientsPage().getReportPageHeader());
	}

	@Given("User entered the text in search box in My Patients page")
	public void user_entered_the_text_in_search_box_in_my_patients_page() {
		pom.getMyPatientsPage().enterSearchText(name);
	}

	@When("User clears the search text")
	public void user_clears_the_search_text() {
		pom.getMyPatientsPage().clearSearchText();
	}

	@Then("All patient records should be displayed again")
	public void all_patient_records_should_be_displayed_again() {
		int currentRowCount = pom.getMyPatientsPage().getDisplayedRowCount();
		Assert.assertEquals(currentRowCount, originalRowCount);

	}

	@Given("User is in My Patients page with multiple pages of patient record")
	public void user_is_in_my_patients_page_with_multiple_pages_of_patient_record() {
		pom.getMyPatientsPage().clickMyPatientsButton();
	}

	@When("User clicks the next page arrow \\(>)")
	public void user_clicks_the_next_page_arrow() {
		beforePaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();

		pom.getMyPatientsPage().clickNextPage();
	}

	@Then("Next set of  patient records should be displayed")
	public void next_set_of_patient_records_should_be_displayed() {
		List<String> afterClickPaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		Assert.assertNotEquals(beforePaginationIds, afterClickPaginationIds);

	}

	@Given("User is in later page of My Patients page")
	public void user_is_in_later_page_of_my_patients_page() {
		pom.getMyPatientsPage().clickNextPage();
	}

	@When("User clicks the previous page arrow \\(<)")
	public void user_clicks_the_previous_page_arrow() {
		beforePaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();

		pom.getMyPatientsPage().clickPreviousPage();
	}

	@Then("Previous set of patient records should be displayed in My Patients page")
	public void previous_set_of_patient_records_should_be_displayed_in_my_patients() {

		List<String> afterClickPaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		Assert.assertNotEquals(beforePaginationIds, afterClickPaginationIds);

	}

	@Given("User is in any page except first page of My Patients page")
	public void user_is_in_any_page_except_first_page_of_my_patients_page() {
		pom.getMyPatientsPage().clickNextPage();

	}

	@When("User clicks the first page arrow \\(<<)")
	public void user_clicks_the_first_page_arrow() {
		beforePaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		pom.getMyPatientsPage().clickFirstPage();

	}

	@Then("First page of patient records should be displayed")
	public void first_page_of_patient_records_should_be_displayed() {
		List<String> afterClickPaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		Assert.assertNotEquals(beforePaginationIds, afterClickPaginationIds);

	}

	@Given("User is in any page except last page of My Patients page")
	public void user_is_in_any_page_except_last_page_of_my_patients_page() {
		pom.getMyPatientsPage().clickFirstPage();

	}

	@When("User clicks the last page arrow \\(>>)")
	public void user_clicks_the_last_page_arrow() {
		beforePaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		pom.getMyPatientsPage().clickLastPage();
	}

	@Then("Last page of patient records should be displayed")
	public void last_page_of_patient_records_should_be_displayed() {
		List<String> afterClickPaginationIds = pom.getMyPatientsPage().getDisplayedPatientIds();
		Assert.assertNotEquals(beforePaginationIds, afterClickPaginationIds);

	}

	@When("User navigates to the first page of patient record")
	public void user_navigates_to_the_first_page_of_patient_record() {
		pom.getMyPatientsPage().clickFirstPage();
	}

	@Then("Previous arrow \\(<) should be disabled")
	public void previous_arrow_should_be_disabled() {
		boolean disabled = pom.getMyPatientsPage().isPreviousArrowDisabled();
		Assert.assertTrue(disabled, "Expected Previous arrow to be enabled");
	}

	@Then("First page arrow \\(<<) should be disabled")
	public void first_page_arrow_should_be_disabled() {
		boolean disabled = pom.getMyPatientsPage().isFirstPageArrowDisabled();
		Assert.assertTrue(disabled, "Expected First page arrow to be enabled");

	}

	@Then("Next arrow \\(>) should be enabled")
	public void next_arrow_should_be_enabled() {
		boolean enabled = pom.getMyPatientsPage().isNextPageArrowEnabled();
		Assert.assertTrue(enabled, "Next page arrow to be disabled");

	}

	@Then("Last page arrow \\(>>) should be enabled")
	public void last_page_arrow_should_be_enabled() {
		boolean enabled = pom.getMyPatientsPage().isLastPageArrowEnabled();
		Assert.assertTrue(enabled, "Last page arrow to be disabled");
	}

	@When("User navigates to any page after the first page")
	public void user_navigates_to_any_page_after_the_first_page() {
		pom.getMyPatientsPage().clickNextPage();
	}

	@Then("Previous arrow \\(<) should be enabled")
	public void previous_arrow_should_be_enabled() {
		boolean enabled = pom.getMyPatientsPage().isPreviousArrowEnabled();
		Assert.assertTrue(enabled, "Previous page arrow to be disabled");
	}

	@Then("First page arrow \\(<<) should be enabled")
	public void first_page_arrow_should_be_enabled() {
		boolean enabled = pom.getMyPatientsPage().isFirstPageArrowEnabled();
		Assert.assertTrue(enabled, "First page arrow to be disabled");
	}

	@When("User navigates to any page except the last page")
	public void user_navigates_to_any_page_except_the_last_page() {
		pom.getMyPatientsPage().clickFirstPage();
	}

	@When("User navigates to the last page of the patient record")
	public void user_navigates_to_the_last_page_of_the_patient_record() {
		pom.getMyPatientsPage().clickLastPage();
	}

	@Then("Next arrow \\(>) should be disabled")
	public void next_arrow_should_be_disabled() {
		boolean disabled = pom.getMyPatientsPage().isNextPageArrowDisabled();
		Assert.assertTrue(disabled, "Expected Next page arrow to be enabled");
	}

	@Then("Last page arrow \\(>>) should be  disabled")
	public void last_page_arrow_should_be_disabled() {
		boolean disabled = pom.getMyPatientsPage().isLastPageArrowDisabled();
		Assert.assertTrue(disabled, "Expected Last page arrow to be enabled");
	}

	@Then("User should see only {int} records in each page")
	public void user_should_see_only_records_in_each_page(Integer int1) {

		int rowCount = pom.getMyPatientsPage().getDisplayedRowCount();
		Assert.assertEquals(rowCount, 5, "Each page should display exactly 5 records");
	}

	@Then("My Patients page should display {string}")
	public void my_patients_page_should_display(String string) {

		String actualText = pom.getMyPatientsPage().getPaginationInfoText();
		String expectedText = "Showing 0 to 0 of 0 patients";

		logger.info("Validating pagination text for empty patient table");
		Assert.assertEquals(actualText, expectedText);
	}

	@Then("First, previous, next, last arrows should be disabled")
	public void first_previous_next_last_arrows_should_be_disabled() {
		logger.info("Checking First, previous, next, last arrows should be disabled");
		Assert.assertTrue(pom.getMyPatientsPage().isNoDataPresent(), " Expected Patient records");
		Assert.assertTrue(pom.getMyPatientsPage().isLastPageArrowDisabled(), "Last page arrow is enabled");
		Assert.assertTrue(pom.getMyPatientsPage().isFirstPageArrowDisabled(), "First page arrow is enabled");
		Assert.assertTrue(pom.getMyPatientsPage().isPreviousArrowDisabled(), "Previous page arrow is enabled");
		Assert.assertTrue(pom.getMyPatientsPage().isNextPageArrowDisabled(), "Next page arrow is enabled");

	}

	@Then("My Patients page should display with empty table")
	public void my_patients_page_should_display_with_empty_table() {
		Assert.assertTrue(pom.getMyPatientsPage().isNoDataPresent(), "Patients records are present");
	}

	@When("User navigates to any page in My Patients")
	public void user_navigates_to_any_page_in_my_patients() {

		pom.getMyPatientsPage().clickNextPage();
	}

	@Then("Pagination controls should be displayed in My Patients page")
	public void pagination_controls_should_be_displayed() {
		Assert.assertTrue(pom.getMyPatientsPage().arePaginationControlsDisplayed(),
				"Pagination control are not displayed");
	}

	@Given("User is in any page of My Patients page")
	public void user_is_in_any_page_of_my_patients_page() {
		// pom.getDashboardPage().clickMyPatientsButton();

	}

	@When("User clicks any page navigation arrow")
	public void user_clicks_any_page_navigation_arrow() {
		pom.getMyPatientsPage().clickNextPage();
	}

	@Then("Pagination text should display the correct range and total number of patients")
	public void pagination_text_should_display_the_correct_range_and_total_number_of_patients() {
		logger.info("Validating pagination text updates correctly");

		String text = pom.getMyPatientsPage().getPaginationInfoText();
		logger.info("Pagination text displayed: " + text);

		int start = pom.getMyPatientsPage().getStartCount();
		int end = pom.getMyPatientsPage().getEndCount();
		int total = pom.getMyPatientsPage().getTotalCount();

		Assert.assertTrue(start <= end, "Start count should be <= end count");
		Assert.assertTrue(end <= total, "End count should be <= total count");
		Assert.assertTrue(total > 0, "Total count should be > 0");
	}

}
