package pompackage;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.qa.base.Testbase;

public class PomSearchingSortingFiltering extends Testbase {
	/*
	 * @FindBy(css="#twotabsearchtextbox") WebElement searchbox;
	 */
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement category;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchsumbitbutton;
	@FindBy(xpath = "//*[@id=\"acrPopover\"]")
	WebElement review;
	@FindBy(xpath = "//span[contains(text(),'Mens Force Relaxed Fit Midweight Short Sleeve Pock')]")
	WebElement productresult;
	@FindBy(xpath = "//span[contains(text(),'results for')]")
	WebElement searchresult;
	@FindBy(xpath = "//div[@class='sg-col-inner']//div[@data-index='%d']")
	WebElement Nthproduct;
	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	List<WebElement> allproducts;
	// 60 element in the page
	@FindBy(xpath = "//span[contains(text(),\"Women's Clothing\")]")
	WebElement department;
	@FindBy(xpath = "//ul//li[@id='p_72/11192170011']")
	WebElement customerReview;
	@FindBy(xpath = "//*[@id=\"p_89/Tommy Hilfiger\"]/span/a/span")
	WebElement BrandTommyHilifier;
	@FindBy(xpath = "//span[contains(text(),\"Today's Deals\")]")
	WebElement TodaySDeals;
	@FindBy(xpath = "//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
	WebElement NextPage;
	@FindBy(xpath = "//span//span[*]/following-sibling::span[@class='s-pagination-item s-pagination-disabled']")
	// @FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[35]/div/div/span/span[2]")
	WebElement LastPage;
	@FindBy(xpath = "//span//span[@class='s-pagination-item s-pagination-next s-pagination-disabled ']")
	WebElement DisabledNextPage;
	@FindBy(xpath = "//div//span[@class='s-pagination-strip']//span[@class='s-pagination-item s-pagination-selected']")
	List<WebElement> CurrentPage;
	@FindBy(xpath = "//div//span//div[@data-component-type='s-search-result']")
	List<WebElement> productspage1;
	@FindBy(xpath = "//div//span//div[@data-component-type='s-search-result']")
	List<WebElement> consecutivePage;

	public String verify() {
		return driver.getTitle();
	}

	public PomSearchingSortingFiltering() {
		PageFactory.initElements(driver, this);

	}

	public void searchproduct() throws InterruptedException {

		Select categoryDropdown = new Select(category);
		Thread.sleep(1000);
		categoryDropdown.selectByIndex(11);
		searchsumbitbutton.click();
		String result = searchresult.getText();
		System.out.println("search result is:" + result);
		System.out.println("------------------------------------");
		// PomSearchingSortingFiltering a=new PomSearchingSortingFiltering();

	}

	public void getNthproduct(String productno) {
		//// span//div//div//div[@cel_widget_id='%s'
		//// ////div[@class='sg-col-inner']//span//div//div[@data-index='%s']
		//// div[@class='s-main-slot s-result-list s-search-results
		//// sg-row']//div[@data-index='%s']
		//// span//div[@class='s-main-slot s-result-list s-search-results
		//// sg-row']//div[@class='sg-col-inner']//div[@cel_widget_id='%s']

		// dynamic element id for products
		String xpathExpression = String
				.format("//div//span//div[@data-component-type=\"s-search-result\"][@data-cel-widget='%s']", productno);
		String nthproduct = driver.findElement(By.xpath(xpathExpression)).getText();

		// String nthproduct=Nthproduct.getText();
		System.out.println("product detail is-->" + nthproduct);
		System.out.println("------------------------------------");
	}

	public void getAllproducts() throws InterruptedException {//// span//div[@class='s-main-slot s-result-list
																//// s-search-results
																//// sg-row']//div[@class='sg-col-inner']
		// capture all element into list xpath("//span//div[@class='s-main-slot
		// s-result-list s-search-results sg-row']")
		// ////div//span//div[@data-component-type="s-search-result"]
		List<WebElement> allproducts = driver
				.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));

		/*
		 * capture text of all webelements into new(original) list (1st method)
		 * List<String>
		 * originalprodList=allproducts.stream().map(R->R.getText()).collect(Collectors.
		 * toList()); Thread.sleep(1000); System.out.println(originalprodList) ;
		 * System.out.println("---------------------------------");
		 */

		// using Iterating method(2nd method)
		Iterator<WebElement> iterateallproduct = allproducts.iterator();
		while (iterateallproduct.hasNext()) {
			WebElement product = iterateallproduct.next();
			System.out.println(product.getText() + "     	product url is->" + product.getAttribute("href"));
			System.out.println("------------------------------------");
		}

		// display product count
		System.out.println("Count of Featured product in the page is:" + allproducts.size());
	}

	/*
	 * public void validatesort() { //capture text of all webelements into
	 * new(original) list List<String>
	 * originalprodList=allproducts.stream().map(R->R.getText()).collect(Collectors.
	 * toList());
	 * List<String>sortedList=originalprodList.stream().sorted().collect(Collectors.
	 * toList()); //compare original list vs Sortedlist
	 * Assert.assertTrue(originalprodList.equals(sortedList)); }
	 */
	public void verifysort() throws NumberFormatException {
		Select s = new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
		s.selectByValue("price-asc-rank");
		try {
			List<WebElement> priceofallproduct = driver
					.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']"));
			List<String> webSortedPrices = priceofallproduct.stream().map(R -> R.getText())
					.collect(Collectors.toList());
			List<String> mySortedPrices = priceofallproduct.stream().map(R -> R.getText())
					.sorted(Comparator.comparingInt(Integer::valueOf)).collect(Collectors.toList());
			Assert.assertEquals(webSortedPrices, mySortedPrices, "Should be sorted from lower to highest price");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("NumberFormatException is handled");
		}
	}

	public void verifyfilter() throws InterruptedException {
		department.click();
		Thread.sleep(2000);
		customerReview.click();
		Thread.sleep(2000);
		BrandTommyHilifier.click();
		Thread.sleep(2000);
		// TodaySDeals.click();

		List<String> originalprodList1 = allproducts.stream().map(R -> R.getText()).collect(Collectors.toList());
		System.out.println("------------------------------------");
		System.out.println(originalprodList1);
		System.out.println("------------------------------------");
		System.out.println("Count of Filtrered product in the page is:" + originalprodList1.size());
		System.out.println("------------------------------------");
		/*
		 * List<String>
		 * FilteredProd=allproducts.stream().filter(s->s.getText().contains(
		 * "TommyHilifier")).collect(Collectors.toList());
		 * 
		 * /*for ( String elem : FilteredProd ) {
		 * System.out.println("filtered : "+elem); }
		 * /*System.out.println("------------------------------------");
		 * System.out.println(FilteredProd);
		 * System.out.println("------------------------------------");
		 * System.out.println("Count of Filtrered product in the page is:"+FilteredProd.
		 * size() ); System.out.println("------------------------------------");
		 */
		/*
		 * private static String getProduct(){ String
		 * getProduct=R.allproducts.getText(); return null; }
		 * 
		 * 
		 * //List<String>
		 * FilteredprodList=FilteredProd.stream().map(R->R.getText()).collect(Collectors
		 * .toList()); //System.out.println(FilteredProd);
		 * FilteredProd.forEach(a->System.out.println(a));
		 */
		// List<String> FilteredProd= allproducts.stream().filter(R ->
		// R.getText==department && R.getText() == BrandTommyHilifier)
		// .collect(Collectors.toList());

		/*
		 * return FilteredProd; for (String result:FilteredProd) {
		 * System.out.println(result.getText()); }
		 */

	}

	/*
	 * private String getProduct(WebElement s) {
	 * 
	 * @SuppressWarnings("unused") String getProduct=((WebElement)
	 * s.findElements(By.
	 * xpath("//span//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@class='sg-col-inner']"
	 * ))).getText(); return null; }
	 */
	public void verifypagination() throws InterruptedException {
		searchsumbitbutton.click();
		// null or empty string
		String last_page = "";
		try {
			last_page = LastPage.getText();
		} catch (NoSuchElementException ex) {
			System.out.println("last page number not found");
		}
		System.out.println("Last page number : " + last_page);
		int last = Integer.parseInt(last_page);
		System.out.println("last page number in integer:" + last);
		int count = 1, totalproductcount = 0;
		// locating next button
		// this for loop will run 1 to last page,number of times and it will increase
		// by1
		for (int i = 1; i <= last; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4000)");// this will scroll window by 1000 pixel in vertical
			Thread.sleep(5000);
			List<WebElement> allproducts1 = driver
					.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));
			// display product count
			int result1 = allproducts1.size();
			// product count of page [1] is: 60
			System.out.println("product count of page [" + count + "] is :" + result1);
			totalproductcount = totalproductcount + result1;// 0+60=60,60+60=120,....
			System.out.println("total product count of  [" + count + "] is :" + totalproductcount);
			System.out.println("--------------------------------------");

			try {
				Thread.sleep(1000); // nextpage.click();
				driver.findElement(By.xpath(
						"//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"))
						.click();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				System.out.println("next page not found");
			} catch (Exception a) {
				a.printStackTrace();
				System.out.println("next page not found");
			}
			count++;
		}
	}

	@SuppressWarnings("unused")
	public void findDuplicatesinPages() throws InterruptedException {
		searchsumbitbutton.click();
		/*
		 * List<WebElement> productspage1=driver.findElements(By.xpath(
		 * "//div//span//div[@data-component-type='s-search-result']")) ;
		 * List<WebElement> consecutivePage=driver.findElements(By.xpath(
		 * "//div//span//div[@data-component-type='s-search-result']")) ;
		 * 
		 * driver.findElement(By.
		 * xpath("//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"
		 * )).click();
		 */
		int consecutive_page = 2;
		/*
		 * try { consecutive_page=consecutivePage.getText(); }
		 * catch(NoSuchElementException ex) {
		 * System.out.println("consecutive page number not found"); }
		 * //System.out.println("consecutive page number : "+consecutive_page); //int
		 * last=Integer.parseInt(consecutive_page);
		 * System.out.println("last page number in integer:"+consecutive_page);
		 */
		int count = 1;
		int totalproductcount = 0;
		// locating next button
		// this for loop will run 1 to last page,number of times and it will increase
		// by1
		for (int i = 1; i <= consecutive_page; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4000)");// this will scroll window by 1000 pixel in vertical
			Thread.sleep(5000);
			List<WebElement> allproducts = driver
					.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));
			List<String> originalprodList = allproducts.stream().map(R -> R.getText()).collect(Collectors.toList());
			// List<WebElement>
			// dup=allproducts.stream().filter(e->Collections.frequency(allproducts,
			// e)>1).collect(Collectors.toList());
			Set<String> uniqueproduct = new HashSet<>();
			Set<String> duplicateproduct = originalprodList.stream().filter(product -> !uniqueproduct.add(product))
					.collect(Collectors.toSet());
			System.out.println("product count of page [" + count + "] is :" + allproducts.size());
			System.out.println("unique product is:" + uniqueproduct.size());
			System.out.println("duplicate product is:" + duplicateproduct.size());
			totalproductcount = totalproductcount + allproducts.size();// 0+60=60,60+60=120,....
			System.out.println("total product count of  [" + count + "] is :" + totalproductcount);
			System.out.println("--------------------------------------");
			/*
			 * List<String>
			 * originalprodList=allproducts.stream().map(R->R.getText()).collect(Collectors.
			 * toList()); System.out.println(originalprodList) ;
			 * System.out.println("---------------------------------"); int
			 * result1=allproducts.size(); //product count of page [1] is: 60
			 * System.out.println("product count of page ["+ count +"] is :"+ result1);
			 * totalproductcount=totalproductcount+result1;//0+60=60,60+60=120,....
			 * System.out.println("total product count of  ["+ count
			 * +"] is :"+totalproductcount);
			 * System.out.println("--------------------------------------"); /*boolean
			 * flag=false; for(int i=0;i<originalprodList.size();i++) { for(int
			 * j=i+1;j<originalprodList.size();j++) {
			 * if(originalprodList[i]==originalprodList[j]) { } }
			 */
			try {
				Thread.sleep(1000); // nextpage.click();
				driver.findElement(By.xpath(
						"//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"))
						.click();

			} catch (NoSuchElementException e) {
				e.printStackTrace();
				System.out.println("next page not found");
			} catch (Exception a) {
				a.printStackTrace();
				System.out.println("next page not found");
			}
			count++;

		}

	}
}
