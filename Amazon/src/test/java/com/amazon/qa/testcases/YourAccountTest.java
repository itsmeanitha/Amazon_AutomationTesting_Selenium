package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomLoginandSecurity;
import pompackage.PomSignin;
import pompackage.PomYourAccount;
import pompackage.PomYourAddress;
import pompackage.PomYourOrders;
import pompackage.PomYourPayment;

public class YourAccountTest extends Testbase {

	PomSignin Signin;
	PomYourAccount YourAccount;
	PomYourOrders YourOrders;
	PomYourAddress YourAddress;
	PomLoginandSecurity LoginandSecurity;
	PomYourPayment YourPayment;

	public YourAccountTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Signin = new PomSignin();
		// SignIn=new PomCreateAccount();
		// SignIn.act();
		// YourAccount=SignIn.login(prop.getProperty("name"),prop.getProperty("emailormob"),prop.getProperty("pass"),prop.getProperty("passA"));
		YourAccount = Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));
		YourAccount.act1();
		screenshots("YourAccount");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = YourAccount.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Account", "YourAccountpage title is not matched");
	}

	/*
	 * @DataProvider public Object[][] details(){ Object
	 * result[][]=ExcelSheet.readdata("Sheet1"); return result; }
	 */
	@Test(priority = 2)

	public void getUserNameTest() {

		System.out.println(YourAccount.getuserNameLabel());
	}

	@Test(priority = 3)
	public void verifyUserNameTest() {
		Assert.assertTrue(YourAccount.verifyuserNameLabel());

	}

	@Test(priority = 4)
	public void testYourOrdersPage() {
		YourOrders = YourAccount.ClickonYourOrders();
	}

	@Test(priority = 5)
	public void testYourAddressPage() {
		YourAddress = YourAccount.ClickonYourAddress();
	}

	@Test(priority = 6)
	public void testLoginandSecurityPage() {
		LoginandSecurity = YourAccount.ClickonLoginandSecurity();
	}

	@Test(priority = 7)
	public void testYourPaymentPage() {
		YourPayment = YourAccount.ClickonYourPayments();
	}

	@AfterMethod
	public void close() {

		driver.quit();

	}

}
