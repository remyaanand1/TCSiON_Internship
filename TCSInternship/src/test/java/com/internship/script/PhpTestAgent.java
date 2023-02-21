package com.internship.script;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.internship.pages.PhpAgentPage;

import com.internship.utilities.ExcelUtilities;

public class PhpTestAgent extends PhpBase{
PhpAgentPage phpAgent;
	
	@BeforeTest
	public void init() throws IOException
	{ 
		String url=ExcelUtilities.getcelldata("Agent_data", 0, 1);
		driver.get(url);
		phpAgent = new PhpAgentPage(driver);
	}
	@AfterTest
	public void end() throws IOException
	{ 
		phpAgent = null;
	}
	//LOGIN WITH INVALID USERNAME, PASSWORD
	  @Test  
	  public void validate_01_validateInValidlogin() throws IOException, InterruptedException
	  {
		  String userName=ExcelUtilities.getcelldata("Agent_data", 3, 1);
		  String pass=ExcelUtilities.getcelldata("Agent_data", 4, 1);
		  Thread.sleep(1000);
		  phpAgent.setUserName(userName);
		  phpAgent.setPassword(pass);
		  phpAgent.loginClick();
		  Thread.sleep(1000);
		  boolean valid=phpAgent.isInvalidLogIn();
		  
		  Assert.assertTrue(valid);
	  }
	
  @Test
  public void validate_02_validateLogin() throws IOException, InterruptedException {
	  String userName=ExcelUtilities.getcelldata("Agent_data", 1, 1);
	  String pass=ExcelUtilities.getcelldata("Agent_data", 2, 1);
	  Thread.sleep(2000);
	  phpAgent.setUserName(userName);
	  phpAgent.setPassword(pass);
	  phpAgent.loginClick();
	  Thread.sleep(2000);
	  boolean valid = phpAgent.isValidLogin();
	  assertTrue(valid);
	  
  }

  @Test
  public void validate_03_myBookings() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.mybookings();
	  
	  
   }
  
  @Test
  public void validate_04_addFunds() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.addfunds();
	  
	  
   }
  
  @Test
  public void validate_05_myProfile() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.myprofile();
	  
	  
   }
  
  
  @Test
  public void validate_07_homeLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  this.validate_02_validateLogin();
	  Thread.sleep(2000);
	  phpAgent.homelink();
	  
	  
   }
  
  @Test
  public void validate_08_hotelLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.hotellink();
	  
	  
   }
  
  @Test
  public void validate_09_flightLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.flightlink();
	  
	  
   }
  
  @Test
  public void validate_10_toursLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.tourslink();
	  
	  
   }
  
  @Test
  public void validate_11_visaLink() throws IOException, InterruptedException
  {
	  //this.validate_2_validateLogin();
	  Thread.sleep(2000);
	  phpAgent.visalink();
	  
	  
   }
  
  @Test
  public void validate_12_validateBlogLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.bloglink();
	  
	  
   }
  
  @Test
  public void validate_13_validateOffersLink() throws IOException, InterruptedException
  {
	  //this.validateLogin();
	  Thread.sleep(2000);
	  phpAgent.offerslink();
	  
	  
   }
  @Test
  public void validate_06_logOut() throws IOException, InterruptedException
  {
	  //this.validate_02_validateLogin();
	  Thread.sleep(2000);
	  phpAgent.logout();
	  
	  
   }
  
}
