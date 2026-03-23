package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;


public class MyPatientsPage {

	private WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(MyPatientsPage.class);

	public MyPatientsPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath=("//button[contains(text(),'My Patients')]"))
			private WebElement myPatientsButton;
	@FindBy(xpath=("//h1[contains(text(),'My Patients')]"))
            private WebElement pageHeader;
	 @FindBy(xpath = "//input[@placeholder='Search']")
	        private WebElement searchBar;
	 @FindBy(xpath = "//i[contains(@class,'search')]")
	        private WebElement searchIcon;
	 @FindBy(xpath = "//input[@placeholder='Search...']")
            private WebElement searchPlaceHolder;
	@FindBy(xpath="//th[normalize-space()='Patient Id']//i[contains(@class,'up')]")
			private WebElement upArrowPatientId;
	@FindBy(xpath="//th[normalize-space()='Patient Id']//i[contains(@class,'down')]")
	        private WebElement downArrowPatientId;
	@FindBy(xpath="//th[normalize-space()='Name']//i[contains(@class,'up')]")
	        private WebElement upArrowName;
	@FindBy(xpath="//th[normalize-space()='Name']//i[contains(@class,'down')]")
	        private WebElement downArrowName;
	

	public void clickMyPatientsButton()
	{
		logger.info("Clicking My patients button on Dashboard page");
		myPatientsButton.click();
	}
	public String getPageHeader()
	{
		logger.info("Returning MyPatients Title ");
		return pageHeader.getText();
	}
	 public boolean isSearchBarDisplayed() {
	        return searchBar.isDisplayed();
	    }
	 public boolean isSearchIconDisplayed() {
	        return searchIcon.isDisplayed();
	    }
	 public boolean isPlaceholderDisplayed(String expectedText) {
	        String actualText = searchPlaceHolder.getAttribute("placeholder");
	        return actualText.equals(expectedText);
	 }
	 //@FindBy can't able to use for dynamic value
	 public WebElement getHeaderElement(String header) {
	        return driver.findElement(By.xpath("//th[normalize-space()='" + header + "']"));
	    }

	    public boolean isHeaderDisplayed(String header) {
	        return getHeaderElement(header).isDisplayed();
	    }

	    public boolean isUpArrowPatientIdDisplayed() {
	        return upArrowPatientId.isDisplayed();
	    }
	    public boolean isDownArrowPatientIdDisplayed() {
	        return downArrowPatientId.isDisplayed();
	    }

	    public boolean isUpArrowNameDisplayed() {
	        return upArrowName.isDisplayed();
	    }
	    public boolean isDownArrowNameDisplayed() {
	        return downArrowName.isDisplayed();
	    }
	    public boolean doesColumnHaveValues(String column) {

	        // Find the column index based on header text
	        String columnIndexXpath = "//th[normalize-space()='" + column + "']/preceding-sibling::th";
	        int index = driver.findElements(By.xpath(columnIndexXpath)).size() + 1;

	        // Now get all cells in that column
	        List<WebElement> columnCells = driver.findElements(
	            By.xpath("//table//tbody//tr/td[" + index + "]")
	        );

	        // Check each cell has a value
	        for (WebElement cell : columnCells) {
	            if (cell.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean isPatientIdDisplayedForAllRows() {

	        List<WebElement> patientIds = driver.findElements(By.xpath("//tbody//tr/td[1]"));

	        for (WebElement patientId : patientIds) {
	            if (patientId.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean isPatientNameDisplayedForAllRows() {

	        List<WebElement> patientNames = driver.findElements(By.xpath("//tbody//tr/td[2]"));

	        for (WebElement patientName : patientNames) {
	            if (patientName.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean doesDetailsColumnContainField(String fieldName) {

	        List<WebElement> detailsCells = driver.findElements(By.xpath("//tbody//tr/td[3]"));

	        for (WebElement cell : detailsCells) {

	            String text = cell.getText().trim().toLowerCase();

	            boolean match = false;

	            switch (fieldName.toLowerCase()) {

	                case "phone number":
	                    // Phone number = 10 digits
	                    match = text.matches(".*\\d{10}.*");
	                    break;

	                case "email":
	                    // Email contains @ and .
	                    match = text.contains("@") && text.contains(".");
	                    break;

	                case "date of birth":
	                    // DOB format like 31-07-1985
	                    match = text.matches(".*\\d{2}-\\d{2}-\\d{4}.*");
	                    break;

	                default:
	                    return false;
	            }

	            if (!match) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public boolean areAllEditIconsDisplayed() {
	        List<WebElement> editIcons = driver.findElements(By.xpath("//table//tbody//tr//button[contains(text(),'Edit')]"));


	        if (editIcons.isEmpty()) {
	            return false; 
	        }

	        for (WebElement editIcon : editIcons) {
	            if (!editIcon.isDisplayed()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean areAllDeleteIconsDisplayed() {
	        List<WebElement> deleteIcons = driver.findElements(By.xpath("//table//tbody//tr//button[contains(text(),'Delete')]"));


	        if (deleteIcons.isEmpty()) {
	            return false; 
	        }

	        for (WebElement deleteIcon : deleteIcons) {
	            if (!deleteIcon.isDisplayed()) {
	                return false;
	            }
	        }
	        return true;
	    }
}

	    

	    
	

