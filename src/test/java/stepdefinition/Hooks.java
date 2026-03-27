package stepdefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.PageObjectManager;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.ScreenShot;

public class Hooks {

	private WebDriver driver;
	private PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Before(order = 0)
	public void setup() {
		logger.info("Initializing test setup...");

		Properties prop = ConfigReader.initializeProperties();
		logger.debug("Loaded configuration properties");
		
		ExcelReader.readDataFromExcel(prop.getProperty("loginsheetName"));
		ExcelReader.readDataFromExcel(prop.getProperty("addPatientData"));
		logger.info("Excel test data loaded");

		String browser = System.getProperty("browserName", prop.getProperty("browserName"));
		logger.info("Launching browser: {}", browser);

		DriverFactory.launchBrowser(browser);
		DriverFactory.getDriver().get(prop.getProperty("baseURL"));
		logger.info("Navigated to base URL: {}", prop.getProperty("baseURL"));

		pom = new PageObjectManager();
		logger.info("PageObjectManager initialized");
	}
	
	@Before(value = "@Login", order = 1)
	public void performLogin() throws IOException {
		pom.getDashboardPage().clickLoginButton();
		logger.info("Clicked  Login button");

		pom.getLoginPage().login("Submits the login form", "valid_login");
		logger.info("Performed login with valid credentials");
	}
	
	@Before(value = "@MyPatient", order =2)
	public void mypatientpage() {
		
		if (pom.getDeletePatientPopupPage().isPatientTableDisplayed()) {
	        logger.info("User already on My Patients page");
	        return;
	    }else {
	    	 pom.getDashboardPage().clickNavigationLink("My Patients");
	    	 logger.info("Successfully navigated to My Patients page");
	    }
	}
	

	@AfterStep
	public void screenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			logger.warn("Scenario '{}' failed. Capturing screenshot...", scenario.getName());
			byte[] screenshot = ScreenShot.takeScreenshotAsBytes(DriverFactory.getDriver(), scenario.getName());
			scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
		}
	}

	@After
	public void tearDown() {
		if (DriverFactory.getDriver() != null) {
			logger.info("Tearing down WebDriver and closing browser");
			DriverFactory.getDriver().quit();
			DriverFactory.mydriver.remove();
			logger.info("Driver removed from ThreadLocal");
		}
	}
}