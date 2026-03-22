package pages;

public class PageObjectManager {
	
	private DashboardPage dashboardPage;

	public DashboardPage getDashboardPage() {
		if (dashboardPage == null) {
			dashboardPage = new DashboardPage();
		}
		return dashboardPage;
	}

}
