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
import utils.TestContext;

public class LoginPageStepDefinition {

	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(LoginPageStepDefinition.class);

	public LoginPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}

	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		pom.getLoginPage().browserIsOpen();
		logger.info("Browser is open and ready");

	}

	@When("User enters app url")
	public void user_enters_app_url() {
		String currentUrl = pom.getLoginPage().getCurrentUrl();
		logger.info("Navigated to URL: {}", currentUrl);

	}

	@Then("User should see the text {string} on left side of Navigation bar")
	public void user_should_see_the_text_on_left_side_of_navigation_bar(String expectedText) {

		boolean visible = pom.getLoginPage().isNavBarTextVisible(expectedText);
		logger.info("Checking visiblity of Navigation bar text: {}", expectedText);
		Assert.assertTrue(visible, "Navigation bar text is not visible:" + expectedText);

	}

	@Then("User should see the home icon on left side of navigation bar")
	public void user_should_see_the_home_icon_on_left_side_of_navigation_bar() {
		boolean visible = pom.getLoginPage().isHomeIconVisible();
		Assert.assertTrue(visible, "Home icon is not visible on the navigation bar");

	}

	@Then("Navigation bar background should have a blue-purple color")
	public void navigation_bar_background_should_have_a_blue_purple_color() {
		boolean correct = pom.getLoginPage().isNavBarColorCorrect("rgb(102, 51, 153)");
		Assert.assertTrue(correct, "Navigation bar background is not blue-purple");

	}

	@Then("User should see the heading {string} inside the login card")
	public void user_should_see_the_heading_inside_the_login_card(String expectedHeading) {

		boolean visible = pom.getLoginPage().isLoginHeadingVisible(expectedHeading);
		Assert.assertTrue(visible, "Login card heading is not visible: " + expectedHeading);

	}

	@Then("User should see the labels with text in Login page")
	public void user_should_see_the_labels_with_text_in_login_page(DataTable dataTable) {
		List<String> expectedLabels = dataTable.asList();
		List<String> actualLabels = pom.getLoginPage().getLoginLabelNames();

		logger.info("Verifying Login UI labels. Expected: {}, Actual: {}", expectedLabels, actualLabels);
		Assert.assertEquals(actualLabels, expectedLabels,
				"Label text mismatch. Expected: " + expectedLabels + ", Actual: " + actualLabels);

	}

	@Then("The input fields should be visible")
	public void theFollowingInputFieldsShouldBeVisible(List<String> fields) {
		for (String field : fields) {
			boolean visible = pom.getLoginPage().isInputFieldVisible(field);
			Assert.assertTrue(visible, field + " input field is not visible");
		}
	}

	@Then("Login button should be visible")
	public void login_button_should_be_visible() {
		Assert.assertTrue(pom.getLoginPage().isLoginButtonVisible());

	}

	@Then("Login button should be displayed with a blue-purple background and white text")
	public void login_button_should_be_displayed_with_a_blue_purple_background_and_white_text() {
		Assert.assertTrue(pom.getLoginPage().isLoginButtonStyledCorrectly());

	}

	@Then("Username and Password labels should be left-aligned above their respective input fields")
	public void username_and_password_labels_should_be_left_aligned_above_their_respective_input_fields() {

		Assert.assertTrue(pom.getLoginPage().areLabelsLeftAligned());

	}

	@Then("User should see exactly two input field")
	public void user_should_see_exactly_two_input_field() {

		Assert.assertEquals(pom.getLoginPage().getInputFieldCount(), 2);

	}

	@Then("User should see login button enabled")
	public void user_should_see_login_button_enabled() {

		Assert.assertTrue(pom.getLoginPage().isLoginButtonEnabled());

	}

	@When("the user enters {string} and clicks the Login button")
	public void the_user_enters_and_clicks_the_login_button(String inputType) {

		pom.getLoginPage().login("submits the login form", inputType);
	}

	@Then("the appropriate error message {string} should be displayed")
	public void the_appropriate_error_message_should_be_displayed(String expectedInField) {
		String expectedErrorMessage = TestContext.testData.get("expected_message");

		String actualErrorMessage = pom.getLoginPage().getDisplayedErrorMessage(expectedInField);

		logger.info("Verifying error message for field '{}'. Expected: '{}', Actual: '{}'", expectedInField,
				expectedErrorMessage, actualErrorMessage);

		Assert.assertEquals(actualErrorMessage.trim(), expectedErrorMessage.trim(),
				"Mismatch for invalid login scenario: " + TestContext.testData.get("username") + "/"
						+ TestContext.testData.get("password"));
	}

	@When("User {string} with {string}")
	public void user_with(String submissionMethod, String inputType) {
		logger.info("Performing login using method '{}' for scenario '{}'", submissionMethod, inputType);
		pom.getLoginPage().login(submissionMethod, inputType);
	}

	@Then("User should be redirected to the dashboard page")
	public void user_should_be_redirected_to_the_dashboard_page() {
		pom.getLoginPage().waitForDashBoardRedirect();

	}

}
