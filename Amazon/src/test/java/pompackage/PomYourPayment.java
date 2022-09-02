package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.Testbase;

public class PomYourPayment extends Testbase {
	@FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/ul/div/li[2]/span/a")
	WebElement wallet; // a[contains(text(),'Wallet')]
	@FindBy(css = "#pp-FK8ZWX-26")
	WebElement AddAPayment;
	@FindBy(xpath = "//*[@id=\"pp-bhaCcc-35\"]/span/input")
	WebElement AddACreditOrDebitCard;
	@FindBy(xpath = "//*[@id=\"pp-rRsJuy-15\"]")
	WebElement cardnumber1;
	@FindBy(xpath = "//*[@id=\"pp-rRsJuy-17\"]")
	WebElement nameoncard1;

	@FindBy(xpath = "//*[@id=\"pp-BGKfoS-21\"]/span/span/span")
	WebElement expiryMM1;
	@FindBy(xpath = "//*[@id=\"pp-BGKfoS-22\"]/span/span/span")
	WebElement expiryYY1;
	@FindBy(xpath = "//*[@id=\"pp-ZZMz4v-24\"]/span/input")
	WebElement addyourcard;

	public String verify() {
		return driver.getTitle();
	}

	public PomYourPayment() {
		PageFactory.initElements(driver, this);

	}

	public void addcard(String cardnumber, String nameoncard) {
		wallet.click();
		driver.switchTo().frame(1);
		AddAPayment.click();
		driver.switchTo().frame(2);
		AddACreditOrDebitCard.click();
		driver.switchTo().frame(3);
		cardnumber1.sendKeys(cardnumber);
		nameoncard1.sendKeys(nameoncard); // ApxSecureIframe-pp-rfiOWi-5
		Select obj = new Select(expiryMM1); // pp-rfiOWi-33
		obj.selectByIndex(4); // id DAsis
		Select obj2 = new Select(expiryYY1);
		obj2.selectByIndex(4);
		addyourcard.click();

	}
}
