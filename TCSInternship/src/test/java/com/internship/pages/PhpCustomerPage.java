package com.internship.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpCustomerPage {
	WebDriver driver;
	@FindBy(id="ACCOUNT")
	WebElement account;
	@FindBy(linkText="Customer Login")
	WebElement customer;
	@FindBy(name="email")
	//@FindBy(css="input[placeholder='Email']")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[class*='btn-lg']")
	 WebElement login;
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[2]/a") WebElement myBookings;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[3]/a") WebElement addFunds;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[4]/a") WebElement myProfile;
	@FindBy(xpath="/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[1]/table/tbody/tr[11]/td[3]/div/input")
	WebElement profileAddress;
//	@FindBy(xpath="/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[3]/button")
//	
//	WebElement updateProfile;
	@FindBy(css="button[class*='theme-btn waves-effect']")
	 WebElement updateProfile;

	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[5]/a") WebElement logOut;	
	
	@FindBy(xpath="/html/body/section[1]/div/div[2]/div/div[1]/div/div/div[2]/div/table/tbody/tr/td[4]/div/a") 
	WebElement viewVoucher;
	
	public PhpCustomerPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	public void setUserName(String userName) throws InterruptedException
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
	
	email.clear();
	email.sendKeys(userName);
		
		 
	}
	public void setPassword(String pass) throws InterruptedException
	{
		password.clear();
		password.sendKeys(pass);
		  //Thread.sleep(200);
	}

	public void loginClick()
	{
		login.click();
	}
	//LOGIN WITH INVALID USERNAME, PASSWORD
	public boolean isInvalidLogIn() 
	{
	    boolean valid =login.isDisplayed();
		return valid;
	}
	//Element locator for My Bookings Link
	public boolean mybookings() throws InterruptedException
	{
		myBookings.click();
		Thread.sleep(2000);			
		return true;//dashbord.isDisplayed;
	}
	//Element locator for Add Funds Link
	public void addfunds() throws InterruptedException
	{
		addFunds.click();
		Thread.sleep(2000);
	}
	//Element locator for My Profile Link
	public void myprofile() throws InterruptedException
	{
		myProfile.click();
		Thread.sleep(2000);					
	}
	//Element locator for Update Address 
	public void updateAddress(String pass) throws InterruptedException
	{
		profileAddress.clear();
		profileAddress.sendKeys(pass);
		  //Thread.sleep(200);
	}
	//Element locator for Update Profile Link
	public void updateProfile() throws InterruptedException
	{
		updateProfile.submit();
		Thread.sleep(2000);					
	}
	//Element locator for LogOut Link
	public void logout() throws InterruptedException
	{
		logOut.click();
		Thread.sleep(2000);
	}
	//Element locator for ViewVoucher Link
	public void viewvoucher() throws InterruptedException
		{
			viewVoucher.click();
			Thread.sleep(2000);
		}
	}

