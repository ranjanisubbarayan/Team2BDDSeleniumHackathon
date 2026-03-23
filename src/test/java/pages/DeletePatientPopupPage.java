package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;
import utils.WaitUtils;

public class DeletePatientPopupPage {

	private final WebDriver driver;
    private final WaitUtils waitUtils;
    private static final Logger logger = LoggerFactory.getLogger(DeletePatientPopupPage.class);

    public DeletePatientPopupPage() {
        this.driver = DriverFactory.getDriver();
        this.waitUtils = new WaitUtils();
        PageFactory.initElements(driver, this);
        logger.info("DeletePatientPopup initialized successfully.");
    }
    
	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> patientRows;
    
	@FindBy(xpath = "//*[normalize-space()='My Patients']")
	private WebElement myPatientsHeader;

	@FindBy(xpath = "//*[normalize-space()='Confirm']")
	private WebElement DeletepopupTitle;
	
	@FindBy(xpath = "//*[normalize-space()='Are you sure to delete']")
	private WebElement DeletepopupAlerttext;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement YesButton;

	@FindBy(xpath = "//button[normalize-space()='No']")
	private WebElement NoButton;
	
	@FindBy(xpath = "//*[contains(text(),'deleted')]")
	private WebElement successMessages;
    
	public String getAlertTitle() {
		logger.info("Fetching delete popup title.");
		return WaitUtils.getVisibleText(driver, DeletepopupTitle, 10);
	}

	public String getAlertText() {
		logger.info("Fetching delete popup message text.");
		return WaitUtils.getVisibleText(driver, DeletepopupAlerttext, 10);
	}

	public boolean isYesButtonDisplayed() {
		logger.info("Checking Yes button visibility.");
		return WaitUtils.isVisible(driver, YesButton, 10);
	}

	public boolean isNoButtonDisplayed() {
		logger.info("Checking No button visibility.");
		return WaitUtils.isVisible(driver, NoButton, 10);
	}

	public void clickYes() {
		logger.info("Clicking Yes button on delete popup.");
		waitUtils.waitForClickable(YesButton).click();
	}

	public void clickNo() {
		logger.info("Clicking No button on delete popup.");
		waitUtils.waitForClickable(NoButton).click();
	}
	
	
	
}
