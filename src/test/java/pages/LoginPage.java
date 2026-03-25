package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;
import utils.ExcelReader;
import utils.JSUtils;
import utils.TestContext;
import utils.WaitUtils;

public class LoginPage {
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private WebDriver driver;

	@FindBy(css = "nav .navbar-brand")
	private WebElement navBarText;

	@FindBy(css = "i.fa-home")
	private WebElement homeIcon;

	@FindBy(css = "nav.navbar")
	private WebElement navBar;

	@FindBy(xpath = "//div[@class='login-card']//h2")
	private WebElement loginCardHeading;

	@FindBy(xpath = "//label")
	private List<WebElement> labelList;

	@FindBy(id = "id_username")
	private WebElement usernameField;

	@FindBy(id = "id_password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = ("//div[@role='alert']"))
	private WebElement error;

	public LoginPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		logger.info("LoginPage initialized successfully");
	}

	public void browserIsOpen() {
		logger.info("Checking browser is initialized");
		if (driver == null) {
			logger.error("WebDriver is not initialized");
			throw new IllegalStateException("WebDriver is not initialized");
		}
		logger.info("WebDriver is active");
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		logger.info("Current URL : {}", url);
		return url;
	}

	public boolean isNavBarTextVisible(String expectedText) {
		logger.info("Checking if navigation bar contains text '{}'", expectedText);

		String actualText = navBarText.getText().trim();
		boolean visible = actualText.equalsIgnoreCase(expectedText);

		logger.info("Navigation bar text Expected: '{}', Actual: '{}', Result: {}", expectedText, actualText, visible);

		return visible;
	}

	public boolean isHomeIconVisible() {
		logger.info("Checking if Home icon is visible on the navigation bar");

		try {
			boolean visible = homeIcon.isDisplayed();
			logger.info("Home icon visibility result: {}", visible);
			return visible;
		} catch (NoSuchElementException e) {
			logger.error("Home icon element not found");
			return false;
		}
	}

	public boolean isNavBarColorCorrect(String expectedColor) {
		logger.info("Checking navigation bar background color");

		String actualColor = navBar.getCssValue("background-color");
		logger.info("Actual nav bar color: {}", actualColor);

		return actualColor.equalsIgnoreCase(expectedColor);
	}

	public boolean isLoginHeadingVisible(String expectedHeading) {
		logger.info("Checking if Login heading '{}' is visible", expectedHeading);
		try {
			String actualHeading = loginCardHeading.getText().trim();
			logger.info("Actual heading found: {}", actualHeading);

			return actualHeading.equalsIgnoreCase(expectedHeading);
		} catch (NoSuchElementException e) {
			logger.error("Login card heading element not found");
			return false;
		}
	}

	public List<String> getLoginLabelNames() {
		logger.info("Fetching login page label names.");

		return labelList.stream().map(WebElement::getText).map(String::trim).toList();
	}

	public boolean isInputFieldVisible(String fieldName) {
		switch (fieldName.toLowerCase()) {
		case "username":
			return usernameField.isDisplayed();
		case "password":
			return passwordField.isDisplayed();
		default:
			logger.error("Unknown field: {}", fieldName);
			return false;
		}
	}

	public boolean isLoginButtonVisible() {
		return loginButton.isDisplayed();
	}

	public boolean isLoginButtonStyledCorrectly() {
		String bgColor = loginButton.getCssValue("background-color");
		String textColor = loginButton.getCssValue("color");

		return bgColor.equals("rgb(102, 51, 153)") && textColor.equals("rgb(255, 255, 255)");
	}

	public boolean areLabelsLeftAligned() {
		for (WebElement label : labelList) {
			String align = label.getCssValue("text-align");
			if (!align.equalsIgnoreCase("left")) {
				return false;
			}
		}
		return true;
	}

	public int getInputFieldCount() {
		return labelList.size();
	}

	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}

	public String getDisplayedErrorMessage(String inField) {

		logger.info("Fetching error message for: {}", inField);
		String errorMessage = null;

		switch (inField) {
		case "username field":
			errorMessage = usernameField.getAttribute("validationMessage");
			break;

		case "password field":
			errorMessage = passwordField.getAttribute("validationMessage");
			break;

		case "alert":
			errorMessage = error.getText();
			break;

		default:
			logger.warn("Unknown error field type: {}", inField);
		}

		logger.info("Error message retrieved: {}", errorMessage);
		return errorMessage;
	}

	public void login(String method, String scenarioType) {

		logger.info("Executing login with method: {} and scenario: {}", method, scenarioType);

		// Load test data from Excel
		TestContext.testData = ExcelReader.getTestData(scenarioType);

		enterUsername(TestContext.testData.get("username"));
		enterPassword(TestContext.testData.get("password"));

		switch (method.toLowerCase().trim()) {

		case "submits the login form":
		case "initiates login":
		case "submits the login form with mouse click":
			clickLoginButton();
			break;

		default:
			logger.error("Unknown submission method: {}", method);
			throw new IllegalArgumentException(
					"Supported methods: submits the login form, initiates login, submits the login form with mouse click");
		}
	}

	public void enterUsername(String username) {
		logger.info("Entering username.");
		WebElement field = WaitUtils.waitForVisibility(driver, usernameField, 10);
		field.clear();
		field.sendKeys(username);
	}

	public void enterPassword(String password) {
		logger.info("Entering password.");
		if (password != null && !password.isEmpty()) {
			passwordField.clear();
			passwordField.sendKeys(password);
		} else {
			logger.warn("Password provided is null or empty.");
		}
	}

	public void clickLoginButton() {
		logger.info("Clicking Login button.");
		JSUtils.clickElement(loginButton);
	}

	public void waitForDashBoardRedirect() {
		logger.info("Waiting for redirect to Dashboard page.");
		WaitUtils.waitForUrlContains(driver, "/dashboard", 10);
	}

}
