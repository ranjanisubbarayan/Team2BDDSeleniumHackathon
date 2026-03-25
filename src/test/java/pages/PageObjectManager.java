package pages;

public class PageObjectManager {

	private DashboardPage dashboardPage;
	private MyPatientsPage myPatientsPage;
	private EditPatientPage editPatientPage;
	private DeletePatientPopupPage deletePatientPopupPage;
	private AddPatientPage addPatient;
	private LoginPage loginPage;

	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}

	public MyPatientsPage getMyPatientsPage() {
		if (myPatientsPage == null) {
			myPatientsPage = new MyPatientsPage();
		}
		return myPatientsPage;
	}

	public AddPatientPage getAddPatient() {
		if (addPatient == null) {
			addPatient = new AddPatientPage();
		}
		return addPatient;
	}

	public EditPatientPage getEditPatientPage() {
		if (editPatientPage == null) {
			editPatientPage = new EditPatientPage();
		}
		return editPatientPage;
	}

	public DeletePatientPopupPage getDeletePatientPopupPage() {
		if (deletePatientPopupPage == null) {
			deletePatientPopupPage = new DeletePatientPopupPage();
		}
		return deletePatientPopupPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

}
