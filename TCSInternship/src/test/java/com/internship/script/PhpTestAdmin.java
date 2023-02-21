package com.internship.script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internship.pages.PhpAdminPage;
import com.internship.utilities.ExcelUtilities;

public class PhpTestAdmin extends PhpBase {
PhpAdminPage phpAdmin;
	
	@BeforeMethod
	public void init() throws IOException
	{ 
		String url=ExcelUtilities.getcelldata("Admin_data", 0, 1);
		driver.get(url);
		phpAdmin = new PhpAdminPage(driver);
	}
	@AfterTest
	public void end() throws IOException
	{ 
		phpAdmin = null;
	}
	//LOGIN WITH INVALID USERNAME, PASSWORD
	  @Test  
	  public void validate_01_validateInValidlogin() throws IOException, InterruptedException
	  {
		  String userName=ExcelUtilities.getcelldata("Admin_data", 3, 1);
		  String pass=ExcelUtilities.getcelldata("Admin_data", 4, 1);
		  Thread.sleep(1000);
		  phpAdmin.setUserName(userName);
		  phpAdmin.setPassword(pass);
		  phpAdmin.loginClick();
		  Thread.sleep(1000);
		  boolean valid=phpAdmin.isInvalidLogIn();
		  
		  Assert.assertTrue(valid);
	  }
	
  @Test
  public void validate_02_validateLogin() throws IOException, InterruptedException {
	  String userName=ExcelUtilities.getcelldata("Admin_data", 1, 1);
	  String pass=ExcelUtilities.getcelldata("Admin_data", 2, 1);
	  Thread.sleep(2000);
	  phpAdmin.setUserName(userName);
	  phpAdmin.setPassword(pass);
	  phpAdmin.loginClick();
  }
  
  @Test
  public void validate_04_bookingLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAdmin.bookingLink();
	  
	  
   }
  
  @Test
  public void validate_05_bookingInvoice() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAdmin.bookingLink();
	  Thread.sleep(2000);
	  phpAdmin.paidStatus();
	  Thread.sleep(2000);
	  phpAdmin.showInvoice();
	}
  
  @Test
  public void validate_06_validatePendingCount() throws IOException, InterruptedException
  {
	  int pendingCountBefore = 0;
	  int confirmedCountBefore = 0;
	  int pendingCountAfter = 0;
	  int confirmedCountAfter = 0;

	  //this.validateLogin();
	  Thread.sleep(2000);
	  pendingCountBefore = phpAdmin.getPendingCount();
	  confirmedCountBefore = phpAdmin.getConfirmedCount();
	  phpAdmin.pendingBooking();
	  Thread.sleep(2000);
	  phpAdmin.doBooking();

	  Thread.sleep(2000);
	  phpAdmin.dashboardLink();
	  Thread.sleep(2000);

	  pendingCountAfter = phpAdmin.getPendingCount();
	  confirmedCountAfter = phpAdmin.getConfirmedCount();

	  System.out.println("Pend Cnt before: " + pendingCountBefore + ", Confirm Cnt before: " + confirmedCountBefore + "\n Pending cnt After: " + pendingCountAfter + ",  confirm cnt after: " + confirmedCountAfter );

	  assertTrue(pendingCountBefore > pendingCountAfter);
	  assertTrue(confirmedCountBefore < confirmedCountAfter);
	  assertEquals(pendingCountBefore + confirmedCountBefore, pendingCountAfter + confirmedCountAfter);
	  
  }
  
  @Test
  public void validate_03_websiteLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAdmin.websiteLink();
	  
	  
   }
  
}
