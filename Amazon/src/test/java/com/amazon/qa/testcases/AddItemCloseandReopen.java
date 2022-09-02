package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.Testbase;

import pompackage.PomAddItemCloseandReopen;

public class AddItemCloseandReopen extends Testbase{
	PomAddItemCloseandReopen AddItemCloseandReopen;
	public AddItemCloseandReopen() {
		super();
	}
	@BeforeMethod
	public void initseup() throws InterruptedException {
	initiation();
	Thread.sleep(500);
	screenshots("Shopping cart");
}
	
	
	
	
	
	
	
	
	@Test
	public void verifyCloseReopen() throws InterruptedException  {
		AddItemCloseandReopen=new PomAddItemCloseandReopen();
		AddItemCloseandReopen.closeReopenTest();

}
	
	@AfterMethod  
	public void close() {
		driver.quit();
	}
}
