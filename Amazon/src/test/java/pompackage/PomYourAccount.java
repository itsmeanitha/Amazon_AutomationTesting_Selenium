package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Testbase;

public class PomYourAccount extends Testbase {

	@FindBy(css = "#nav-link-accountList")
	WebElement AccountandLists;
	@FindBy(xpath = "//span[contains(text(),'Your Account')]")
	WebElement YourAccount;
	@FindBy(xpath = "//span[text()='Hello, Anitha']")
	WebElement userNameLabel;
	@FindBy(xpath = "//span[text()='Track, return, or buy things again']")
	WebElement YourOrders;
	@FindBy(xpath = "//span[contains(text(),'Edit login, name, and cell phone number')]")
	WebElement LoginAndSecurity;
	@FindBy(xpath = "//h2[contains(text(),'Your Addresses')]")
	WebElement YourAddress;
	@FindBy(xpath = "//span[contains(text(),'Manage payment methods and settings, view all tran')]")
	WebElement YourPayments;
	@FindBy(css = "#twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement CartButton;

	// initiate page elements
	public PomYourAccount() {
		PageFactory.initElements(driver, this);

	}

	public void act1() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(AccountandLists).build().perform();
		Thread.sleep(2000);
		action.moveToElement(YourAccount).click().build().perform();
		Thread.sleep(2000);
	}

	public String verify() {
		return driver.getTitle();
	}

	public String getuserNameLabel() {
		return userNameLabel.getText();
	}

	public boolean verifyuserNameLabel() {
		return userNameLabel.isDisplayed();
	}

	public PomYourOrders ClickonYourOrders() {
		YourOrders.click();
		return new PomYourOrders();

	}

	public PomYourAddress ClickonYourAddress() {
		YourAddress.click();
		return new PomYourAddress();

	}

	public PomYourPayment ClickonYourPayments() {
		YourPayments.click();
		return new PomYourPayment();

	}

	public PomLoginandSecurity ClickonLoginandSecurity() {
		LoginAndSecurity.click();
		return new PomLoginandSecurity();
	}

	public PomSearchingSortingFiltering verifysearch(String product) {
		searchbox.click();
		searchbox.sendKeys(product);

		return new PomSearchingSortingFiltering();
	}

	public PomShoppingCart ClickOnCart() {
		CartButton.click();
		return new PomShoppingCart();
	}
}