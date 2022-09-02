package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.Testbase;

public class PomYourAddress extends Testbase {
	@FindBy(xpath = "//h2[contains(text(),'Add Address')]")
	WebElement AddAddress;
	@FindBy(xpath = "//span[contains(text(),'Default:')]")
	WebElement DefaultAddress;

	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
	public WebElement FullName;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phoneno;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement Addressline1;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement Addressline2;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement city;
	@FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement Postalcode;
	@FindBy(xpath = "//*[@id='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement province;
	@FindBy(xpath = "//input[@id='address-ui-widgets-use-as-my-default']")
	WebElement makingdefault;
	@FindBy(xpath = "//select[@id=\'address-ui-widgets-form-submit-button\']")
	WebElement addaddress;

	public void addingAaddress(String name, String emailormob, String Addresslinea, String Addresslineb, String cityis,
			String Postal) throws InterruptedException {
		AddAddress.click();
		FullName.sendKeys(name);
		phoneno.sendKeys(emailormob);
		Addressline1.sendKeys(Addresslinea);
		Addressline2.sendKeys(Addresslineb);
		city.sendKeys(cityis);
		Select obj = new Select(
				driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]")));
		obj.selectByVisibleText("Ontario");
		Postalcode.sendKeys(Postal);
		makingdefault.click();
		addaddress.click();
		Thread.sleep(2000);
	}

	public PomYourAddress() {
		PageFactory.initElements(driver, this);

	}

	public String verify() {
		return driver.getTitle();
	}

	public boolean verifyDefaultAddress() {
		return DefaultAddress.isDisplayed();
	}

	public boolean verifyAddAddress() {
		return AddAddress.isDisplayed();
	}
}
