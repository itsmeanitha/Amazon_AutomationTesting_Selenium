package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomSearchingSortingFiltering;
import pompackage.PomShoppingCart;
import pompackage.PomSignin;
import pompackage.PomYourAccount;
import testdata.ExcelSheet1;

public class ShoppingCartTest extends Testbase {
	PomSearchingSortingFiltering SearchingSortingFiltering;
	PomShoppingCart ShoppingCart;
	PomSignin Signin;
	PomYourAccount YourAccount;
	pompackage.WebDriverSingleton AddSameItemMultipleTimes1;

	public ShoppingCartTest() {
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

		screenshots("Shopping cart");
	}

	@Test(priority = 4)
	public void Title() {
		ShoppingCart = new PomShoppingCart();
		YourAccount.ClickOnCart();
		String actual = ShoppingCart.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca Shopping Cart", "YourAccountpage title is not matched");
	}

	@Test(priority = 1)
	public void verifyAddToCart() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();

		YourAccount.verifysearch(prop.getProperty("product1"));
		Thread.sleep(1000);
		ShoppingCart = new PomShoppingCart();
		ShoppingCart.AddToCart();
		Assert.assertEquals(ShoppingCart.AddedToCart(), "Added to Cart");

	}

	@Test(priority = 2)
	public void verifyAddQuantity() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();
		ShoppingCart = new PomShoppingCart();
		ShoppingCart.addquantity();
		Assert.assertEquals(ShoppingCart.AddedQuantity(), "Qty:3");
	}

	@Test(priority = 3)
	public void verifyAddSameItemMultipleTimes() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();

		ShoppingCart.AddSameItemMultipleTimes(prop.getProperty("product1"));

	}

	@DataProvider
	public Object[][] prod() {
		Object result[][] = ExcelSheet1.readdata("Sheet1");
		return result;
	}

	@Test(priority = 5, dataProvider = "prod")
	public void verifyAddMultipleItem(String product) throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.AddMultipleItemtocart(product);
	}

	@Test(priority = 6)
	public void verifyRemoveSomeIteminCart() {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.RemoveSomeIteminCart();
	}

	@Test(priority = 7)
	public void verifyRemoveAllIteminCart() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.RemoveAllIteminCart();
	}

	@Test(priority = 8)
	public void verifyClickOnTheItemIntheCart() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.ClickOnTheItemIntheCart();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
