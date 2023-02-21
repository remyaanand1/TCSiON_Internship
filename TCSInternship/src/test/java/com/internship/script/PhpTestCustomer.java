package com.internship.script;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.internship.pages.PhpCustomerPage;
import com.internship.utilities.ExcelUtilities;

public class PhpTestCustomer extends PhpBase{

	PhpCustomerPage phpCust;
	
	@BeforeMethod
	public void init() throws IOException
	{ 
		String url=ExcelUtilities.getcelldata("Customer_data", 0, 1);
		driver.get(url);
		phpCust = new PhpCustomerPage(driver);
	}
	@AfterTest
	public void end() throws IOException
	{ 
		phpCust = null;
	}
	//LOGIN WITH INVALID USERNAME, PASSWORD
	  @Test  
	  public void validate_01_validateInValidlogin() throws IOException, InterruptedException
	  {
		  String userName=ExcelUtilities.getcelldata("Customer_data", 3, 1);
		  String pass=ExcelUtilities.getcelldata("Customer_data", 4, 1);
		  Thread.sleep(1000);
		  phpCust.setUserName(userName);
		  phpCust.setPassword(pass);
		  phpCust.loginClick();
		  Thread.sleep(1000);
		  boolean valid=phpCust.isInvalidLogIn();
		  
		  Assert.assertTrue(valid);
	  }
	
  @Test
  public void validate_02_validateLogin() throws IOException, InterruptedException {
	  String userName=ExcelUtilities.getcelldata("Customer_data", 1, 1);
	  String pass=ExcelUtilities.getcelldata("Customer_data", 2, 1);
	  Thread.sleep(2000);
	  phpCust.setUserName(userName);
	  phpCust.setPassword(pass);
	  phpCust.loginClick();
	  
  }
  @Test
  public void validate_03_myBookings() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpCust.mybookings();
   }
  
  @Test
  public void validate_04_addFunds() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpCust.addfunds();
	  
	  
   }
  
  @Test
  public void validate_05_myProfile() throws IOException, InterruptedException
  {
	  //this.validate_02_validateLogin();
	  Thread.sleep(2000);
	  phpCust.myprofile();
	  String profileAddress=ExcelUtilities.getcelldata("Customer_data", 7, 1);
	  phpCust.updateAddress(profileAddress);
	  Thread.sleep(2000);
	  phpCust.updateProfile();
  }
  
  @Test
  public void validate_06_logOut() throws IOException, InterruptedException
  {
	  //this.validate_02_validateLogin();
	  Thread.sleep(2000);
	  phpCust.logout();
   }
  @Test
  public void validate_07_viewVoucher() throws IOException, InterruptedException
  {
	  this.validate_02_validateLogin();
	  Thread.sleep(2000);
	  phpCust.mybookings();
	  Thread.sleep(2000);
	  phpCust.viewvoucher();
	  Thread.sleep(2000);
   }
}
