package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class AddPatientPage {

	
	private WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(AddPatientPage.class);

	public AddPatientPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		logger.info("AddPatientPage initialized successfully.");
	}
	
	@FindBy (xpath = "//*[text()='Add Patient Details']")
	     private WebElement formHeading;
	
	@FindBy (id =("firstName"))
	private WebElement firstName;
	
	@FindBy (id =("lasttName"))
	private WebElement lastName;
	
	@FindBy (id =("email"))
	private WebElement email;
	
	@FindBy (id =("contactno"))
	private WebElement contactNo;
	
	@FindBy (id =("dateOfBirth"))
	private WebElement DOB;
	
	@FindBy (id =("Weight"))
	private WebElement weight;
	
	@FindBy (id =("Height"))
	private WebElement height;
	
	@FindBy (id =("Temperature"))
	private WebElement temp;
	
	@FindBy (id =("SP"))
	private WebElement sp;
	
	@FindBy (id =("DP"))
	private WebElement dp;	
	
	@FindBy(id = "allergies")
	private WebElement allergiesDropdown;

	@FindBy(id = "foodPreference")
	private WebElement foodDropdown;

	@FindBy(id = "cuisine")
	private WebElement cuisineDropdown;
	
	@FindBy (xpath =("//select"))
	private List<WebElement> dropDownCount ;
	
	@FindBy (xpath =("//select[@id='cuisine']/option"))
	private List<WebElement> cuisineOptions ;
	
	@FindBy (xpath =("//select[@id='foodPreference']/option"))
	private List<WebElement> foodOptions ;
	
	@FindBy (xpath =("//select[@id='allergies']/option"))
	private List<WebElement> allergiesOptions ;
	
	@FindBy (xpath = ("//input[not(@type='file') and not(@type='date')]"))
	private List<WebElement> inputFields;
	
	@FindBy (xpath = ("//label[contains(text(),'*')]"))
	private List<WebElement> mandatoryFields;
	
	@FindBy (xpath = ("//input[@type = 'file']"))
	private List<WebElement> uploadFile;
	
	@FindBy (xpath = ("//input[@type = 'file']"))
	private WebElement fileUpload;
	
	@FindBy (xpath = ("//button[text() = 'Submit']"))
	private WebElement submit;
	
	@FindBy (xpath = ("//button[text() = 'Close']"))
	private WebElement close;
	
	
	
	public String getformHeading() { 
		return formHeading.getText();
		}
	
	public int getDropDownCount(){
		return dropDownCount.size();
	}

	public int getinputFieldsCount(){
		return inputFields.size();
	}
	
	public int getuploadFile(){
		return uploadFile.size();
		}
	
	public void clickSubmitButton() {
		submit.click();
	}
	
	public void clickCloseButton() {
		close.click();
	}
	
	public boolean isfileUploadVisible() {
		return fileUpload.isDisplayed();
	}
	
	public boolean isButtonVisible(String btnName) {
		return driver.findElement(By.xpath("//button[text()='" + btnName + "']")).isDisplayed();
	}
	
	public boolean isButtonEnabled(String btnName) {
		return driver.findElement(By.xpath("//button[text()='" + btnName + "']")).isEnabled();
	}
	
	public boolean isDatePickerVisible() {
		return DOB.isDisplayed();
	}
	
	public void selectDatePicker() {
	DOB.click();
	}
	public void validateDateFormat(String year,String month,String date) {
	
	while(true) {
		String currentMonth = driver.findElement(By.xpath("//span[@class='datepicker-month']")).getText();
		String currentYear = driver.findElement(By.xpath("//span[@class='datepicker-year']")).getText();
			
	if(currentMonth.equals(month) && currentYear.equals(year))
	{
		break;
	}
	driver.findElement(By.xpath("//span[@class='circle-trianle-next']")).click();
	//driver.findElement(By.xpath("//span[@class='circle-trianle-past']")).click();
	}
	List<WebElement> allDates=driver.findElements
			(By.xpath("//table[@class='datepicker-calender']//tbody//td//a"));
	for (WebElement dates:allDates){
		if(dates.getText().equals(date)){
			dates.click();
			break;
		}
		}
}
	public String getSelectedDate() {
	    return DOB.getAttribute("value");
	}

	public boolean isMandatoryFieldsVisible(String fieldName) {
		for (WebElement label : mandatoryFields) {
			if (label.getText().contains(fieldName)) {
				return label.isDisplayed();
			}}
				return false;
			}
	
	public boolean isOptionalFieldsVisible(String fieldName) {
		switch(fieldName) {
		case "Weight": return weight.isDisplayed();
		case "Height": return height.isDisplayed();
		case "Temperature": return temp.isDisplayed();
		case "SP": return sp.isDisplayed();
		case "DP": return dp.isDisplayed();
		default:
           System.out.println("Unknown optional field: " + fieldName);			
		return false;
		}
	}
		public String getErrorMessage(String fieldName) {
		    switch (fieldName) {
		        case "First Name":
		            return "First Name is required";
		        case "Last Name":
		            return "Last Name is required";
		        case "Email":
		            return "Email is required";
		        case "Contact Number":
		            return "Contact Number is required";
		        case "Date of Birth":
		            return "Date of Birth is required";
		        default:
		            return "Field is required"; 
		    }
		
	}
		
		public void fillForm(Map<String, String> testData) {

		    // Helper to enter text if value exists
		    enterText(firstName, testData.get("first_name"));
		    enterText(lastName,  testData.get("last_name"));
		    enterText(email,      testData.get("email"));
		    enterText(contactNo,  testData.get("contact"));
		    enterText(DOB,        testData.get("dob"));
		    enterText(weight,     testData.get("weight"));
		    enterText(height,     testData.get("height"));
		    enterText(temp,       testData.get("temp"));
		    enterText(sp,         testData.get("sp"));
		    enterText(dp,         testData.get("dp"));
		    selectDropdown(allergiesOptions, testData.get("allergy"));
		    selectDropdown(foodOptions,      testData.get("food_preference"));
		    selectDropdown(cuisineOptions,   testData.get("cuisine"));
		}
		private void enterText(WebElement element, String value) {
		    if (value != null && !value.isEmpty()) {
		        element.clear();
		        element.sendKeys(value);
		    }
		}

	public void selectDropdown(List<WebElement> options, String value) {
		    if (value != null && !value.isEmpty()) {
		        for (WebElement opt : options) {
		            if (opt.getText().equalsIgnoreCase(value)) {
		                opt.click();
		                break; // Stop after first match
		            }
		        }
		    }
		}
		
	public String getErrorMessageFromUI(String expectedMessage) {
	    // Example: find the element that contains the error text
	    return driver.findElement(By.xpath("//div[contains(text(),'" + expectedMessage + "')]")).getText();
	}
	
	public void clickDropdown(String dropdownName) {
		switch (dropdownName.toLowerCase()) {
	    case "allergies": allergiesDropdown.click(); 
	        break;
	    case "food preference": foodDropdown.click(); 
	        break;
	    case "cuisine category": cuisineDropdown.click(); 
	        break;
	    default: 
            logger.info("Dropdown not found: " + dropdownName);
	    
	}
			}
	public int getDropdownOptionsCount(String dropdownName) {
	    switch (dropdownName.toLowerCase()) {
	        case "allergies": return allergiesOptions.size();
	        case "food preference": return foodOptions.size();
	        case "cuisine category": return cuisineOptions.size();
	        default: 
	        	throw new IllegalArgumentException("Invalid dropdown: " + dropdownName);
	    }
	}
	
	public List<String> getDropdownOptions(String dropdownName) {
	    List<WebElement> options;
	    switch (dropdownName.toLowerCase()) {
	        case "allergies": options = allergiesOptions;
	        break;
	        case "food preference": options = foodOptions;
	        break;
	        case "cuisine category": options = cuisineOptions;
	        break;
	        default:  logger.info("Dropdown not found: " + dropdownName);
            return new ArrayList<>();
	    }
	    
	    List<String> optionTexts = new ArrayList<>();
	    for (WebElement opt : options) {
	        optionTexts.add(opt.getText().trim());
	    }
	    return optionTexts;
	}
	
	public void selectDropdownValue(String dropdown, String value) {

	     List<WebElement> options;
	    switch (dropdown.toLowerCase()) {
	        case "allergies": options = allergiesOptions;
	            break;
	        case "food preference": options = foodOptions;
	            break;
	        case "cuisine category": options = cuisineOptions;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid dropdown: " + dropdown);
	    }
	    clickDropdown(dropdown);
	    selectDropdown(options, value);
	}	
}