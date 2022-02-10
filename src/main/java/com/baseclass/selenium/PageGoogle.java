package com.baseclass.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class PageGoogle {

	protected WebDriver driver;
	private By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
	private By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");

	public PageGoogle(WebDriver driver) {
		this.driver = driver;
	    if (!driver.getTitle().equals("Google")) {
	        throw new IllegalStateException("This is not Home Page of logged in user," +
	              " current page is: " + driver.getCurrentUrl());
	      } else {
	    	  System.out.println("Current Page : "+driver.getTitle());
	      }
	}

	public String googleHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnGmailLink() {
		driver.findElement(gmailLink).click();
	}

	
	
	public void clickOnImages() {
			driver.findElement(imagesLink).click();
	}
}
