package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Paths;
import DriverManager.DriverFactory;
import org.testng.Assert;
import utils.WaitUtils;

public class EditPatientPage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	private static final Logger logger = LoggerFactory.getLogger(EditPatientPage.class);
	
	
	public EditPatientPage() {
		
		this.driver = DriverFactory.getDriver();
		this.waitUtils = new WaitUtils();
		PageFactory.initElements(driver, this);
		logger.info("EditPatientPage initialized successfully.");
	}
	
	
	@FindBy(xpath = "//*[contains(text(),'Edit patient')]")
	private WebElement dialogTitle;
	
	@FindBy(xpath = "//input[@placeholder='First name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder='Last name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Contact Number']")
	private WebElement contactNumber;

	@FindBy(xpath = "//input[@placeholder='Date of Birth']")
	private WebElement dob;

	@FindBy(xpath = "//input[@placeholder='Weight']")
	private WebElement weight;
	
	@FindBy(xpath = "//input[@placeholder='Height']")
	private WebElement height;

	@FindBy(xpath = "//input[@placeholder='Temperature']")
	private WebElement temperature;

	@FindBy(xpath = "//input[@placeholder='SP']")
	private WebElement sp;

	@FindBy(xpath = "//input[@placeholder='DP']")
	private WebElement dp;
	
	@FindBy(xpath = "//*[contains(text(),'Vitals')]")
	private WebElement vitalsSectionTitle;
	
	@FindBy(xpath = "//*[contains(text(),'Allergies')]")
	private WebElement allergiesDropdown;

	@FindBy(xpath = "//*[contains(text(),'Food Preference')]")
	private WebElement foodPreferenceDropdown;

	@FindBy(xpath = "//*[contains(text(),'Cuisine Category')]")
	private WebElement cuisineCategoryDropdown;
		
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUploadInput;

	@FindBy(xpath = "//*[contains(text(),'Upload Health Report')]")
	private WebElement uploadHealthReportLabel;

	@FindBy(xpath = "//*[contains(text(),'No file chosen')]")
	private WebElement noFileChosenText;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//button[normalize-space()='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//*[contains(text(),'required')]")
	private List<WebElement> errorMessages;
	
	@FindBy(xpath = "//input")
	private List<WebElement> inputFields;

	@FindBy(xpath = "//select | //*[@role='combobox']")
	private List<WebElement> dropdowns;
	
	
	public boolean isEditPatientDialogDisplayed() {
        return isElementDisplayed(dialogTitle);
    }

    public boolean isSubmitButtonDisplayed() {
        return isElementDisplayed(submitButton);
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }
    
    public boolean isCloseButtonDisplayed() {
        return isElementDisplayed(closeButton);
    }

    public boolean isCloseButtonEnabled() {
        return closeButton.isEnabled();
    }

    public boolean isVitalsTitleDisplayed() {
        return isElementDisplayed(vitalsSectionTitle);
    }
    public boolean isnoFileChosenTextDisplayed() {
        return isElementDisplayed(noFileChosenText);
    }
    public boolean isFileUploadOptionDisplayed() {
        return isElementDisplayed(fileUploadInput) || isElementDisplayed(uploadHealthReportLabel);
    }
    
    public int getInputFieldCount() {
        return inputFields.size();
    }

    public int getDropdownCount() {
        return dropdowns.size();
    }
    private WebElement getField(String fieldName) {

        fieldName = fieldName.trim().toLowerCase();

        if (fieldName.equals("first name")) {
            return firstName;
        }

        if (fieldName.equals("last name")) {
            return lastName;
        }

        if (fieldName.equals("email")) {
            return email;
        }

        if (fieldName.equals("contact number") || fieldName.equals("contact no")) {
            return contactNumber;
        }

        if (fieldName.equals("dob") || fieldName.equals("date of birth")) {
            return dob;
        }

        if (fieldName.equals("weight")) {
            return weight;
        }

        if (fieldName.equals("height")) {
            return height;
        }

        if (fieldName.equals("temperature")) {
            return temperature;
        }

        if (fieldName.equals("sp")) {
            return sp;
        }

        if (fieldName.equals("dp")) {
            return dp;
        }

        throw new IllegalArgumentException("No field found: " + fieldName);
    }
	
    public void clearField(String fieldName) {
        WebElement field = getField(fieldName);
        waitForVisibility(field);
        field.click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.DELETE);
        logger.info("Cleared field: {}", fieldName);
    }
	
    public void enterValue(String fieldName, String value) {
        WebElement field = getField(fieldName);
        waitForVisibility(field);
        field.click();
        field.clear();
        if (value != null && !value.isEmpty()) {
            field.sendKeys(value);
        }
        logger.info("Entered value '{}' in field '{}'", value, fieldName);
    }

    public String getFieldValue(String fieldName) {
        WebElement field = getField(fieldName);
        waitForVisibility(field);
        String value = field.getAttribute("value");
        logger.info("Field '{}' current value is '{}'", fieldName, value);
        return value == null ? "" : value.trim();
    }

    public void clickSubmit() {
        waitForClickable(submitButton);
        submitButton.click();
        logger.info("Clicked Submit button.");
    }
    
    public void clickClose() {
        waitForClickable(closeButton);
        closeButton.click();
        logger.info("Clicked Close button.");
    }
    
    public void uploadFile(String filePath) {
        waitForVisibility(fileUploadInput);
        fileUploadInput.sendKeys(Paths.get(filePath).toAbsolutePath().toString());
        logger.info("Uploaded file: {}", filePath);
    }
    
    public boolean isErrorMessageDisplayed(String expectedMessage) {

        List<WebElement> elements = driver.findElements(
            By.xpath("//*[contains(text(), '" + expectedMessage + "')]")
        );

        for (WebElement el : elements) {
            if (el.isDisplayed()) {
                return true;
            }
        }

        return false;
    }
    public boolean isRequiredMessageDisplayed() {
        return !errorMessages.isEmpty();
    }

    public void selectDOB(String date) {
        waitForVisibility(dob);
        dob.click();
        dob.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dob.sendKeys(date);
        dob.sendKeys(Keys.TAB);
        logger.info("Selected DOB: {}", date);
    }
    
    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isFieldDisplayed(String fieldName) {
        return isElementDisplayed(getField(fieldName));
    }

    public boolean isFieldEnabled(String fieldName) {
        return getField(fieldName).isEnabled();
    }

    public void assertFieldValue(String fieldName, String expectedValue) {
        Assert.assertEquals(
                "Field value mismatch for: " + fieldName,
                expectedValue,
                getFieldValue(fieldName));
    }

    public void assertPlaceholder(String fieldName, String expectedPlaceholder) {
        Assert.assertEquals(
                "Placeholder mismatch for: " + fieldName,
                expectedPlaceholder,
                getPlaceholder(fieldName));
    }
    public String getPlaceholder(String fieldName) {
        WebElement field = getField(fieldName);
        waitForVisibility(field);
        return field.getAttribute("placeholder");
    }
    private void waitForVisibility(WebElement element) {
        try {
        	WaitUtils.waitForVisibility(driver, element, 10);
        } catch (Exception e) {
            logger.warn("Visibility wait failed, proceeding anyway.");
        }
    }

    private void waitForClickable(WebElement element) {
        try {
        	waitUtils.waitForClickable(element);
        } catch (Exception e) {
            logger.warn("Clickable wait failed, proceeding anyway.");
        }
    }
    

	  public boolean isTitleAfterDOBField() {
      try {
          int dobY = dob.getLocation().getY();
          int vitalsY = vitalsSectionTitle.getLocation().getY();
          return vitalsY >= dobY;
      } catch (Exception e) {
          logger.warn("Could not compare DOB and Vitals positions.");
          return false;
      }
  }

}
