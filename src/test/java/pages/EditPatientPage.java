package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;
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
	
	
	
	
	
	
	
}
