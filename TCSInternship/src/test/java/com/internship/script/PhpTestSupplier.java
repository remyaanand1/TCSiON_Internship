package com.internship.script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.internship.pages.PhpSupplierPage;
import com.internship.utilities.ExcelUtilities;

public class PhpTestSupplier extends PhpBase {

	PhpSupplierPage phpSupp;
	
	@BeforeTest
	public void init() throws IOException
	{ 
		String url=ExcelUtilities.getcelldata("Supplier_data", 0, 1);
		driver.get(url);
		phpSupp = new PhpSupplierPage(driver);
	}
	
	@AfterTest
	public void end() throws IOException
	{ 
		phpSupp = null;
	}

  @Test
  public void validate_1_InValidlogin() throws IOException, InterruptedException
  {
	  
	  String userName=ExcelUtilities.getcelldata("Supplier_data", 3, 1);
	  String pass=ExcelUtilities.getcelldata("Supplier_data", 4, 1);
	  
	  System.out.println(userName);
	  Thread.sleep(1000);
	  phpSupp.setUserName(userName);
	  phpSupp.setPassword(pass);
	  phpSupp.loginClick();

	  boolean valid=phpSupp.isInvalidLogIn();
	  
	  Assert.assertTrue(valid);
	  
	  
  }

	
  @Test
  public void validate_2_Login() throws IOException, InterruptedException {

	  
	  String userName=ExcelUtilities.getcelldata("Supplier_data", 1, 1);
	  String pass=ExcelUtilities.getcelldata("Supplier_data", 2, 1);
	  Thread.sleep(2000);
	  phpSupp.setUserName(userName);
	  phpSupp.setPassword(pass);
	  phpSupp.loginClick();
	  Thread.sleep(2000);
	  boolean valid = phpSupp.isValidLogin();
	  assertTrue(valid);


  }

  
//LOGIN WITH INVALID USERNAME, PASSWORD
  @Test
  public void validate_3_DashboardView() throws IOException, InterruptedException
  {
	  Thread.sleep(2000);
	 // this.validateLogin();
	  
	  Assert.assertTrue(phpSupp.isSalesPresent());
	  
	  
  }

  @Test
  public void validate_4_DashboardLink() throws IOException, InterruptedException
  {

	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpSupp.dashboardLink();
	  Assert.assertTrue(phpSupp.isSalesPresent());


  }

  
  @Test
  public void validate_5_RevenueView() throws IOException, InterruptedException
  {

//	  this.validateLogin();
	  
	  Assert.assertTrue(phpSupp.isRevenuePresent());
	  

  }
  
  
  @Test
  public void validate_6_ToursLink() throws IOException, InterruptedException
  {


//	  this.validateLogin();
	  Thread.sleep(2000);
	  phpSupp.toursLink();
	  
	  
   }
  
  @Test
  public void validate_7_ManageTours() throws IOException, InterruptedException
  {

//	  this.validateLogin();
	  Thread.sleep(2000);
	  phpSupp.manageTours();


  }

  @Test
  public void validate_8_PendingCount() throws IOException, InterruptedException
  {
	  int pendingCountBefore = 0;
	  int confirmedCountBefore = 0;
	  int pendingCountAfter = 0;
	  int confirmedCountAfter = 0;

	  
	  
//	  this.validateLogin();
	  this.validate_4_DashboardLink();
	  Thread.sleep(2000);
	  pendingCountBefore = phpSupp.getPendingCount();
	  confirmedCountBefore = phpSupp.getConfirmedCount();
	  phpSupp.pendingBooking();
	  Thread.sleep(2000);
	  phpSupp.doBooking();

	  Thread.sleep(2000);
	  phpSupp.dashboardLink();
	  Thread.sleep(2000);

	  pendingCountAfter = phpSupp.getPendingCount();
	  confirmedCountAfter = phpSupp.getConfirmedCount();

	  System.out.println("Pend Cnt before: " + pendingCountBefore + ", Confirm Cnt before: " + confirmedCountBefore + "\n Pending cnt After: " + pendingCountAfter + ",  confirm cnt after: " + confirmedCountAfter );

	  assertTrue(pendingCountBefore > pendingCountAfter);
	  assertTrue(confirmedCountBefore < confirmedCountAfter);
	  assertEquals(pendingCountBefore + confirmedCountBefore, pendingCountAfter + confirmedCountAfter);
	  

  }

  
}


