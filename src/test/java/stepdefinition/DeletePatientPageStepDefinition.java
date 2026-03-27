package stepdefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectManager;
import utils.ElementUtil;

public class DeletePatientPageStepDefinition {
	
	private final PageObjectManager pom;
	private static final Logger logger = LoggerFactory.getLogger(DeletePatientPageStepDefinition.class);

	public DeletePatientPageStepDefinition(PageObjectManager pom) {
		this.pom = pom;
	}
	
	private String selectedPatientName;
	private int rowCountBeforeDelete;
	

	@When("User clicks the Delete icon for a {string} in the patient table")
	public void user_clicks_the_delete_icon_for_a_in_the_patient_table(String patientname) {
	
	    if (patientname != null && !patientname.trim().isEmpty()) {
	    	pom.getDeletePatientPopupPage().getDeleteIconByPatientName(patientname);
	    } else {
	    	pom.getDeletePatientPopupPage().clickDeleteIconForfirstRowPatient();
	    }
	}


	@Then("Alert should display {string} {string} in the delete popup section")
	public void alert_should_display_in_the_delete_popup_section(String elementtype, String Expectedresults) {
		selectedPatientName = pom.getDeletePatientPopupPage().getFirstPatientName();
		String Element = elementtype.trim().toLowerCase();
		switch (Element) {
		case "title":
			String actualTitle = pom.getDeletePatientPopupPage().getAlertTitle();
			logger.info("Actual alert title: {}", actualTitle);
			Assert.assertEquals(actualTitle, Expectedresults, "Alert title mismatch");
			break;

		case "text":
			String actualText = pom.getDeletePatientPopupPage().getAlertText();
			logger.info("Actual alert text: {}", actualText);

			if (Expectedresults.contains("[Patient Name]") && selectedPatientName != null && !selectedPatientName.isEmpty()) {
				String expectedText = Expectedresults.replace("[Patient Name]", selectedPatientName);
				Assert.assertEquals(actualText, expectedText, "Alert text mismatch");
			} else {
				Assert.assertEquals(actualText, Expectedresults, "Alert text mismatch");
			}
			break;

		case "yesbutton":
			Assert.assertTrue(pom.getDeletePatientPopupPage().isYesButtonDisplayed(),
					"Yes button is not displayed in delete popup");
			break;

		case "nobutton":
			Assert.assertTrue(pom.getDeletePatientPopupPage().isNoButtonDisplayed(),
					"No button is not displayed in delete popup");
			break;

		default:
			
		}
	}
		

	@When("User {string} the alert in the delete popup")
	public void user_the_alert_in_the_delete_popup(String action) {
		
		logger.info("Performing alert action: {}", action);
		
		switch (action.trim().toLowerCase()) {
		case "accepts":
			pom.getDeletePatientPopupPage().acceptAlertIfBrowserAlertPresent();
			break;

		case "dismiss":
			pom.getDeletePatientPopupPage().dismissAlertIfBrowserAlertPresent();
			break;
		default:
			
		}
	   
	}

	@Then("User should {string} in the dietician application")
	public void user_should_in_the_dietician_application(String expectedresult) {
		rowCountBeforeDelete = pom.getDeletePatientPopupPage().getPatientRowCount();
		switch (expectedresult.trim().toLowerCase()) {
		case "navigated back to main page":
			String currentUrl = ElementUtil.getURL();
			logger.info("Current URL after alert action: {}", currentUrl);
			Assert.assertTrue(currentUrl.toLowerCase().contains("mypatient"),"User is not navigated back to main page");
			break;

		case "patient removed from the table and success message displayed":
			if (selectedPatientName != null && !selectedPatientName.isEmpty()) {
				Assert.assertTrue(pom.getDeletePatientPopupPage().isPatientRemovedFromTable(selectedPatientName),"Patient is still present in the table after delete confirmation");
			} else {
				int rowCountAfterDelete = pom.getDeletePatientPopupPage().getPatientRowCount();
				Assert.assertTrue(rowCountAfterDelete < rowCountBeforeDelete,
						"Patient row count did not decrease after delete confirmation");
			}

			Assert.assertTrue(pom.getDeletePatientPopupPage().isSuccessMessageDisplayed(),
					"Success message is not displayed after deleting patient");
			break;

		case "alert closed and patient remains in the table":
			
			 pom.getDeletePatientPopupPage().clickPopupCloseIcon();
			Assert.assertTrue(pom.getDeletePatientPopupPage().isPopupClosed(),
					"Delete popup is still displayed after dismissing");

			if (selectedPatientName != null && !selectedPatientName.isEmpty()) {
				Assert.assertTrue(pom.getDeletePatientPopupPage().isPatientStillPresentInTable(selectedPatientName),
						"Patient is not present in the table after cancelling delete");
			}
			break;

		default:
			
		}
	}
	}



