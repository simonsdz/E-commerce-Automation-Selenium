package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderElements {

	WebDriver driver;
	
	public OrderElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[class='_2IX_2- VJZDxU']") public WebElement mobileNumber;
	@FindBy(xpath = "//input[@type='password']") public WebElement password;
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Login')]") public WebElement loginButton;
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']") public WebElement searchBox;
	@FindBy(xpath = "//button[@type='submit']") public WebElement searchButton;
	@FindBy(xpath = "//div[normalize-space()='APPLE iPhone 12 (Blue, 64 GB)']") public WebElement mobile;
	@FindBy(xpath = "//input[@id='pincodeInputId']") public WebElement pincodePlace;
	@FindBy(css = "._2P_LDn") public WebElement checkButton;
	@FindBy(xpath = "//button[normalize-space()='ADD TO CART']") public WebElement addToCartButton;
	@FindBy(css = "._2KpZ6l._2ObVJD._3AWRsL") public WebElement checkoutButton;
	
}
