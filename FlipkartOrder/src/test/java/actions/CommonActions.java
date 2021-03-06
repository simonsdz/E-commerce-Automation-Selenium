package actions;

import org.openqa.selenium.WebDriver;

import steps.CommonSteps;

public class CommonActions {

	private WebDriver driver;
	
	public CommonActions(CommonSteps cs) {
		this.driver = cs.getDriver();
	}
	
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
}
