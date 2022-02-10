package com.baseclass.basic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGoogleTestsLocators {

	private WebDriver driver;

	@Test
	public void testGoogle() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");
		driver.findElement(imagesLink).click();

		driver.navigate().back(); // use to navigate back to Google home page.

		By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
		driver.findElement(gmailLink).click();


		// expand Test automation for other elements in the google page - About, Store, Google Search
		// Button , I'm Feeling Lucky , Advertising, Business ... Settings.
	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
