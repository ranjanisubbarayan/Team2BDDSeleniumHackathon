package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
    
    @FindBy(xpath = "//table")
	private WebElement patientTable;
    
	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> patientRows;
    
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
    
	@FindBy(xpath = "(//table//tr[1]//*[contains(@class,'delete') or contains(text(),'Delete')])")
	private WebElement firstRowDeleteIcon;
	
	@FindBy(xpath = "//*[@role='dialog']//*[text()='X' or text()='x']")
	private WebElement popupCloseIcon;
	
	public String getAlertTitle() {
		logger.info("Fetching delete popup title");
		return WaitUtils.getVisibleText(driver, DeletepopupTitle, 10);
	}

	public String getAlertText() {
		logger.info("Fetching delete popup message text");
		return WaitUtils.getVisibleText(driver, DeletepopupAlerttext, 10);
	}

	public boolean isYesButtonDisplayed() {
		logger.info("Checking Yes button visibility");
		return WaitUtils.isVisible(driver, YesButton, 10);
	}

	public boolean isNoButtonDisplayed() {
		logger.info("Checking No button visibility");
		return WaitUtils.isVisible(driver, NoButton, 10);
	}

	public void clickYes() {
		logger.info("Clicking Yes button on delete popup.");
		waitUtils.waitForClickable(YesButton).click();
	}

	public void clickNo() {
		logger.info("Clicking No button on delete popu");
		waitUtils.waitForClickable(NoButton).click();
	}
	
	public boolean isPatientTableDisplayed() {
		return WaitUtils.isVisible(driver, patientTable, 10);
	}
	
	public int getPatientRowCount() {
		logger.info("Fetching patient row count");
		return patientRows.size();
	}
	
	public String getFirstPatientName() {
		try {
			WebElement patientName = driver.findElement(
				By.xpath("(//table//tbody//tr[1]//td[2])[1] | (//table//tbody//tr[1]//*[contains(text(),' ')])[1]"));
			String name = patientName.getText().trim();
			logger.info("Captured first patient name {}", name);
			return name;
		} catch (Exception e) {
			logger.warn("Could not capture first patient name");
			return "";
		}
	}
	
	public void clickDeleteIconForfirstRowPatient() {
		logger.info("Clicking delete icon for first patient row");
		waitUtils.waitForClickable(firstRowDeleteIcon).click();
	}
	
	public WebElement getDeleteIconByPatientName(String patientName) {
	    for (WebElement row : patientRows) {
	        if (row.getText().contains(patientName)) {
	            return row.findElement(By.xpath( ".//*[contains(@class,'delete') or contains(@title,'Delete') or contains(text(),'Delete')]"
	            ));
	        }
	    }
	    throw new RuntimeException("Patient not found: " + patientName);
	}
	public void clickPopupCloseIcon() {
		logger.info("Clicking popup close icon");
		waitUtils.waitForClickable(popupCloseIcon).click();
	}
	
	public void acceptAlertIfBrowserAlertPresent() {
		try {
			driver.switchTo().alert().accept();
				} catch (NoAlertPresentException e) {
					clickYes();
		}
	}

	public void dismissAlertIfBrowserAlertPresent() {
		try {
			driver.switchTo().alert().dismiss();
			} catch (NoAlertPresentException e) {
				clickNo();
		}
	}
	
	public boolean isSuccessMessageDisplayed() {
		logger.info("Checking success message visibility.");
		return WaitUtils.isVisible(driver, successMessages, 10);
	}
	public boolean isPopupClosed() {
		try {
			return !DeletepopupTitle.isDisplayed();
		} catch (Exception e) {
			return true;
		}
	}
	public boolean isPatientStillPresentInTable(String patientName) {
			List<WebElement> name = driver.findElements(By.xpath("//table//tr//td[contains(text(),'" + patientName + "')]"));
		return !name.isEmpty();
	}

	public boolean isPatientRemovedFromTable(String patientName) {
		return !isPatientStillPresentInTable(patientName);
	}
}
