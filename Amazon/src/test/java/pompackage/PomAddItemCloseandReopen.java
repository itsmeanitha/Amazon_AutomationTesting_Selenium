package pompackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.qa.base.Testbase;

public class PomAddItemCloseandReopen extends Testbase {
	@FindBy(css="#twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchsumbitbutton;
	@FindBy(xpath="//*[@id=\"acrPopover\"]")
	WebElement review;
	@FindBy(xpath="//span[contains(text(),'Mens Force Relaxed Fit Midweight Short Sleeve Pock')]")
	WebElement productresult;
	@FindBy(xpath="//div//span//div[@data-component-type='s-search-result']//div[@cel_widget_id='MAIN-SEARCH_RESULTS-22']")
	WebElement Nthproduct;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement AddtoCart;
	@FindBy(xpath="//span[contains(text(),'Added to Cart')]")
	WebElement AddedtoCart;
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement CartButton;
	@FindBy(xpath="//a[contains(text(),'Go to cart')]")
	WebElement CheckCart;
	@FindBy(xpath="//div[@id='sc-retail-cart-container']//div[1]//div[2]//div[@data-name='Active Items']//div[@data-itemtype='active']")
	List<WebElement> itemincart;
	
	   public PomAddItemCloseandReopen () {
   		PageFactory.initElements(driver, this);
	   }
	   
	   
	   public void closeReopenTest() throws InterruptedException {
		 
		 Thread.sleep(3000);
		 //open new tab
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.open();");
		 Thread.sleep(2000);
		 //get tab details
		Set<String> windowHandles=driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		//code to be executed in tab2
		driver.get("https://www.amazon.ca/");
		Thread.sleep(2000);
		  searchbox.click();
		   searchbox.sendKeys("cumin seeds");
  		searchsumbitbutton.click();
		System.out.println("product addded to the cart is:"+Nthproduct.getText());
		 Nthproduct.click();
	AddtoCart.click();
	System.out.println( "product "+ AddedtoCart.getText());
				  CheckCart.click();
			  int productSizeInwindow1=itemincart.size();
		 System.out.println("Count of Featured product in the cart before closing the browser is:"+productSizeInwindow1 );
			System.out.println("--------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.close(); 
		//driver.switchTo().window(list.get(0));
		  
		Set<String> windowHandles2=driver.getWindowHandles();
		 list.clear();
		 list.addAll(windowHandles2);
		 driver.switchTo().window(list.get(0));
		 //code to be executed in Tab1
		 System.out.println(driver.getCurrentUrl());
			//driver.navigate().to("https://www.amazon.ca/gp/cart/view.html?ref_=ewc_gtc");
		 Thread.sleep(2500);
		 driver.navigate().refresh();
		 Thread.sleep(2500);
			CartButton.click();
			Thread.sleep(2000);
			 int productSizeInwindow2=itemincart.size();
			 System.out.println("Count of Featured product when reopening the browser is:"+productSizeInwindow2);
				System.out.println("--------------------------------------");
   		Assert.assertEquals(productSizeInwindow1, productSizeInwindow2);
}}
