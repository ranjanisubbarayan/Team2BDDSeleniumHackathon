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
import utils.ElementUtil;

public class DashboardPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(DashboardPageStepDefinition.class);

	public DashboardPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("the logged in user has navigated to the dashboard page")
	public void the_logged_in_user_has_navigated_to_the_dashboard_page() {
		logger.info("User is on Dashboard page. URL: {}", ElementUtil.getURL());
	}

	@Then("Navigation bar should display exactly the following links")
	public void navigation_bar_should_display_exactly_the_following_links(DataTable dataTable) {

		List<String> expectedLinks = dataTable.asList();
		List<String> actualLinks = pom.getDashboardPage().getNavigationLinks();

		logger.info("Validating Dashboard page links. Expected: {}, Actual: {}", expectedLinks, actualLinks);

		Assert.assertEquals(actualLinks.size(), expectedLinks.size(), "Link count mismatch");
		Assert.assertEquals(actualLinks, expectedLinks, "Navigation links mismatch");
	}

	@When("User clicks the \"My Patients\" link in the navigation bar")
	public void user_clicks_my_patients_link() {
		logger.info("Clicking My Patients link");
		pom.getDashboardPage().clickMyPatientsLink();
	}

	@Then("User should be redirected to the My Patients page")
	public void user_should_be_redirected_to_the_my_patients_page() {
		logger.info("Validating redirection to My Patients page");
		Assert.assertTrue(ElementUtil.getURL().contains("mypatients"));
	}

	@When("User clicks the \"New Patient\" link in the navigation bar")
	public void user_clicks_new_patient_link() {
		logger.info("Clicking New Patient link");
		pom.getDashboardPage().clickNewPatientLink();
	}

	@Then("User should be redirected to the New Patient page")
	public void user_should_be_redirected_to_the_new_patient_page() {
		logger.info("Validating redirection to New Patient page");
		Assert.assertTrue(ElementUtil.getURL().contains("newpatient"));
	}

	@When("User clicks the \"Login\" link in the navigation bar")
	public void user_clicks_login_link() {
		logger.info("Clicking Login link");
		pom.getDashboardPage().clickLoginLink();
	}

	@Then("User should be redirected to the Login page")
	public void user_should_be_redirected_to_login_page() {
		logger.info("Validating redirection to Login page");
		Assert.assertTrue(ElementUtil.getURL().contains("login"));
	}

	@When("User clicks the \"Logout\" link in the navigation bar")
	public void user_clicks_logout_link() {
		logger.info("Clicking Logout link");
		pom.getDashboardPage().clickLogoutLink();
	}

	@Then("User should be logged out of the application")
	public void user_should_be_logged_out_of_the_application() {
		logger.info("Validating logout redirection");
		Assert.assertTrue(ElementUtil.getURL().contains("login"));
	}

	@When("User clicks the Home icon on the navigation bar")
	public void user_clicks_the_home_icon_on_the_navigation_bar() {
		logger.info("Clicking Home icon");
		pom.getDashboardPage().clickHomeIcon();
	}

	@Then("User should be navigated to the dashboard page")
	public void user_should_be_navigated_to_the_dashboard_page() {
		logger.info("Validating navigation to Dashboard page");
		Assert.assertTrue(ElementUtil.getURL().contains("dashboard"));
	}
}
