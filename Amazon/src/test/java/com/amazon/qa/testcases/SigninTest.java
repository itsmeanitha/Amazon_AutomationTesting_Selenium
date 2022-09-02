package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomSignin;
import pompackage.PomYourAccount;

public class SigninTest extends Testbase {
	
	PomSignin Signin;
	PomYourAccount YourAccount;

	public SigninTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Signin = new PomSignin();
		// SignIn.act();
		//screenshots("Signin");
	}

	/*
	 * @Test(priority=1) public void Title() { String actual=Signin.verify();
	 * System.out.println(actual); Assert.assertEquals(actual,
	 * "Amazon.ca: Low Prices � Fast Shipping � Millions of Items"); }
	 */
	@Test(priority = 2)
	public void login() throws InterruptedException {
		YourAccount = Signin.login(prop.getProperty("emailormob"), prop.getProperty("pass"));
		screenshots("Signin");
	}

	@Test(priority = 3)
	public void verifylogo() {
		Signin.validatestoreLogo();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
