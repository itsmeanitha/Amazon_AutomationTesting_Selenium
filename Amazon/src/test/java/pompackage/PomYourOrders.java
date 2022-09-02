package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.Testbase;

public class PomYourOrders extends Testbase {
	@FindBy(xpath = "//a[Contains(text(),'Orders')]")
	WebElement Orders;
	@FindBy(xpath = "//select[@id='orderFilter']")
	WebElement OrdersFilter;
	/*
	 * @FindBy(xpath="//a[@id='orderFilter_0']") WebElement thepast30days;
	 * 
	 * @FindBy(xpath="//a[@id='orderFilter_1']") WebElement past3months;
	 * 
	 * @FindBy(xpath="//a[@id='orderFilter_2']") WebElement Orderat2022;
	 */

	@FindBy(xpath = "//a[text()='Buy Again']")
	WebElement BuyAgain;
	@FindBy(xpath = "//a[contains(text(),'Not Yet Shipped')]")
	WebElement NotYetShipped;
	@FindBy(xpath = "//a[contains(text(),'Cancelled Orders')]")
	WebElement CancelledOrders;

	public PomYourOrders() {
		PageFactory.initElements(driver, this);

	}

	public String verify() {
		return driver.getTitle();
	}

	/*
	 * public void ClickonOrders() { Orders.click(); }
	 */
	public void orderfilter1() {
		// Orders.click();
		driver.switchTo().frame("//div//a[1]");
		Select obj = new Select(driver.findElement(By.xpath("//select[@id='orderFilter']")));
		obj.selectByValue("last30");
	}

	public void orderfilter2() {
		// Orders.click();
		Select obj = new Select(OrdersFilter);
		obj.selectByValue("months-3");
	}

	public void orderfilter3() {
		// Orders.click();
		Select obj = new Select(OrdersFilter);
		obj.selectByValue("year-2022");
	}

	public void ClickonBuyAgain() {
		BuyAgain.click();
	}

	public void ClickonNotYetShipped() {
		NotYetShipped.click();
	}

	public void ClickonCancelledOrders() {
		CancelledOrders.click();
	}

}
