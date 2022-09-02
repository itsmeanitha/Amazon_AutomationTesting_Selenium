package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.Testbase;

public class PomCreateAccount extends Testbase {

	@FindBy(css = "#nav-link-accountList")
	WebElement AccountandLists;
	@FindBy(xpath = "//a[contains(text(),'Start here.')]")
	WebElement Starthere;
	@FindBy(css = "#ap_customer_name")
	WebElement yourname;
	@FindBy(css = "#ap_email")
	WebElement mobilenooremail;
	@FindBy(css = "#ap_password")
	WebElement password;
	@FindBy(css = "#ap_password_check")
	WebElement passwordagain;
	@FindBy(css = "#continue")
	WebElement continuebtn;
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

//initiate page elements
	public PomCreateAccount() {
		PageFactory.initElements(driver, this);

	}

	/*
	 * public void act() throws InterruptedException { Actions action=new
	 * Actions(driver); action.moveToElement(AccountandLists).build().perform();
	 * Thread.sleep(2000);
	 * action.moveToElement(Starthere).click().build().perform();
	 * Thread.sleep(2000); } /* public void typeyourname(String name) {
	 * yourname.sendKeys(name); } public void typemobilenooremail(String
	 * mobilenoemail) { mobilenooremail.sendKeys(mobilenoemail); } public void
	 * typepassword(String pass) { password.sendKeys(pass); } public void
	 * typepasswordagain(String passA) { passwordagain.sendKeys(passA); } public
	 * void clickbtn() { continuebtn.click(); }
	 */
	public boolean validatestoreLogo() {
		return Storelogo.isDisplayed();
	}

	public String verify() {
		return driver.getTitle();
	}

	public PomYourAccount login(String name, String emailormob, String pass, String passA) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(AccountandLists).build().perform();
		Thread.sleep(2000);
		action.moveToElement(Starthere).click().build().perform();
		Thread.sleep(2000);
		yourname.sendKeys(name);
		mobilenooremail.sendKeys(emailormob);
		password.sendKeys(pass);
		passwordagain.sendKeys(passA);
		continuebtn.click();
		signin.click();
		email.sendKeys(emailormob);
		Continue1.click();
		Password.sendKeys(pass);
		Continue2.click();
		Thread.sleep(2000);
		return new PomYourAccount();

	}
	/*
	 * public PomYourAccount login1(String emailormob,String pass) throws
	 * InterruptedException {
	 * 
	 * AccountandLists.click(); email.sendKeys(emailormob); Continue1.click();
	 * Password.sendKeys(pass); Continue2.click(); Thread.sleep(2000); return new
	 * PomYourAccount();
	 * 
	 * }
	 */
}
