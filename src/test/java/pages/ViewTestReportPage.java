package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class ViewTestReportPage {

	private static final Logger logger = LoggerFactory.getLogger(ViewTestReportPage.class);
	private WebDriver driver;

	@FindBy(xpath = "//h2[text()='View Patient Test Reports']")
	private WebElement pageTitle;

	@FindBy(id = "reportsTable")
	private WebElement reportsTable;

	@FindBy(xpath = "//table[@id='reportsTable']//th")
	private List<WebElement> tableHeaders;

	@FindBy(xpath = "//table[@id='reportsTable']//tbody/tr")
	private List<WebElement> reportRows;

	@FindBy(xpath = "//button[contains(text(),'View PDF')]")
	private List<WebElement> viewPdfButtons;

	@FindBy(xpath = "//span[contains(@class,'pagination-text')]")
	private WebElement paginationText;

	@FindBy(xpath = "//button[contains(text(),'First')]")
	private WebElement firstButton;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousButton;

	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextButton;

	@FindBy(xpath = "//button[contains(text(),'Last')]")
	private WebElement lastButton;

	@FindBy(xpath = "//span[contains(@class,'close-icon')]")
	private WebElement closeIcon;

	public ViewTestReportPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		logger.info("LoginPage initialized successfully");
	}

	public String getPageTitle() {
		return pageTitle.getText().trim();
	}

	public boolean isReportsTableDisplayed() {
		return reportsTable.isDisplayed();
	}

	public List<String> getTableHeaders() {
		List<String> headers = new ArrayList<>();
		for (WebElement header : tableHeaders) {
			headers.add(header.getText().trim());
		}
		return headers;
	}

	public List<WebElement> getReportRows() {
		return reportRows;
	}

	public List<String> getVitalsForRow(int rowIndex) {
		String vitalsText = reportRows.get(rowIndex).findElement(By.xpath("./td[5]")).getText();
		return List.of(vitalsText.split("\n"));
	}

	public String getHealthConditionsForRow(int rowIndex) {
		return reportRows.get(rowIndex).findElement(By.xpath("./td[6]")).getText();
	}

	public boolean isVitalsMultiline(int rowIndex) {
		return getVitalsForRow(rowIndex).size() > 1;
	}

	public boolean isHealthConditionsMultiline(int rowIndex) {
		return getHealthConditionsForRow(rowIndex).contains("\n");
	}

	public String getPaginationText() {
		return paginationText.getText().trim();
	}

	public boolean isButtonEnabled(String name) {
		return getButton(name).isEnabled();
	}

	public int getRecordCount() {
		return reportRows.size();
	}

	public void clickViewPdfForRecord(int index) {
		viewPdfButtons.get(index).click();
	}

	public void clickNextPage() {
		nextButton.click();
	}

	public void clickPreviousPage() {
		previousButton.click();
	}

	public void clickFirstPage() {
		firstButton.click();
	}

	public void clickLastPage() {
		lastButton.click();
	}

	private WebElement getButton(String name) {
		switch (name.toLowerCase()) {
		case "first":
			return firstButton;
		case "previous":
			return previousButton;
		case "next":
			return nextButton;
		case "last":
			return lastButton;
		default:
			throw new IllegalArgumentException("Invalid button: " + name);
		}
	}

	public List<String> getPaginationControls() {
		return List.of(firstButton.getText().trim(), previousButton.getText().trim(), nextButton.getText().trim(),
				lastButton.getText().trim());
	}

	public boolean arePaginationControlsVisible() {
		return firstButton.isDisplayed() && previousButton.isDisplayed() && nextButton.isDisplayed()
				&& lastButton.isDisplayed();
	}

	public boolean isPdfOpened() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl.toLowerCase().contains(".pdf");
	}

	public boolean isCloseIconDisplayed() {
		try {
			return closeIcon.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
