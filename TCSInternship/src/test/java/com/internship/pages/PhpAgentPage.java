package com.internship.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpAgentPage {
	WebDriver driver;
	@FindBy(name="email")
	//@FindBy(css="input[placeholder='Email']")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/div[2]/div/form/div[3]/button")
	 WebElement login;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[2]/a") WebElement myBookings;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[3]/a") WebElement addFunds;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[4]/a") WebElement myProfile;
	
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[5]/a") WebElement logOut;	
		
	@FindBy(xpath="/html/body/div[4]/div/div[3]/ul/li[1]/a") WebElement homeLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[1]/a") WebElement hotelLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[2]/a") WebElement flightLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[3]/a") WebElement toursLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[5]/a") WebElement visaLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[6]/a") WebElement blogLink;
	
	@FindBy(xpath="/html/body/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[7]/a") WebElement offersLink;
	
	public PhpAgentPage (WebDriver driver)
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

	public void loginClick() throws InterruptedException
	{
		login.click();
		
		Thread.sleep(2000);
		
		//return !login.isDisplayed(); 
		
	}
	
	public boolean isValidLogin()
	{
		return myBookings.isDisplayed();
	}
	
	//LOGIN WITH INVALID USERNAME, PASSWORD
		public boolean isInvalidLogIn() {
					 
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
				
				//Element locator for LogOut Link
				public void logout() throws InterruptedException
				{
					logOut.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Home Link
				public void homelink() throws InterruptedException
				{
					homeLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Hotel Link
				public void hotellink() throws InterruptedException
				{
					hotelLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Flight Link
				public void flightlink() throws InterruptedException
				{
					flightLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Tours Link
				public void tourslink() throws InterruptedException
				{
					toursLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Visa Link
				public void visalink() throws InterruptedException
				{
					visaLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Blog Link
				public void bloglink() throws InterruptedException
				{
					blogLink.click();
					Thread.sleep(2000);
					
				}
				
				//Element locator for Offres Link
				public void offerslink() throws InterruptedException
				{
					offersLink.click();
					Thread.sleep(2000);
					
				}
}
