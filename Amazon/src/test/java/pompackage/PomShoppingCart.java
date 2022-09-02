package pompackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.qa.base.Testbase;

public class PomShoppingCart extends Testbase {

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchsumbitbutton;
	@FindBy(xpath = "//*[@id=\"acrPopover\"]")
	WebElement review;
	@FindBy(xpath = "//span[contains(text(),'Mens Force Relaxed Fit Midweight Short Sleeve Pock')]")
	WebElement productresult;
	@FindBy(xpath = "//div//span//div[@data-component-type='s-search-result']//div[@cel_widget_id='MAIN-SEARCH_RESULTS-22']")
	WebElement Nthproduct;
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement AddtoCart;
	@FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
	WebElement AddedtoCart;
	/*
	 * Select s = new
	 * Select(driver.findElement(By.xpath("//select[@id='quantity']")));
	 * s.selectByValue("2");
	 */
	@FindBy(xpath = "//*[@id=\"sc-item-Ca662f176-1c4e-4e68-aa31-d803bf280785\"]/div[4]/div/div[3]/div[1]/span[2]/span/input")
	WebElement RemoveFromCart;
	@FindBy(xpath = "//a[@id='select-all']")
	WebElement SelectAllinCart;
	@FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[5]/div[1]/span[2]")
	WebElement CartButton;
	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement CartButton1;
	@FindBy(css = "#a-autoid-7-announce")
	WebElement quantity;
	@FindBy(xpath = "//*[@id='a-autoid-5-announce']")
	WebElement UpdatedQuantity;
	@FindBy(xpath = "//*[@id=\"sc-subtotal-amount-activecart\"]/span")
	WebElement CartTotal;
	// div[@data-item-index="1"]//div//div//div//ul//li//span//a//span//span//span//span[@class='aok-hidden']
	@FindBy(xpath = "//div[@data-item-index=\"2\"]//div//div//div//ul//li//span//a//span//span[1]//span[1]")
	WebElement ClickOnItemInCart;
	@FindBy(xpath = "//a[contains(text(),'Go to cart')]")
	WebElement CheckCart;
	@FindBy(css = "#twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(xpath = "//*[@id='sc-subtotal-amount-activecart']//span[1]")
	WebElement productprice;
	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[3]/div[1]/span[2]/span[1]/input[1]")
	WebElement deleteprodincart1;
	@FindBy(xpath = "//*[@id='sc-item-Ce155685e-3ea9-478a-8c32-abb4d797f36c']/div[4]/div/div[3]/div[1]/span[2]/span/input")
	WebElement deleteprodincart;
	@FindBy(xpath = "//div[@id='sc-retail-cart-container']//div[1]//div[2]//div[@data-name='Active Items']//div[@data-itemtype='active']//div[3]//div[1]//span[2]//span[1]//input[1]")
	List<WebElement> deleteiconforprodincart;
	@FindBy(xpath = "//div[@id='sc-retail-cart-container']//div[1]//div[2]//div[@data-name='Active Items']//div[@data-itemtype='active']")
	List<WebElement> itemincart;
	@FindBy(xpath = "//h1[contains(text(),'Your Amazon Cart is empty.')]")
	WebElement emptycartmessage;
	@FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
	WebElement ItemLeftIncart;
	@FindBy(xpath = "//div[@data-name='Active Items']//div[@data-item-index='1']//div[4]//div[3]//ul//li//span[@class='a-list-item']//a[@class='a-link-normal sc-product-link']")
	WebElement ItemIncart;
	@FindBy(xpath = "//div[@class='a-column a-span8 a-span-last']//div//div//div[@id='centerCol']")
	WebElement productdetails;
	@FindBy(xpath = "//div[@id='centerCol']")
	WebElement productdetails1;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[6]/div[4]/div[4]")
	WebElement productdetails2;
	@FindBy(xpath = "//div[@id='prodDetails']")
	WebElement productdetails3;
	
	public String verify() {
		return driver.getTitle();
	}

	public PomShoppingCart() {
		PageFactory.initElements(driver, this);

	}

	public void AddToCart() {
		searchsumbitbutton.click();
		Nthproduct.click();
		AddtoCart.click();
	}

	public String AddedToCart() {
		return AddedtoCart.getText();
	}

	public void addquantity() {
		CartButton.click();
		Select s = new Select(driver.findElement(By.xpath("//div[@data-item-index='3']//select[@id='quantity']")));
		s.selectByVisibleText("3");
	}

	public String AddedQuantity() {
		return UpdatedQuantity.getText();
	}

	public void AddSameItemMultipleTimes(String product1) throws InterruptedException {
		int j = 0;
		int count = 0;

		do {
			// add same item multiple times to the cart
			searchbox.click();
			searchbox.sendKeys(product1);
			searchsumbitbutton.click();
			Thread.sleep(1000);
			Nthproduct.click();
			Thread.sleep(3000);
			// Loop for adding same item multiple times
			AddtoCart.click();
			Thread.sleep(1000);
			System.out.println(AddedtoCart.getText());

			System.out.println("product added  [" + ++count + "]time   to the cart");
			Thread.sleep(1000);
			CheckCart.click();
			// System.out.println( AddedtoCart.getText());
			// ((WebElement) productprice).getText();

			System.out.println("total product price is  :" + CartTotal.getText());
			System.out.println("--------------------------------------");
			j++;
		} while (j < 3);
		// find duplicate item in cart
		int result = itemincart.size();
		if (result > 1) {
			System.out.println("there is duplicate item in cart");
		} else {
			System.out.println("no duplicates in cart");
		}
		Thread.sleep(2000);
		// delete item in cart
		deleteprodincart.click();

		Thread.sleep(2000);
		System.out.println("item in the cart is deleted");

	}

	public void AddMultipleItemtocart(String product) throws InterruptedException {
		// add multiple items to the cart
		searchbox.click();
		searchbox.sendKeys(product);
		searchsumbitbutton.click();
		Thread.sleep(2000);
		System.out.println("product addded to the cart is:" + Nthproduct.getText());
		Nthproduct.click();
		Thread.sleep(3000);

		AddtoCart.click();
		Thread.sleep(1000);
		System.out.println(AddedtoCart.getText());

		System.out.println("product added to the cart");
		CheckCart.click();

		System.out.println("total product price is  :" + CartTotal.getText());
		System.out.println("--------------------------------------");
//print item in the cart
		Iterator<WebElement> iterateitemincart = itemincart.iterator();
		while (iterateitemincart.hasNext()) {
			WebElement product1 = iterateitemincart.next();
			System.out.println(product1.getText() + "     	product url is->" + product1.getAttribute("href"));
			System.out.println("------------------------------------");
		}

		// display product count in cart
		System.out.println("Count of Featured product in the cart is:" + itemincart.size());
	}

	public void RemoveSomeIteminCart() {
		int j = 0, count = 0;
		CartButton1.click();
		System.out.println("total price before deleting the product :" + CartTotal.getText());

		String TotalpriceBeforeDeletingtheProd = CartTotal.getText();
		do {
			driver.navigate().refresh();
			deleteprodincart1.click();
			System.out.println("product deleted  [" + ++count + "]time  from the cart");
			driver.navigate().refresh();
			j++;
		} while (j < 3);

		System.out.println("total price after deleting the product :" + CartTotal.getText());
		String TotalpriceAfterDeletingtheProd = CartTotal.getText();
		Assert.assertNotSame(TotalpriceBeforeDeletingtheProd, TotalpriceAfterDeletingtheProd);
	}

	public void RemoveAllIteminCart() throws InterruptedException {
		//check product size
		CartButton1.click();
		int IteminCart=itemincart.size();
		int j = IteminCart, count = 0;
		//CartButton1.click();

		do {
			System.out.println("total price before deleting the product :" + CartTotal.getText());

			@SuppressWarnings("unused")
			String TotalpriceBeforeDeletingtheProd = CartTotal.getText();
			driver.navigate().refresh();
			Thread.sleep(2000);
			deleteprodincart1.click();
			System.out.println("product deleted  [" + ++count + "]time  from the cart");
			String prodLeftAfterDeleting = ItemLeftIncart.getText();
			System.out.println("product Left after deleting :" + prodLeftAfterDeleting);
			j--;
		} while (j > 0);
		String actual = emptycartmessage.getText();
		System.out.println("cart message is" + actual);
		Assert.assertEquals(actual, "Your Amazon Cart is empty.");
	}

	public void ClickOnTheItemIntheCart() throws InterruptedException {
		CartButton1.click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		ItemIncart.click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

		String result = productdetails1.getText();
		System.out.println(result);

	}

}
