package actions;

import org.openqa.selenium.WebDriver;

import elements.OrderElements;
import steps.CommonSteps;

public class OrderActions {

	private WebDriver driver;
	OrderElements elements;
	
	public OrderActions(CommonSteps cs) {
		this.driver = cs.getDriver();
		elements = new OrderElements(driver);
	}
	//Enter your flipkart login credentials
	public void enterMobileNumber() {
		elements.mobileNumber.sendKeys("12345678");
	}
	public void enterPassword() {
		elements.password.sendKeys("********");
	}
	public void clickLogin() {
		elements.loginButton.click();
	}
	public void enterMobileInSearchBox() {
		elements.searchBox.sendKeys("iphone 12 blue");
	}
	public void clickSearch() {
		elements.searchButton.click();
	}
	public void clickDesiredMobile() {
		elements.mobile.click();
	}
	public void enterPincode() {
		elements.pincodePlace.sendKeys("603202");
	}
	public void clickCheck() {
		elements.checkButton.click();
	}
	public void clickAddToCart() {
		elements.addToCartButton.click();
	}
	public void clickCheckout() {
		elements.checkoutButton.click();
	}
}
