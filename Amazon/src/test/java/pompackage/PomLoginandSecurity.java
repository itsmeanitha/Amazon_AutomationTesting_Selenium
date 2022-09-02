package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Testbase;

public class PomLoginandSecurity extends Testbase {
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signinSumbit;
	@FindBy(xpath = "//span[contains(text(),'For your security, approve the notification sent t')]")
	WebElement Securitycheck;

	public String verify() {
		return driver.getTitle();
	}

	public PomLoginandSecurity() {
		PageFactory.initElements(driver, this);

	}

	public void securitycheck(String pass) {
		password.sendKeys(pass);
		signinSumbit.click();
		Securitycheck.isDisplayed();
	}

}
