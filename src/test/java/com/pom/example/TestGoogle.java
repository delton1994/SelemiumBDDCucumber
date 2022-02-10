package com.pom.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGoogle {
	WebDriver driver;
	PageGoogle pgGoogle;
	
	
	public TestGoogle() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		pgGoogle = new PageGoogle(driver);		
	}

//	@BeforeClass
//	void startTest() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		pgGoogle = new PageGoogle(driver);
//	}

	@Test(priority = 1)
	public void testGoogleTitle() {		
		String actual = pgGoogle.getMessageText();
		String expected = "Google";
		Assert.assertEquals(actual, expected);

	}
	
	@Test(priority = 2)
	public void testGoogleTitleShortVersion() {
		Assert.assertEquals(pgGoogle.getMessageText(), "Google");
	}
	
	@Test(priority = 3)
	public void testGmailLink() {
		Assert.assertEquals(pgGoogle.checkGmailLink(), "Gmail");
	}

	@Test(priority = 4)
	public void testImagesLink() {
		Assert.assertEquals(pgGoogle.checkImagesLink(), "Images");
	}

	@AfterClass
	void afterTest() {
		driver.close();
		driver.quit();
	}

}
