package com.internship.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpSupplierPage {
	WebDriver driver;
	@FindBy(name="email")
	//@FindBy(css="input[placeholder='Email']")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[class*='btn-block']")
	 WebElement login;
	
	@FindBy(xpath="//div[text()='Sales overview & summary']")
	WebElement salestext;
	
	@FindBy(xpath="//h2[text()='Revenue Breakdown 2023']")
	WebElement revenuetext;
	
	@FindBy(xpath="//div[text()='Dashboard']")
	WebElement dashboardlink;
	
	@FindBy(xpath="//*[@id=\"drawerAccordion\"]/div/div/a[6]") WebElement toursLink;
	
	//@FindBy(xpath="//*[@id=\\\"drawerAccordion\"]/div/div/a[6]") WebElement toursLink1;
	@FindBy(xpath="/html/body/div[2]/div[1]/nav/div/div/div[9]/nav/a") WebElement toursLink1;
	
	@FindBy(xpath="//*[@id=\"Tours\"]/nav/a[1]") WebElement manageTours;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[2]/a/div/div/div/div[1]/div[1]") WebElement pendingCount;
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[1]/a/div/div/div/div[1]/div[1]") WebElement confirmedCount;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div[2]/a/div/div/div/div[1]/div[2]") WebElement pendingBooking;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[11]/select") WebElement bookingStatus;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/main/div/div[2]/div/div/div[2]/table/tbody/tr[1]/td[11]/select/option[2]") WebElement bookingStatusConfirm;
	
	public PhpSupplierPage (WebDriver driver)
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
	
	public boolean isValidLogin()
	{
		return dashboardlink.isDisplayed();
	}

	
	//LOGIN WITH INVALID USERNAME, PASSWORD
	public boolean isInvalidLogIn() {
				 
		boolean valid =login.isDisplayed();
		return valid;
	}
	
	//Element locator for Sales Overview and Summary
	public boolean isSalesPresent()
	{
		boolean valuehead =salestext.isDisplayed();
		
		if( valuehead == true )
		{
			String headingText=salestext.getText();
			
			return ( headingText.equals("Sales overview & summary"));
			
		}
		
		return false;
	}
	
	//Element locator for Revenue Breakdown 2023
		public boolean isRevenuePresent()
		{
			boolean valuerevenue =revenuetext.isDisplayed();
			
			if( valuerevenue == true )
			{
				String headingRevenue=revenuetext.getText();
				
				return ( headingRevenue.equals("Revenue Breakdown 2023"));
				
			}
			
			return false;
		}
		
		//Element locator for Dashboard Link
		public void dashboardLink()
		{
			dashboardlink.click();
		}
		
		//Element locator for Tours Dropdown Link
		public void toursLink() throws InterruptedException
		{
			toursLink.click();
			Thread.sleep(1000);
			toursLink1.click();

		}
		public void toursLink1() throws InterruptedException
		{
			toursLink1.click();
			Thread.sleep(1000);

		}
		public void manageTours() throws InterruptedException
		{
			manageTours.click();

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

}



