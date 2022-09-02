package com.amazon.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amazon.qa.base.Testbase;

import pompackage.PomSearchingSortingFiltering;
import pompackage.PomSignin;
import pompackage.PomYourAccount;

public class SearchingSortingFilteringTest extends Testbase {
	PomSearchingSortingFiltering SearchingSortingFiltering;

	PomSignin Signin;
	PomYourAccount YourAccount;

	public SearchingSortingFilteringTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		// SearchingSortingFiltering.search(prop.getProperty("product"));
		Signin = new PomSignin();
		// SignIn.act();
		YourAccount = Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));
		Thread.sleep(500);

		screenshots("Searching");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = SearchingSortingFiltering.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, prop.getProperty("productPageTitle"), "Product Page Title is not matched");
	}

	@Test(priority = 2)
	public void search() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();

		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(1000);
		SearchingSortingFiltering.getNthproduct(prop.getProperty("productno"));
//SearchingSortingFiltering.getAllproducts();
	}

	@Test(priority = 3)
	public void GetAllProduct() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();

		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(1000);
//SearchingSortingFiltering.getNthproduct(prop.getProperty("productno"));
		SearchingSortingFiltering.getAllproducts();
	}

	@Test(priority = 4)
	public void verifysortingFunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(1000);
		SearchingSortingFiltering.verifysort();
	}

	@Test(priority = 5)
	public void verifyFilterfunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		SearchingSortingFiltering.verifyfilter();
	}

	@Test(priority = 6)
	public void verifyPaginationfunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product1"));

		SearchingSortingFiltering.verifypagination();
	}

	@Test(priority = 7)
	public void verifyfindDuplicatesinPages() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.verifysearch(prop.getProperty("product1"));

		SearchingSortingFiltering.findDuplicatesinPages();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}