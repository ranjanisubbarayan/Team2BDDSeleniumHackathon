package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;
import utils.WaitUtils;


public class MyPatientsPage {

	private WebDriver driver;
	 private final WaitUtils waitUtils;
	private static final Logger logger = LoggerFactory.getLogger(MyPatientsPage.class);

	public MyPatientsPage() {
		this.driver = DriverFactory.getDriver();
		 this.waitUtils = new WaitUtils();
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
	@FindBy(xpath = "//tbody//tr/td[4]")
	        private List<WebElement> lastVisitDateCells;
	@FindBy(xpath= "//tbody//tr/td[3]")
	        private List<WebElement> details; 
	@FindBy(xpath= "//tbody//tr/td[1]")
	        private List<WebElement> patientIds; 
	@FindBy(xpath= "//tbody//tr/td[2]")
	        private List<WebElement> patientNames; 
	@FindBy(xpath= "//tbody//tr/td[5]")
	        private List<WebElement> actionsColumn;
	@FindBy(xpath="//table//tbody//tr//button[contains(text(),'Edit')]")
	        private List<WebElement> editIcons;
	@FindBy(xpath="//table//tbody//tr//button[contains(text(),'Delete')]")
            private List<WebElement> deleteIcons;
	@FindBy(xpath="//button[contains(text(),'View Previous Test Reports')]")
	        private WebElement ViewPreviousTestReportsButton;
	@FindBy(xpath = "//h2[contains(text(), 'View Patient Test Reports')]")
            private WebElement reportPageHeader;
	 @FindBy(xpath = "//table//tbody//tr")
	        private List<WebElement> tableRows;
	 @FindBy(xpath = "//a[@aria-label='Previous']")
	    private WebElement previousPageArrow;
	 @FindBy(xpath = "//a[@aria-label='First']")
	    private WebElement firstPageArrow;
	 @FindBy(xpath = "//a[@aria-label='Last']")
	    private WebElement lastPageArrow;
     @FindBy(xpath = "//a[@aria-label='Next']")
            private WebElement nextPageArrow;
     @FindBy(xpath = "//div[contains(@class,'pagination-info')]")
     private WebElement paginationInfo;


	public void clickMyPatientsButton()
	{
		logger.info("Clicking My patients button on Dashboard page");
		waitUtils.waitForClickable(myPatientsButton).click();
	}
	public String getPageHeader()
	{
		logger.info("Returning MyPatients Title ");
		return WaitUtils.waitForVisibility(driver, pageHeader, 5).getText().trim();
	}
	 public boolean isSearchBarDisplayed() {
		 logger.info("Checking Search bar display status");
		 return WaitUtils.isVisible(driver, searchBar, 5);
	    }
	 public boolean isSearchIconDisplayed() {
		 logger.info("Checking Search Icon display status");
		 return WaitUtils.isVisible(driver, searchIcon, 5);
	    }
	 public boolean isPlaceholderDisplayed(String expectedText) {
	        String actualText = searchPlaceHolder.getAttribute("placeholder");
	        logger.info("Checking Search placeholder display status");
	        return actualText.equals(expectedText);
	 }
	 //@FindBy can't able to use for dynamic xpath variable
	 public WebElement getHeaderElement(String header) {
		  logger.info("Getting header elements");
	        return driver.findElement(By.xpath("//th[normalize-space()='" + header + "']"));
	    }

	    public boolean isHeaderDisplayed(String header) {
	    	logger.info("Checking header element display status" );
	    	return getHeaderElement(header).isDisplayed();
	    }

	    public boolean isUpArrowPatientIdDisplayed() {
	    	 logger.info("Checking Up arrow patient Id display status");
	    	return WaitUtils.isVisible(driver, upArrowPatientId, 5);
	    }
	    public boolean isDownArrowPatientIdDisplayed() {
	    	 logger.info("Checking Down arrow patient Id display status");
	    	return WaitUtils.isVisible(driver, downArrowPatientId, 5);
	    }

	    public boolean isUpArrowNameDisplayed() {
	    	 logger.info("Checking Up arrow patient name display status");
	    	return WaitUtils.isVisible(driver, upArrowName, 5);
	    }
	    public boolean isDownArrowNameDisplayed() {
	    	 logger.info("Checking Down arrow patient name display status");
	    	return WaitUtils.isVisible(driver, downArrowName, 5);
	    }
	    public boolean doesColumnHaveValues(String column) {

	        logger.info("Checking the column index based on header text");
	        String columnIndexXpath = "//th[normalize-space()='" + column + "']/preceding-sibling::th";
	        int index = driver.findElements(By.xpath(columnIndexXpath)).size() + 1;

	       logger.info("Getting all cells in that column");
	        List<WebElement> columnCells = driver.findElements(
	            By.xpath("//table//tbody//tr/td[" + index + "]")
	        );

	       logger.info("Checking each cell has a value");
	        for (WebElement cell : columnCells) {
	            if (cell.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean isPatientIdDisplayedForAllRows() {
	    	logger.info("Checking Patient Id displayed for all rows");
            for (WebElement patientId : patientIds) {
	            if (patientId.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean isPatientNameDisplayedForAllRows() {
	    	logger.info("Checking Patient name displayed for all rows");
	        for (WebElement patientName : patientNames) {
	            if (patientName.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean doesDetailsColumnContainField(String fieldName) {
            logger.info("Checking the Details column have field");
	        for (WebElement cell : details) {

	            String text = cell.getText().trim().toLowerCase();

	            boolean match = false;

	            switch (fieldName.toLowerCase()) {

	                case "phone number":
	                   
	                    match = text.matches(".*\\d{10}.*");
	                    break;

	                case "email":
	                    
	                    match = text.contains("@") && text.contains(".");
	                    break;

	                case "date of birth":
	                   
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
	    
	    public boolean isEmailValidForAllPatients() {
	    	 logger.info("Checking email validation for all patient records");

	        for (WebElement cell : details) {

	            String text = cell.getText().trim();
               String[] lines = text.split("\\n");

	            if (lines.length < 2) {
	                return false; 
	            }

	            String email = lines[1].trim(); 
              
	            if (!email.contains("@") || !email.contains(".") || email.contains(" ")) {
	                return false;
	            }

	           if (email.indexOf("@") > email.lastIndexOf(".")) 
	            	return false;
	        }

	        return true;
	    }
	    
	    
	    public boolean isPhoneNumberValidForAllPatients() {
	    	logger.info("Checking Phone Number validation for all patient records");
	        for (WebElement cell : details) {

	            String text = cell.getText().trim();

	            String[] lines = text.split("\\n");

	            if (lines.length < 1) {
	                return false; 
	            }

	            String phone = lines[0].trim(); 
	            if (!phone.matches("\\d{10}")) {
	                return false;
	            }
	        }

	        return true;
	    }

	    
	    
	    public boolean isDOBFormatValid() {
	    	
          logger.info("Checking DOB Format is valid");
	       String dobFormat = "\\d{2}-\\d{2}-\\d{4}";

	        for (WebElement cell : details) {
	            if (!cell.getText().matches("(?s).*" + dobFormat + ".*")) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public boolean isLastVisitDateDisplayedForAllRows() {
           logger.info("Checking last visit date displayed for all rows");
	        for (WebElement lastDate : lastVisitDateCells) {
	            if (lastDate.getText().trim().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    } 
	    
	    
	    public boolean isLastVisitDateFormatValid() {
	    	 logger.info("Checking last visit date format is valid");

	       String lastVisitDateFormat = "\\d{2}-\\d{2}-\\d{4}";

	        for (WebElement cell : lastVisitDateCells) {
	            if (!cell.getText().matches("(?s).*" + lastVisitDateFormat + ".*")) {
	                return false;
	            }
	        }
	        return true;
	    } 
	    
	    
	    public boolean areActionButtonsDisplayed() {
           logger.info("Checking Action button display status");
	        for (WebElement cell : actionsColumn) {

	            String text = cell.getText();

	            boolean hasViewPreviousReports = text.contains("View Previous Test Reports");
	            boolean hasViewDietPlans = text.contains("View Previous Diet Plans");
	            boolean hasCreateNewReport = text.contains("Create New Report/Plan");

	            if (!hasViewPreviousReports || !hasViewDietPlans || !hasCreateNewReport) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	
	    public boolean isDetailsInSeparateLines() {
	    	logger.info("Checking Details are in Separate lines");
	        for (WebElement cell : details) {

	           String[] lines = cell.getText().split("\\n");

	            if (lines.length != 3) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    
	    public boolean areAllEditIconsDisplayed() {
	    	logger.info("Checking Edit Icons displayed for all rows");
	    	for (WebElement editIcon : editIcons) {
	            if (!editIcon.isDisplayed()) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public boolean areAllDeleteIconsDisplayed() {
	    	logger.info("Checking Delete Icons displayed for all rows");
	        for (WebElement deleteIcon : deleteIcons) {
	            if (!deleteIcon.isDisplayed()) {
	                return false;
	            }
	        }
	        return true;
	    }

	  public void clickUpArrowPatientId()
	  {
		  logger.info("Clicking Up arrow Patient Id on My Patients page");
		  waitUtils.waitForClickable(upArrowPatientId).click();
	  }
	    
	    
	  public List<Integer> getPatientIds() {
		 logger.info("Getting all Patient Ids from My Patients page");
	        List<Integer> ids = new ArrayList<>();

	        for (WebElement cell : patientIds) {
	            String text = cell.getText().trim();
	            int id = Integer.parseInt(text);
	            ids.add(id); 
	        }

	        return ids;
	    }

	   public boolean isSortedAscendingId(List<Integer> ids) {
		   logger.info("Checking if Patients Ids are sorted in ascending order");
	        List<Integer> sorted = new ArrayList<>(ids);
	        Collections.sort(sorted);
	        return sorted.equals(ids);
	    }
	
  
   public void clickDownArrowPatientId()
   {
	   logger.info("Clicking Down arrow Patient Id on My Patients page");
	  waitUtils.waitForClickable(downArrowPatientId).click();
   } 
   
  

  public boolean isSortedDescendingId(List<Integer> ids) {
	  logger.info("Checking if Patients Ids are sorted in descending order");
    List<Integer> sorted = new ArrayList<>(ids);
    sorted.sort(Collections.reverseOrder());
    return sorted.equals(ids);
   }    
	    
	    
	  public void clickUpArrowPatientName()
     {
    	 logger.info("Clicking Up arrow Patient Name on My Patients page");
	  waitUtils.waitForClickable(upArrowName).click();
     } 
    
    public List<String> getPatientNames() {
    	 logger.info("Getting all Patient names from My Patients page");
        List<String> names = new ArrayList<>();

        for (WebElement cell : patientNames) {
            String text = cell.getText().trim();
            names.add(text);
            }

        return names;
      }

      public boolean isSortedAscendingName(List<String> names) {
    	logger.info("Checking if Patients names are sorted in ascending order");
        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
        return sorted.equals(names);
       }    
    
    
    public void clickDownArrowPatientName()
    {
     logger.info("Clicking Down arrow Patient Name on My Patients page");
	  waitUtils.waitForClickable(downArrowName).click();
    } 
    
   
      public boolean isSortedDescendingName(List<String> names) {
    	 logger.info("Checking if Patients names are sorted in descending order");
        List<String> sorted = new ArrayList<>(names);
        sorted.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return sorted.equals(names);
       }  
      
      public void clickViewPreviousTestReports()
      {
    	  logger.info("Clicking View Previous Test reports");
    	  waitUtils.waitForClickable(ViewPreviousTestReportsButton).click();
      }
      public String getReportPageHeader()
  	{
  		logger.info("Returning View Patient Test Reports Title ");
  		return WaitUtils.waitForVisibility(driver, reportPageHeader, 5).getText().trim();
  	}
      public void enterSearchText(String text) {
    	  logger.info("Entering text in the Search bar");
    	    searchBar.clear();
    	    searchBar.sendKeys(text);
    	}

    	public void clearSearchText() {
    		logger.info("Clearing search text in the Search bar");
    		searchBar.clear();
    	}

    	public int getDisplayedRowCount() {
    		logger.info("Getting Row Count from My patients page");
    	    return tableRows.size();
    	}
    	public void searchByPatientName(String name) {
    		logger.info("Searching for patient with name");
    	    searchBar.clear();
    	    searchBar.sendKeys(name);
    	    searchBar.click();
    	}
    	
    	 // Get displayed patient names after search
        public List<String> getDisplayedPatientNames()
        {
            List<String> names = new ArrayList<>();
            for (WebElement name : patientNames) {
                names.add(name.getText().trim());
            }
            return names;
        }

        // Get displayed patient IDs after search
        public List<String> getDisplayedPatientIds()
        {
            List<String> ids = new ArrayList<>();
            for (WebElement id : patientIds) {
                ids.add(id.getText().trim());
            }
            return ids;
        }

    	
    	   public void searchByPatientId(String id)
    	   {
    		logger.info("Searching for patient with Id");
    	    searchBar.clear();
    	    searchBar.sendKeys(id);
    	    searchBar.click();
    	}
    	   
    	   public boolean isMatchingPatientDetailsDisplayed(String searchText)
    	   {
    		   logger.info("Checking Matching Patient details displayed");
    		    String lower = searchText.toLowerCase();
                    for (WebElement row : tableRows) 
                    {
                String rowText = row.getText().toLowerCase();

    		        if (!rowText.contains(lower)) {
    		            return false;
    		        }
    		    }

    		    return true;
    		}

    	
    	public void clickNextPage()
    	{
    		logger.info("Clicking Next page Arrow on My Patients page");
    		waitUtils.waitForClickable(nextPageArrow).click();
    	}
    	
    	public void clickPreviousPage()
    	{
    		logger.info("Clicking Previous page Arrow on My Patients page");
    		waitUtils.waitForClickable(previousPageArrow).click();
    	}
    	
    	 public void clickFirstPage() {
    		 logger.info("Clicking First page Arrow on My Patients page");
    		 waitUtils.waitForClickable(firstPageArrow).click(); 
    	    }

    	 public void clickLastPage() {
    		 logger.info("Clicking Last page Arrow on My Patients page");
    		 waitUtils.waitForClickable(lastPageArrow).click(); 
    	    }
    	 public boolean isPreviousArrowDisabled() {
    		 boolean disabled = !previousPageArrow.isEnabled();
             logger.info("Previous Arrow Disabled: {}", disabled);
    			return disabled;
    	 }
    	
    	 public boolean isFirstPageArrowDisabled() {
    		 boolean disabled = !firstPageArrow.isEnabled();
             logger.info("First Page Arrow Disabled: {}", disabled);
    			return disabled;
    	 }
    	 
    	 public boolean isNextPageArrowEnabled() {
    		 boolean enabled = nextPageArrow.isEnabled();
             logger.info("Next page arrow enabled: {}", enabled);
    			return enabled;
    	 }
    	 
    	 
    	 public boolean isLastPageArrowEnabled() {
    		 boolean enabled = lastPageArrow.isEnabled();
             logger.info("Next page arrow enabled: {}", enabled);
    			return enabled;
    	 }
    	 
    	 public boolean isPreviousArrowEnabled() {
    		 boolean enabled = previousPageArrow.isEnabled();
             logger.info("Previous Arrow Disabled: {}", enabled);
    			return enabled;
    	 }
    	 
    	 public boolean isFirstPageArrowEnabled() {
    		 boolean enabled = firstPageArrow.isEnabled();
             logger.info("First page arrow enabled: {}", enabled);
    			return enabled;
    	 }
    	 
    	 public boolean isNextPageArrowDisabled() {
    		 boolean disabled = !nextPageArrow.isEnabled();
             logger.info("Next Page Arrow Disabled: {}", disabled);
    			return disabled;
    	 }
    	 
    	 public boolean isLastPageArrowDisabled() {
    		 boolean disabled = !lastPageArrow.isEnabled();
             logger.info("Last Page Arrow Disabled: {}", disabled);
    			return disabled;
    	 }
    	 
    	 public String getPaginationInfoText() {
    	        String text = paginationInfo.getText().trim();
    	        logger.info("Pagination info displayed: {}", text);
    	        return text;
    	    }
    	 
    	 public boolean isNoDataPresent() {
    		 logger.info("Checking No Patients records display");
    	        return tableRows.size() == 0;
    	    }

    	 public boolean arePaginationControlsDisplayed() {
    		 logger.info("Checking Pagination control displayed");
    		    return firstPageArrow.isDisplayed()
    		            && previousPageArrow.isDisplayed()
    		            && nextPageArrow.isDisplayed()
    		            && lastPageArrow.isDisplayed();
    		}

    	 public int getStartCount() {
    	        String text = getPaginationInfoText();
    	        return Integer.parseInt(text.split(" ")[1]);
    	    }

    	    public int getEndCount() {
    	        String text = getPaginationInfoText();
    	        return Integer.parseInt(text.split(" ")[3]);
    	    }

    	    public int getTotalCount() {
    	        String text = getPaginationInfoText();
    	        return Integer.parseInt(text.split(" ")[5]);
    	    }

    	   


    	
    	 
    	 
}  
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	  


	    

	    
	

