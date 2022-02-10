package com.pom.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.baseclass.selenium.SeleniumSimpleWebDriverManager;
import com.relevantcodes.extentreports.LogStatus;

public class PageGoogle {

	protected WebDriver driver;
	private By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
	private By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");

	static final Logger logger = LogManager.getLogger(PageGoogle.class);

	public PageGoogle(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("Google")) {
			logger.error("Google Title pass");
			throw new IllegalStateException(
					"This is not Home Page of logged in user," + " current page is: " + driver.getCurrentUrl());
		} else {
			logger.info("Google Title pass");
		}

	}

	/**
	 * Get message (h1 tag)
	 *
	 * @return String message text
	 */
	public String getMessageText() {

		String title = driver.getTitle();
		logger.info("title is " + title);
		return title;
	}

	public PageGoogle manageProfile() {
		// Page encapsulation to manage profile functionality
		return new PageGoogle(driver);
	}
	/*
	 * More methods offering the services represented by Home Page of Logged User.
	 * These methods in turn might return more Page Objects for example click on
	 * Compose mail button could return ComposeMail class object
	 */

	public String checkGmailLink() {
		return driver.findElement(gmailLink).getAttribute("text");

	}

	public String checkImagesLink() {
		return driver.findElement(imagesLink).getAttribute("text");	
	}
	
	
	

}
