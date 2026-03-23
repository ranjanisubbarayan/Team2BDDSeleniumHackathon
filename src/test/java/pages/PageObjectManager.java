package pages;

public class PageObjectManager {
	
	private DashboardPage dashboardPage;
    private EditPatientPage editPatientPage;

	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}

    public EditPatientPage getEditPatientPage() {
        if (editPatientPage == null) {
            editPatientPage = new EditPatientPage();
        }
        return editPatientPage;
    }

	
}
