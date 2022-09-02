package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomCreateAccount;
import pompackage.PomYourAccount;

public class CreateAccountTest extends Testbase {
	PomCreateAccount SignIn;
	PomYourAccount YourAccount;

	public CreateAccountTest() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		SignIn = new PomCreateAccount();
		// SignIn.act();
		screenshots("continue");
	}

	@Test(priority = 1)
	public void Title() {
		String actual = SignIn.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon Registration");
	}

	/*
	 * @DataProvider public Object[][] details(){ Object
	 * result[][]=ExcelSheet.readdata("Sheet1"); return result; }
	 */
	@Test(priority = 2)
	/*
	 * public void continuebn(String name,String mobilenoemail,String pass,String
	 * passA) throws InterruptedException { continuebn.typeyourname(name) ;
	 * Thread.sleep(2500);//(prop.getProperty("username")); //calling it from
	 * config.properties continuebn.typemobilenooremail(mobilenoemail);
	 * Thread.sleep(2500); continuebn.typepassword(pass); Thread.sleep(2500);
	 * continuebn.typepasswordagain(passA); Thread.sleep(2500);
	 * //continuebn.clickbtn();
	 */
	public void login() throws InterruptedException {
		YourAccount = SignIn.login(prop.getProperty("name"), prop.getProperty("emailormob"), prop.getProperty("pass"),
				prop.getProperty("passA"));
		// YourAccount=SignIn.login1(prop.getProperty("emailormob"),prop.getProperty("pass"));
	}

	@Test(priority = 3)
	public void verifylogo() {
		SignIn.validatestoreLogo();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
