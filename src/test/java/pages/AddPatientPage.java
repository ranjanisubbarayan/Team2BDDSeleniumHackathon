package pages;

import java.util.List;

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
	private WebElement sP;
	
	@FindBy (id =("DP"))
	private WebElement dP;	
	
	@FindBy (xpath =("//select") )
	private List<WebElement> dropDownCount ;
	
	@FindBy (xpath =("//select[@id='cuisine']/option") )
	private List<WebElement> cuisineOptions ;
	
	@FindBy (xpath =("//select[@id='foodPreference']/option") )
	private List<WebElement> foodOptions ;
	
	@FindBy (xpath =("//select[@id='allergies']/option") )
	private List<WebElement> allergiesOptions ;
	
	@FindBy (xpath = ("//input[not(@type='file') and not(@type='date')]"))
	private List<WebElement> inputFields;
	
	@FindBy (xpath = ("//input[@type = 'file']"))
	private List<WebElement> uploadFile;
	
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
	
	
	
}
