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

public class LoginAndSecurityTest extends Testbase {
	PomSignin Signin;
	PomYourAccount YourAccount;
	PomYourAddress YourAddress;
	PomLoginandSecurity LoginandSecurity;

	public LoginAndSecurityTest() {
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
		LoginandSecurity = YourAccount.ClickonLoginandSecurity();
		// YourOrders.ClickonOrders();
		screenshots("Login And Security");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = LoginandSecurity.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon Change Name, E-mail, Password", " Login & security title is not matched");
	}

	/*
	 * @Test(priority=2) public void securitycheck() {
	 * 
	 * }
	 */
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
