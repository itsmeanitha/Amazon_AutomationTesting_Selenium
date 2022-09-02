package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomSignin;
import pompackage.PomYourAccount;
import pompackage.PomYourAddress;

public class YourAddressTest extends Testbase {

	PomSignin Signin;
	PomYourAccount YourAccount;
	PomYourAddress YourAddress;

	public YourAddressTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		Signin = new PomSignin();
		// SignIn.act();
		YourAccount = Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));

		// YourAccount=SignIn.login(prop.getProperty("name"),prop.getProperty("emailormob"),prop.getProperty("pass"),prop.getProperty("passA"));
		YourAccount.act1();
		YourAddress = YourAccount.ClickonYourAddress();
		// YourOrders.ClickonOrders();
		screenshots("YourAddress");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = YourAddress.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Addresses", "YourOrderpage title is not matched");
	}

	@Test(priority = 2)
	public void AddAddress() {
		Assert.assertTrue(YourAddress.verifyAddAddress());
	}

	@Test(priority = 3)
	public void DefaultAddress() {
		Assert.assertTrue(YourAddress.verifyDefaultAddress());
	}

	@Test(priority = 4, enabled = false)
	public void addaddress() throws InterruptedException {

		YourAddress.addingAaddress(prop.getProperty("name"), prop.getProperty("emailormob"),
				prop.getProperty("Addresslinea"), prop.getProperty("Addresslineb"), prop.getProperty("cityis"),
				prop.getProperty("Postal"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
