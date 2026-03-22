package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DriverManager.DriverFactory;

public class DashboardPage {

	private WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

	public DashboardPage() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		logger.info("DashboardPage initialized successfully.");
	}

	@FindBy(xpath = "//ul//a")
	private List<WebElement> navlinks;
	
	@FindBy(css = "i.fa-home")
	private WebElement homeIcon;


	public List<String> getNavigationLinks() {
		logger.info("Fetching navigation bar links.");

		return navlinks.stream().map(WebElement::getText).map(String::trim).toList();
	}

	public void clickNavigationLink(String linkText) {
		logger.info("Clicking navigation link: {}", linkText);

		WebElement link = navlinks.stream().filter(e -> e.getText().trim().equalsIgnoreCase(linkText)).findFirst()
				.orElse(null);
		if (link == null) {
			throw new RuntimeException("Navigation link not found: " + linkText);
		}
		link.click();
	}
	
	public void clickHomeIcon()
	{
		logger.info("Clicking Home icon on navugation bar");
		homeIcon.click();
	}

}
