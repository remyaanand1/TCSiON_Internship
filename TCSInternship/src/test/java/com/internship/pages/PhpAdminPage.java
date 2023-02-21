package com.internship.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpAdminPage {
	WebDriver driver;
	@FindBy(name="email")
	//@FindBy(css="input[placeholder='Email']")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[class*='btn-block']")
	 WebElement login;
	
	@FindBy(xpath="//div[text()='Dashboard']")
	WebElement dashboardlink;
	
	@FindBy(xpath="/html/body/nav/div/div/ul/li[2]/a")  WebElement bookingLink;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[12]/select")
	WebElement paidStatus;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[14]/a")
	WebElement displayInvoice;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[2]/a/div/div/div/div[1]/div[1]") WebElement pendingCount;
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[1]/a/div/div/div/div[1]/div[1]") WebElement confirmedCount;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[2]/a/div/div/div/div[1]/div[2]") WebElement pendingBooking;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[11]/select") WebElement bookingStatus;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[11]/select/option[2]") WebElement bookingStatusConfirm;
	
	@FindBy(xpath="/html/body/nav/div/div/ul/li[1]/a") WebElement websiteLink;
	
	
	public PhpAdminPage (WebDriver driver)
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
		public boolean isInvalidLogIn() {
					 
			boolean valid =login.isDisplayed();
			return valid;
		}
	//Element locator for Booking Link
			public void bookingLink() throws InterruptedException
			{
				bookingLink.click();
				Thread.sleep(2000);
				
			}
			
	//Element locator for Payment Status-Paid
			public boolean paidStatus()
			{
				boolean valuePaid =paidStatus.isDisplayed();
				
				if( valuePaid == true )
				{
					String headingPaid=paidStatus.getText();
					
					return ( headingPaid.equals("Paid"));
					
				}
				
				return false;
			}
	
			//Element locator for Booking Link
			public void showInvoice() throws InterruptedException
			{
				displayInvoice.click();
				Thread.sleep(2000);
				
			}
			//Element locator for Dashboard Link
			public void dashboardLink()
			{
				dashboardlink.click();
			}
			
			public int getPendingCount()
			{
				return (Integer.parseInt(pendingCount.getText()));
			}
			
			public int getConfirmedCount()
			{
				return (Integer.parseInt(confirmedCount.getText()));
			}
			
			public void pendingBooking() throws InterruptedException
			{
				pendingBooking.click();
			}

			public void doBooking() throws InterruptedException
			{
				bookingStatus.click();
				Thread.sleep(1000);
				bookingStatusConfirm.click();
			}

			//Element locator for Website Link
			public void websiteLink() throws InterruptedException
			{
				websiteLink.click();
				Thread.sleep(2000);
				
			}
}
