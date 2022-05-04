package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.CommonActions;
import actions.OrderActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver;
	CommonActions common_actions;
	OrderActions order_actions;
	
	public StepDefinitions(CommonActions common_actions, OrderActions order_actions, CommonSteps cs) {
		this.common_actions = common_actions;
		this.order_actions = order_actions;
		this.driver = cs.getDriver();
	}
	
	@Given("I am on Flipkart Home Page")
	public void i_am_on_Flipkart_Home_Page() throws Exception {
		String flipkartPageUrl = "https://www.flipkart.com/";
		common_actions.goToUrl(flipkartPageUrl);
		Thread.sleep(1000);
		//enter the credentials to login
		order_actions.enterMobileNumber();
		Thread.sleep(1000);
		order_actions.enterPassword();
		Thread.sleep(1000);
		order_actions.clickLogin();
		Thread.sleep(3000);
	}

	@When("I order a product")
	public void i_order_a_product() throws Exception {
		//search for iphone 12 in search box
		order_actions.enterMobileInSearchBox();
		Thread.sleep(1000);
		//click search button
		order_actions.clickSearch();
		Thread.sleep(1000);
		//click the 1st mobile
		order_actions.clickDesiredMobile();
		Thread.sleep(1000);
		
		Set<String> windows = driver.getWindowHandles();
		List<String> list = new ArrayList(windows);
		driver.switchTo().window(list.get(1));
		
		//enter pincode
		order_actions.enterPincode();
		Thread.sleep(1000);
		//click check
		order_actions.clickCheck();
		Thread.sleep(1000);
		
		//add to cart
		order_actions.clickAddToCart();
		Thread.sleep(1000);
		//proceed to checkout
		order_actions.clickCheckout();
		Thread.sleep(1000);
	}

	@Then("my order is placed successfully")
	public void my_order_is_placed_successfully() {
		String paymentPage = "https://www.flipkart.com/checkout/init?loginFlow=false";
		String currUrl = common_actions.getCurrentPageUrl();
		if(paymentPage.equals(currUrl)) {
			System.out.println("Reached the confirmation page successfully");
		}
	}
}
