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
		//driver.findElement(By.cssSelector("input[class='_2IX_2- VJZDxU']")).sendKeys("7358747596");
		order_actions.enterMobileNumber();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("simosri1831");
		order_actions.enterPassword();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Login')]")).click();
		order_actions.clickLogin();
		Thread.sleep(3000);
	}

	@When("I order a product")
	public void i_order_a_product() throws Exception {
		//search for iphone 12 in search box
		//driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("iphone 12 blue");
		order_actions.enterMobileInSearchBox();
		Thread.sleep(1000);
		//click search button
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		order_actions.clickSearch();
		Thread.sleep(1000);
		//click the 1st mobile
		//driver.findElement(By.xpath("//div[normalize-space()='APPLE iPhone 12 (Blue, 64 GB)']")).click();
		order_actions.clickDesiredMobile();
		Thread.sleep(1000);
		
		Set<String> windows = driver.getWindowHandles();
		List<String> list = new ArrayList(windows);
		driver.switchTo().window(list.get(1));
		
		//enter pincode
		//driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("603202");
		order_actions.enterPincode();
		Thread.sleep(1000);
		//click check
		//driver.findElement(By.cssSelector("._2P_LDn")).click();
		order_actions.clickCheck();
		Thread.sleep(1000);
		
		//add to cart
		//driver.findElement(By.xpath("//button[normalize-space()='ADD TO CART']")).click();
		order_actions.clickAddToCart();
		Thread.sleep(1000);
		//proceed to checkout
		//driver.findElement(By.cssSelector("._2KpZ6l._2ObVJD._3AWRsL")).click();
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
