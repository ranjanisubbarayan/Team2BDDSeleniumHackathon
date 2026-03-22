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

		String currentUrl = ElementUtil.getURL();
		logger.info("Navigated to Dashboard Page URL: {}", currentUrl);

	}

	@Then("Navigation bar should display exactly the following links")
	public void navigation_bar_should_display_exactly_the_following_links(DataTable dataTable) {

		List<String> expectedLinks = dataTable.asList();
		List<String> actualLinks = pom.getDashboardPage().getNavigationLinks();

		logger.info("Validating Dashboard page links. Expected: {}, Actual: {}", expectedLinks, actualLinks);

		Assert.assertEquals(actualLinks.size(), expectedLinks.size(), "Link count mismatch");

		Assert.assertEquals(actualLinks, expectedLinks,
				"Link text mismatch. Expected: " + expectedLinks + ", Actual: " + actualLinks);

	}

	@When("User clicks the {string} link in the navigation bar")
	public void user_clicks_the_link_in_the_navigation_bar(String linkText) {

		pom.getDashboardPage().clickNavigationLink(linkText);

	}

	@Then("User should be redirected to the My Patients page")
	public void user_should_be_redirected_to_the_my_patients_page() {

		Assert.assertTrue(ElementUtil.getURL().contains("mypatients"), "User is not on My Patients page");

	}

	@Then("User should be redirected to the New Patient page")
	public void user_should_be_redirected_to_the_new_patient_page() {

		Assert.assertTrue(ElementUtil.getURL().contains("newpatient"), "User is not on New Patients page");

	}

	@Then("User should be logged out of the application")
	public void user_should_be_logged_out_of_the_application() {

		Assert.assertTrue(ElementUtil.getURL().contains("login"), "User is not redirected to Login page after logout");

	}

	@When("User clicks the Home icon on the navigation bar")
	public void user_clicks_the_home_icon_on_the_navigation_bar() {

		pom.getDashboardPage().clickHomeIcon();

	}

	@Then("User should be navigated to the dashboard page")
	public void user_should_be_navigated_to_the_dashboard_page() {

		Assert.assertTrue(ElementUtil.getURL().contains("dashboard"), "User is not on the Dashboard page");

	}

}
