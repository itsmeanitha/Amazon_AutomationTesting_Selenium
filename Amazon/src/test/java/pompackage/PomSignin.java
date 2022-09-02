package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Testbase;

public class PomSignin extends Testbase {
	@FindBy(css = "#nav-link-accountList")
	WebElement AccountandLists;
	@FindBy(css = "#authportal-main-section > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a")
	WebElement signin;
	@FindBy(id = "ap_email")
	WebElement email;
	@FindBy(id = "continue")
	WebElement Continue1;
	@FindBy(id = "ap_password")
	WebElement Password;
	@FindBy(id = "signInSubmit")
	WebElement Continue2;
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement Storelogo;

	public PomSignin() {
		PageFactory.initElements(driver, this);

	}

	public boolean validatestoreLogo() {
		return Storelogo.isDisplayed();
	}

	public PomYourAccount login(String emailormob, String pass) throws InterruptedException {

		AccountandLists.click();
		// signin.click();
		email.sendKeys(emailormob);
		Continue1.click();
		Password.sendKeys(pass);
		Continue2.click();
		Thread.sleep(2000);
		return new PomYourAccount();

	}

	public String verify() {
		return driver.getTitle();
	}
}
