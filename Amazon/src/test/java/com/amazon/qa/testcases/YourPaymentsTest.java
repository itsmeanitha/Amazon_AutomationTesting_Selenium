package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomSignin;
import pompackage.PomYourAccount;

import pompackage.PomYourPayment;

public class YourPaymentsTest extends Testbase {
	PomSignin Signin;
	PomYourAccount YourAccount;

	PomYourPayment YourPayment;

	public YourPaymentsTest() {
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
		YourPayment = YourAccount.ClickonYourPayments();
		// YourOrders.ClickonOrders();
		screenshots("YourPayment");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = YourPayment.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Payments", "Your Payment page title is not matched");
	}

	@Test(priority = 2)
	public void addpayment() {
		YourPayment.addcard(prop.getProperty("cardnumber"), prop.getProperty("nameoncard"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
